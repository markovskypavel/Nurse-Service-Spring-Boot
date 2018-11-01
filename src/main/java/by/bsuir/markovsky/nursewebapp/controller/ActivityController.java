package by.bsuir.markovsky.nursewebapp.controller;

import by.bsuir.markovsky.nursewebapp.constant.JspConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class ActivityController {

/*    localhost:(Port number) /project name/(request mapping at controller) /(request mapping at method)*/

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView home(HttpServletRequest req, HttpServletResponse resp) {
        return new ModelAndView(JspConstant.MAIN_PAGE);
    }

/*
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

*/
/*        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);*//*


        return JspConstant.ADMIN_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return JspConstant.LOGIN_PAGE;
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage() {
        return JspConstant.MAIN_PAGE;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // (1) (en)
        // After user login successfully.
        // (vi)
        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

*/
/*        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);*//*


        return JspConstant.USER_PAGE;
    }

    @RequestMapping(value = "/nurse", method = RequestMethod.GET)
    public String nurseInfo(Model model, Principal principal) {
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

*/
/*        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);*//*


        return JspConstant.NURSE_PAGE;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

*/
/*            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);*//*


            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return JspConstant.DENIED_PAGE;
    }
*/

}
