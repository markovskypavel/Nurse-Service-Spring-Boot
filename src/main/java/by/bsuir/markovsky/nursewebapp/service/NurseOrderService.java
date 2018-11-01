package by.bsuir.markovsky.nursewebapp.service;

import by.bsuir.markovsky.nursewebapp.exception.ServiceException;
import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
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

/*    @Value("${generator.service.strings.count}")
    private int stringsCount;*/

    @Autowired
    @Qualifier("nurseOrderRepository")
    private NurseOrderRepository nurseOrderRepository;

    public void addOrder(NurseOrder nurseOrder) {
        nurseOrderRepository.save(nurseOrder);
    }
    public void deleteOrder(int id) throws ServiceException {
        Optional<NurseOrder> nurseOrder = nurseOrderRepository.findById(id);
        if(!nurseOrder.isPresent()){
            throw new ServiceException();
        }
        nurseOrderRepository.delete(nurseOrder.get());
    }
    public NurseOrder getOrderById(int id) {
        Optional<NurseOrder> activity = nurseOrderRepository.findById(id);
        return activity.orElse(null);
    }
    public List<NurseOrder> getAllOrders() {
        return nurseOrderRepository.findAll();
    }

}
