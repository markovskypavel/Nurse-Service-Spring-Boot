package by.bsuir.markovsky.nursewebapp.controller;

import by.bsuir.markovsky.nursewebapp.constant.HTMLConstant;
import by.bsuir.markovsky.nursewebapp.constant.MappingConstant;
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
public class MappingController {

    @Autowired
    @Qualifier("newsService")
    private NewsService newsService;

    @Autowired
    @Qualifier("nurseOrderService")
    private NurseOrderService nurseOrderService;

    @RequestMapping(value = MappingConstant.HOME, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView home(Model model) {
        model.addAttribute("news", newsService.getAllNews());
        return new ModelAndView(HTMLConstant.HOME_PAGE);
    }

    @RequestMapping(value = MappingConstant.ABOUT_US, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView about() {
        return new ModelAndView(HTMLConstant.ABOUT_US_PAGE);
    }

    @RequestMapping(value = MappingConstant.SERVICE, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView service(Model model) {
        model.addAttribute("orders", nurseOrderService.getAllOrders());
        return new ModelAndView(HTMLConstant.SERVICE_PAGE);
    }

    @RequestMapping(value = MappingConstant.ADMIN, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView admin(Model model) {
        model.addAttribute("news", newsService.getAllNews());
        model.addAttribute("orders", nurseOrderService.getAllOrders());
        return new ModelAndView(HTMLConstant.ADMIN_PAGE);
    }

    @RequestMapping(value = MappingConstant.USER, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView user(Principal principal, Model model) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        model.addAttribute("orders", nurseOrderService.getAllOrdersByUsername(loginedUser.getUsername()));
        return new ModelAndView(HTMLConstant.USER_PAGE);
    }

    @RequestMapping(value = MappingConstant.NURSE, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView nurse(Principal principal, Model model) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        model.addAttribute("orders", nurseOrderService.getAllOrdersByUsername(loginedUser.getUsername()));
        return new ModelAndView(HTMLConstant.NURSE_PAGE);
    }

    @RequestMapping(value = MappingConstant.DENIED, method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView(HTMLConstant.DENIED_PAGE);
    }

    @RequestMapping(value = MappingConstant.NOT_FOUND, method = RequestMethod.GET)
    public ModelAndView notFound() {
        return new ModelAndView(HTMLConstant.NOT_FOUND_PAGE);
    }

}
