package by.bsuir.markovsky.nursewebapp.controller;

import by.bsuir.markovsky.nursewebapp.constant.MappingConstant;
import by.bsuir.markovsky.nursewebapp.exception.NotFoundException;
import by.bsuir.markovsky.nursewebapp.model.News;
import by.bsuir.markovsky.nursewebapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestNewsController {

    @Autowired
    @Qualifier("newsService")
    private NewsService newsService;

    //@RequestParam необходим для подстановки из UrlQuery
    //spring.mvc.pathmatch.use-suffix-pattern=true в properties для работы расширений
    @RequestMapping(value = MappingConstant.GET_NEWS, method = RequestMethod.GET)
    public News findNews(@PathVariable("id") int id) throws NotFoundException {
        News news = newsService.getNewsById(id);
        if (news == null) {
            throw new NotFoundException();
        }
        return news;
    }

    @RequestMapping(value = MappingConstant.GET_ALL_NEWS, method = RequestMethod.GET)
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @RequestMapping(value = MappingConstant.DELETE_NEWS, method = RequestMethod.POST)
    public void deleteNews(@PathVariable("id") int id) throws NotFoundException {
        News news = newsService.getNewsById(id);
        if (news == null) {
            throw new NotFoundException();
        }
        newsService.deleteNews(news);
    }

}
