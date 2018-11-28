package by.bsuir.markovsky.nursewebapp.repository;

import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
import by.bsuir.markovsky.nursewebapp.model.enumeration.RatingType;
import by.bsuir.markovsky.nursewebapp.model.enumeration.ServiceStatusType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("nurseOrderRepository")
public interface NurseOrderRepository extends CrudRepository<NurseOrder, Integer> {
    List<NurseOrder> findAll();
    List<NurseOrder> findAllByWebIdentity_username(String username);
    List<NurseOrder> findAllByNurse_webIdentity_username(String username);
    List<NurseOrder> findAllByStatus(ServiceStatusType type);
    List<NurseOrder> findAllByNurse_ratingType(RatingType type);
}
