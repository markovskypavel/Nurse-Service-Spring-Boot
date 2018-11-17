package by.bsuir.markovsky.nursewebapp.repository;

import by.bsuir.markovsky.nursewebapp.model.Nurse;
import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("nurseRepository")
public interface NurseRepository extends CrudRepository<Nurse, Integer> {
    List<Nurse> findAll();
    List<Nurse> findAllByWebIdentity_username(String username);
}
