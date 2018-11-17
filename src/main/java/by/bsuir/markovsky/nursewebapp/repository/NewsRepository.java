package by.bsuir.markovsky.nursewebapp.repository;

import by.bsuir.markovsky.nursewebapp.model.News;
import by.bsuir.markovsky.nursewebapp.model.enumeration.NewsType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("newsRepository")
public interface NewsRepository extends CrudRepository<News, Integer> {
    List<News> findAll();
    List<News> findAllByType(NewsType type);
}
