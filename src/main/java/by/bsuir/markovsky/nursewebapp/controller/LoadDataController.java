package by.bsuir.markovsky.nursewebapp.controller;

import by.bsuir.markovsky.nursewebapp.constant.HTMLConstant;
import by.bsuir.markovsky.nursewebapp.constant.MappingConstant;
import by.bsuir.markovsky.nursewebapp.model.enumeration.ServiceStatusType;
import by.bsuir.markovsky.nursewebapp.service.NewsService;
import by.bsuir.markovsky.nursewebapp.service.NurseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LoadDataController {

    @Autowired
    @Qualifier("newsService")
    private NewsService newsService;

    @Autowired
    @Qualifier("nurseOrderService")
    private NurseOrderService nurseOrderService;

    @RequestMapping(value = MappingConstant.LOAD_DATA_HOME, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadAllDataHome(Model model) {
        model.addAttribute("news", newsService.getAllNews());
        return new ModelAndView(HTMLConstant.HOME_FRAGMENT);
    }

    @RequestMapping(value = MappingConstant.LOAD_DATA_ADMIN, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadAllDataAdmin(Model model) {
        model.addAttribute("news", newsService.getAllNews());
        model.addAttribute("orders", nurseOrderService.getAllOrders());
        return new ModelAndView(HTMLConstant.ADMIN_FRAGMENT);
    }

    @RequestMapping(value = MappingConstant.LOAD_DATA_USER, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadAllDataUser(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        model.addAttribute("orders", nurseOrderService.getAllOrdersByUserUsername(loginedUser.getUsername()));
        return new ModelAndView(HTMLConstant.USER_FRAGMENT);
    }

    @RequestMapping(value = MappingConstant.LOAD_DATA_NURSE, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadAllDataNurse(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        model.addAttribute("orders", nurseOrderService.getAllOrdersByNurseUsername(loginedUser.getUsername()));
        return new ModelAndView(HTMLConstant.NURSE_FRAGMENT);
    }

    @RequestMapping(value = MappingConstant.LOAD_DATA_SERVICE, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadAllDataService(Model model) {
        model.addAttribute("orders", nurseOrderService.getAllOrdersByStatus(ServiceStatusType.FREE));
        return new ModelAndView(HTMLConstant.SERVICE_FRAGMENT);
    }

}
