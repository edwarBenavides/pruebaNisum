package com.pruebaNisum.pruebaNisum.service.phoneService;

import com.pruebaNisum.pruebaNisum.model.Phone;
import com.pruebaNisum.pruebaNisum.model.User;
import com.pruebaNisum.pruebaNisum.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements IPhoneService{

    @Autowired
    private IPhoneRepository iPhoneRepository;

    @Override
    public void updateUserIdInPhone(User userEntity) {
        if (userEntity != null && userEntity.getPhones() != null){
            List<Phone> phoneList = userEntity.getPhones().stream()
                    .map(phone -> {
                        phone.setUser(userEntity);
                        return phone;
                    }).collect(Collectors.toList());
            iPhoneRepository.saveAllAndFlush(phoneList);
        }

    }
}
