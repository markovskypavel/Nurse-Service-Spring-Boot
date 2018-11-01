package by.bsuir.markovsky.nursewebapp.repository;

import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("nurseOrderRepository")
public interface NurseOrderRepository extends CrudRepository<NurseOrder, Integer> {
    List<NurseOrder> findAll();
}
