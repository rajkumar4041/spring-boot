package com.selfGroup.firstEmpCrud.serviceImpl;

import com.selfGroup.firstEmpCrud.model.Phone;
import com.selfGroup.firstEmpCrud.repository.PhoneRepository;
import com.selfGroup.firstEmpCrud.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone updatePhone(int id, String newPhone) {
        Optional<Phone> byId = phoneRepository.findById(id);

        return byId.map((p) -> {
                    p.setPhoneNumber(newPhone);
                    return phoneRepository.save(p);
                }
        ).orElse(null);

    }
}
