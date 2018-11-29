package by.bsuir.markovsky.nursewebapp.controller.order;

import by.bsuir.markovsky.nursewebapp.constant.HTMLConstant;
import by.bsuir.markovsky.nursewebapp.constant.MappingConstant;
import by.bsuir.markovsky.nursewebapp.exception.NotFoundException;
import by.bsuir.markovsky.nursewebapp.model.Nurse;
import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
import by.bsuir.markovsky.nursewebapp.service.NurseOrderService;
import by.bsuir.markovsky.nursewebapp.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class NurseOrderController {

    @Autowired
    @Qualifier("nurseOrderService")
    private NurseOrderService nurseOrderService;

    @Autowired
    @Qualifier("nurseService")
    private NurseService nurseService;

    @RequestMapping(value = MappingConstant.ADD_SERVICE, method = RequestMethod.GET)
    public ModelAndView addOrderPage(Model model) {
        model.addAttribute("order", new NurseOrder());
        return new ModelAndView(HTMLConstant.SERVICE_PAGE_ADD);
    }

    @RequestMapping(value = MappingConstant.EDIT_SERVICE, method = RequestMethod.GET)
    public ModelAndView editOrderPage(@PathVariable("id") int id, Model model) {
        NurseOrder order = nurseOrderService.getOrderById(id);
        model.addAttribute("order", order);
        return new ModelAndView(HTMLConstant.SERVICE_PAGE_EDIT);
    }
    
    @RequestMapping(value = MappingConstant.ADD_SERVICE, method = RequestMethod.POST, params = "add")
    public String addOrder(@Valid @ModelAttribute(value = "order") NurseOrder order,
                           BindingResult bindingResult, Principal principal) throws NotFoundException {
        if (bindingResult.hasErrors()) {
            return HTMLConstant.SERVICE_PAGE_ADD;
        }
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        Nurse nurse = nurseService.getNurseByUsername(loginedUser.getUsername());
        if (nurse == null) {
            throw new NotFoundException();
        }
        nurseOrderService.addOrder(order, nurse);
        return "redirect:" + MappingConstant.SERVICE;
    }

    @RequestMapping(value = MappingConstant.ADD_SERVICE, method = RequestMethod.POST, params = "edit")
    public String editOrder(@Valid @ModelAttribute(value = "order") NurseOrder order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return HTMLConstant.SERVICE_PAGE_EDIT;
        }
        nurseOrderService.updateOrder(order);
        return "redirect:" + MappingConstant.SERVICE;
    }

}
