package by.bsuir.markovsky.nursewebapp.service;

import by.bsuir.markovsky.nursewebapp.exception.ServiceException;
import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
import by.bsuir.markovsky.nursewebapp.model.WebIdentity;
import by.bsuir.markovsky.nursewebapp.repository.NurseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("nurseOrderService")
@Transactional(rollbackFor = ServiceException.class)
/*rollback for unchecked exception (transaction cancelled)*/
public class NurseOrderService {

    @Autowired
    @Qualifier("nurseOrderRepository")
    private NurseOrderRepository nurseOrderRepository;

    /*@PreAuthorize("hasRole('ROLE_ADMIN')")*/
    public void addOrUpdateOrder(NurseOrder nurseOrder) {
        nurseOrderRepository.save(nurseOrder);
    }
    public void deleteOrder(NurseOrder nurseOrder) {
        nurseOrderRepository.delete(nurseOrder);
    }
    public NurseOrder getOrderById(int id) {
        Optional<NurseOrder> activity = nurseOrderRepository.findById(id);
        return activity.orElse(null);
    }
    public List<NurseOrder> getAllOrders() {
        return nurseOrderRepository.findAll();
    }
    public List<NurseOrder> getAllOrdersByUsername(String username) {
        return nurseOrderRepository.findAllByWebIdentity_username(username);
    }
    public void subscribeUser(NurseOrder order, WebIdentity webIdentity) {
        order.setWebIdentity(webIdentity);
        nurseOrderRepository.save(order);
    }
    public void unsubscribeUser(NurseOrder order) {
        order.setWebIdentity(null);
        nurseOrderRepository.save(order);
    }

}
