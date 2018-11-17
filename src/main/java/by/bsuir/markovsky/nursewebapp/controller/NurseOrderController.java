package by.bsuir.markovsky.nursewebapp.controller;

import by.bsuir.markovsky.nursewebapp.constant.HTMLConstant;
import by.bsuir.markovsky.nursewebapp.constant.MappingConstant;
import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
import by.bsuir.markovsky.nursewebapp.service.NurseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

@Controller
public class NurseOrderController {

    @Autowired
    @Qualifier("nurseOrderService")
    private NurseOrderService nurseOrderService;

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

    //Params необходим для определения конкретной кнопки
    @RequestMapping(value = MappingConstant.ADD_SERVICE, method = RequestMethod.POST, params = "add")
    public String addOrder(@Valid @ModelAttribute(value = "order") NurseOrder order,
                              BindingResult bindingResult, HttpServletRequest req) {
        if (bindingResult.hasErrors()) {
            return HTMLConstant.SERVICE_PAGE_ADD;
        }
        nurseOrderService.addOrUpdateOrder(order);
        return "redirect:" + MappingConstant.HOME;
    }

    @RequestMapping(value = MappingConstant.ADD_SERVICE, method = RequestMethod.POST, params = "edit")
    public String editOrder(@Valid @ModelAttribute(value = "order") NurseOrder order,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return HTMLConstant.SERVICE_PAGE_EDIT;
        }
        nurseOrderService.addOrUpdateOrder(order);
        return "redirect:" + MappingConstant.HOME;
    }

}
