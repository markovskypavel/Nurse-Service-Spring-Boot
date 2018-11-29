package by.bsuir.markovsky.nursewebapp.controller;

import by.bsuir.markovsky.nursewebapp.constant.HTMLConstant;
import by.bsuir.markovsky.nursewebapp.constant.MappingConstant;
import by.bsuir.markovsky.nursewebapp.model.Nurse;
import by.bsuir.markovsky.nursewebapp.model.WebIdentity;
import by.bsuir.markovsky.nursewebapp.service.NurseService;
import by.bsuir.markovsky.nursewebapp.service.WebIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserDetailsController {

    @Autowired
    @Qualifier("webIdentityService")
    private WebIdentityService webIdentityService;

    @Autowired
    @Qualifier("nurseService")
    private NurseService nurseService;

    @RequestMapping(value = MappingConstant.LOGIN, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login() {
        return new ModelAndView(HTMLConstant.LOGIN_PAGE);
    }

    @RequestMapping(value = MappingConstant.REGISTRATION, method = RequestMethod.GET)
    public ModelAndView registrationPageUser(Model model) {
        model.addAttribute("webIdentity", new WebIdentity());
        return new ModelAndView(HTMLConstant.REGISTRATION_PAGE);
    }

    @RequestMapping(value = MappingConstant.NURSE_REGISTRATION, method = RequestMethod.GET)
    public ModelAndView registrationPageNurse(Model model) {
        model.addAttribute("nurse", new Nurse());
        return new ModelAndView(HTMLConstant.NURSE_REGISTRATION_PAGE);
    }

    @RequestMapping(value = MappingConstant.REGISTRATION, method = RequestMethod.POST)
    public String registrationUser(@Valid @ModelAttribute(value = "webIdentity") WebIdentity webIdentity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return HTMLConstant.REGISTRATION_PAGE;
        }
        if (webIdentityService.checkUserExists(webIdentity.getUsername())) {
            return "redirect:" + MappingConstant.REGISTRATION + MappingConstant.ERROR_QUERY;
        }
        webIdentityService.addOrUpdateWebIdentity(webIdentity);
        return "redirect:" + MappingConstant.LOGIN;
    }

    @RequestMapping(value = MappingConstant.NURSE_REGISTRATION, method = RequestMethod.POST)
    public String registrationNurse(@Valid @ModelAttribute(value = "nurse") Nurse nurse, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return HTMLConstant.NURSE_REGISTRATION_PAGE;
        }
        if (nurseService.checkUserExists(nurse.getWebIdentity().getUsername())) {
            return "redirect:" + MappingConstant.NURSE_REGISTRATION + MappingConstant.ERROR_QUERY;
        }
        nurseService.addOrUpdateNurse(nurse);
        return "redirect:" + MappingConstant.LOGIN;
    }

}
