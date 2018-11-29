package by.bsuir.markovsky.nursewebapp.service;

import by.bsuir.markovsky.nursewebapp.exception.ServiceException;
import by.bsuir.markovsky.nursewebapp.model.Nurse;
import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
import by.bsuir.markovsky.nursewebapp.model.WebIdentity;
import by.bsuir.markovsky.nursewebapp.model.enumeration.ServiceStatusType;
import by.bsuir.markovsky.nursewebapp.repository.NurseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("nurseOrderService")
@Transactional(rollbackFor = ServiceException.class)
public class NurseOrderService {

    @Autowired
    @Qualifier("nurseOrderRepository")
    private NurseOrderRepository nurseOrderRepository;

    public void addOrder(NurseOrder nurseOrder, Nurse nurse) {
        nurseOrder.setNurse(nurse);
        nurseOrderRepository.save(nurseOrder);
    }
    public void updateOrder(NurseOrder order) {
        NurseOrder oldOrder = getOrderById(order.getId());
        if(oldOrder != null){
            oldOrder.setDescription(order.getDescription());
            oldOrder.setExpireDate(order.getExpireDate());

            nurseOrderRepository.save(oldOrder);
        }
    }
    public void deleteOrder(NurseOrder nurseOrder) {
        nurseOrderRepository.delete(nurseOrder);
    }
    public NurseOrder getOrderById(int id) {
        Optional<NurseOrder> order = nurseOrderRepository.findById(id);
        return order.orElse(null);
    }
    public List<NurseOrder> getAllOrders() {
        return nurseOrderRepository.findAll();
    }
    public List<NurseOrder> getAllOrdersByUserUsername(String username) {
        return nurseOrderRepository.findAllByWebIdentity_username(username);
    }
    public List<NurseOrder> getAllOrdersByNurseUsername(String username) {
        return nurseOrderRepository.findAllByNurse_webIdentity_username(username);
    }
    public List<NurseOrder> getAllOrdersByStatus(ServiceStatusType statusType) {
        return nurseOrderRepository.findAllByStatus(statusType);
    }
    public void subscribeUser(NurseOrder order, WebIdentity webIdentity) {
        order.setWebIdentity(webIdentity);
        order.setStatus(ServiceStatusType.CLOSED);
        nurseOrderRepository.save(order);
    }
    public void unsubscribeUser(NurseOrder order) {
        order.setWebIdentity(null);
        order.setStatus(ServiceStatusType.FREE);
        nurseOrderRepository.save(order);
    }

}
