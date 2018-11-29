package by.bsuir.markovsky.nursewebapp.controller.order;

import by.bsuir.markovsky.nursewebapp.constant.MappingConstant;
import by.bsuir.markovsky.nursewebapp.exception.NotFoundException;
import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
import by.bsuir.markovsky.nursewebapp.model.WebIdentity;
import by.bsuir.markovsky.nursewebapp.service.EmailService;
import by.bsuir.markovsky.nursewebapp.service.NurseOrderService;
import by.bsuir.markovsky.nursewebapp.service.WebIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestNurseOrderController {

    @Autowired
    @Qualifier("nurseOrderService")
    private NurseOrderService nurseOrderService;

    @Autowired
    @Qualifier("webIdentityService")
    private WebIdentityService webIdentityService;

    @Autowired
    @Qualifier("emailService")
    private EmailService emailService;

    @RequestMapping(value = MappingConstant.GET_SERVICE, method = RequestMethod.GET)
    public NurseOrder findOrder(@PathVariable("id") int id,
                                   @RequestParam(value = "name", required = false, defaultValue = "") String name) throws NotFoundException {
        NurseOrder order = nurseOrderService.getOrderById(id);
        if (order == null) {
            throw new NotFoundException();
        }
        return order;
    }

    @RequestMapping(value = MappingConstant.DELETE_SERVICE, method = RequestMethod.POST)
    public void deleteOrder(@PathVariable("id") int id) throws NotFoundException {
        NurseOrder order = nurseOrderService.getOrderById(id);
        if (order == null) {
            throw new NotFoundException();
        }
        nurseOrderService.deleteOrder(order);
    }

    @RequestMapping(value = MappingConstant.GET_ALL_SERVICES, method = RequestMethod.GET)
    public List<NurseOrder> getAllOrders() {
        return nurseOrderService.getAllOrders();
    }

    @RequestMapping(value = MappingConstant.SUBSCRIBE, method = RequestMethod.POST)
    public void subscribeUser(@PathVariable("serviceId") int serviceId,
                              @PathVariable("username") String username) throws Exception {
        NurseOrder order = nurseOrderService.getOrderById(serviceId);
        WebIdentity user = webIdentityService.getUserByUsername(username);
        if (order == null || user == null) {
            throw new NotFoundException();
        }
        nurseOrderService.subscribeUser(order, user);
        emailService.sendEmail(user.getEmail(), "Заказ услуги", "Вы успешно оформили заказ к исполнителю "
                + order.getNurse().getWebIdentity().getIdentity().getName());
    }

    @RequestMapping(value = MappingConstant.UNSUBSCRIBE, method = RequestMethod.POST)
    public void unsubscribeUser(@PathVariable("serviceId") int serviceId,
                                @PathVariable("username") String username) throws NotFoundException {
        NurseOrder order = nurseOrderService.getOrderById(serviceId);
        WebIdentity user = webIdentityService.getUserByUsername(username);
        if (order == null || user == null) {
            throw new NotFoundException();
        }
        nurseOrderService.unsubscribeUser(order);
    }

}
