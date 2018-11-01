package by.bsuir.markovsky.nursewebapp.repository;

import by.bsuir.markovsky.nursewebapp.model.Responsibility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("responsibilityRepository")
public interface ResponsibilityRepository extends CrudRepository<Responsibility, Integer> {
    List<Responsibility> findAll();
}
