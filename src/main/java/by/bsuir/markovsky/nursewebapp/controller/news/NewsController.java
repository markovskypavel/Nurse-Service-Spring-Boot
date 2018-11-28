package by.bsuir.markovsky.nursewebapp.controller.news;

import by.bsuir.markovsky.nursewebapp.constant.HTMLConstant;
import by.bsuir.markovsky.nursewebapp.constant.MappingConstant;
import by.bsuir.markovsky.nursewebapp.model.News;
import by.bsuir.markovsky.nursewebapp.service.NewsService;
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

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class NewsController {

    @Autowired
    @Qualifier("newsService")
    private NewsService newsService;

    @RequestMapping(value = MappingConstant.ADD_NEWS, method = RequestMethod.GET)
    public ModelAndView addNewsPage(Model model) {
        model.addAttribute("news", new News());
        return new ModelAndView(HTMLConstant.NEWS_PAGE_ADD);
    }

    @RequestMapping(value = MappingConstant.EDIT_NEWS, method = RequestMethod.GET)
    public ModelAndView editNewsPage(@PathVariable("id") int id, Model model) {
        News news = newsService.getNewsById(id);
        model.addAttribute("news", news);
        return new ModelAndView(HTMLConstant.NEWS_PAGE_EDIT);
    }

    @RequestMapping(value = MappingConstant.ADD_NEWS, method = RequestMethod.POST, params = "add")
    public String addNews(@Valid @ModelAttribute(value = "news") News news, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return HTMLConstant.NEWS_PAGE_ADD;
        }
        //TODO: Добавить автора
        newsService.addNews(news);
        return "redirect:" + MappingConstant.ADMIN;
    }

    @RequestMapping(value = MappingConstant.ADD_NEWS, method = RequestMethod.POST, params = "edit")
    public String editNews(@Valid @ModelAttribute(value = "news") News news, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return HTMLConstant.NEWS_PAGE_EDIT;
        }
        newsService.updateNews(news);
        return "redirect:" + MappingConstant.ADMIN;
    }

}
