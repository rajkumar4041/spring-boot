package com.selfGroup.firstEmpCrud.service;

import com.selfGroup.firstEmpCrud.model.Phone;
import org.springframework.stereotype.Service;

public interface PhoneService {

    public Phone updatePhone(int id, String newPhone);

}
