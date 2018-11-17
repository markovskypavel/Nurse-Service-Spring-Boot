package by.bsuir.markovsky.nursewebapp.service;

import by.bsuir.markovsky.nursewebapp.exception.ServiceException;
import by.bsuir.markovsky.nursewebapp.model.News;
import by.bsuir.markovsky.nursewebapp.model.WebIdentity;
import by.bsuir.markovsky.nursewebapp.model.enumeration.NewsType;
import by.bsuir.markovsky.nursewebapp.model.enumeration.RoleType;
import by.bsuir.markovsky.nursewebapp.repository.NewsRepository;
import by.bsuir.markovsky.nursewebapp.repository.WebIdentityRepository;
import by.bsuir.markovsky.nursewebapp.util.EncryptedPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("newsService")
@Transactional(rollbackOn = ServiceException.class)
public class NewsService {

    @Autowired
    @Qualifier("newsRepository")
    private NewsRepository newsRepository;

    public void addOrUpdateNews(News news) {
        newsRepository.save(news);
    }
    public void deleteNews(News news) {
        newsRepository.delete(news);
    }
    public News getNewsById(int id) {
        Optional<News> news = newsRepository.findById(id);
        return news.orElse(null);
    }
    public List<News> getNewsByType(NewsType type) {
        List<News> news = newsRepository.findAllByType(type);
        return news;
    }
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

}
