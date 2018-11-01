package by.bsuir.markovsky.nursewebapp.repository;

import by.bsuir.markovsky.nursewebapp.model.WebIdentity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("webIdentityRepository")
public interface WebIdentityRepository extends CrudRepository<WebIdentity, Integer> {
    List<WebIdentity> findAll();
    List<WebIdentity> findAllByUsername(String username);
    WebIdentity findByUsername(String username);
}
