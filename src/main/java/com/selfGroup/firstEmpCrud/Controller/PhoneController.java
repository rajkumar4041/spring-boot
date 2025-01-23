package com.selfGroup.firstEmpCrud.Controller;

import com.selfGroup.firstEmpCrud.model.Phone;
import com.selfGroup.firstEmpCrud.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {


    @Autowired
    private PhoneService phoneService;


    @PutMapping("/updatePhoneByPhoneController/{id}")
    public Phone updatePhone(@PathVariable int id, @RequestBody Phone phone) {

        return phoneService.updatePhone(id, phone.getPhoneNumber());

    }

}
