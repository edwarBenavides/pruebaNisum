package com.pruebaNisum.pruebaNisum.service.phoneService;

import com.pruebaNisum.pruebaNisum.model.Phone;
import com.pruebaNisum.pruebaNisum.model.User;
import com.pruebaNisum.pruebaNisum.repository.IPhoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class PhoneServiceImplTest {

    @Mock
    private IPhoneRepository iPhoneRepository;

    @InjectMocks
    private PhoneServiceImpl phoneService;

    private User user;
    private List<Phone> phones;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId("sdfsd3434r34rfsfd");

        phones = new ArrayList<>();

        Phone phone1 = Mockito.mock(Phone.class);
        phone1.setId("sdfs444");
        phone1.setNumber("2222222");

        phones.add(phone1);
        user.setPhones(phones);

    }

    @Test
    void testUpdateUserIdInPhone() {
        phoneService.updateUserIdInPhone(user);
        verify(iPhoneRepository, times(1)).saveAllAndFlush(phones);
        verify(phones.get(0), times(1)).setUser(user);
    }
}