package by.bsuir.markovsky.nursewebapp.repository;

import by.bsuir.markovsky.nursewebapp.model.Identity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("identityRepository")
public interface IdentityRepository extends CrudRepository<Identity, Integer> {
    List<Identity> findAll();
}
