package by.bsuir.markovsky.nursewebapp.controller;

import by.bsuir.markovsky.nursewebapp.exception.NotFoundException;
import by.bsuir.markovsky.nursewebapp.model.NurseOrder;
import by.bsuir.markovsky.nursewebapp.service.NurseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestActivityController {

    @Autowired
    private NurseOrderService nurseOrderService;

    //@RequestParam необходим для подстановки из UrlQuery
    //TODO: Разобраться почему не работают расширения
    @RequestMapping(value = "/orders/order/{id}")
    public NurseOrder findId(@PathVariable("id") int id,
                             @RequestParam(value="name", required=false, defaultValue="") String name) throws NotFoundException {
        NurseOrder nurseOrder = nurseOrderService.getOrderById(id);
        if (nurseOrder == null) {
            throw new NotFoundException();
        }
        return nurseOrder;
    }

}
