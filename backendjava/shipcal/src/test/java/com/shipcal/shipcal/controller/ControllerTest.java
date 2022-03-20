package com.shipcal.shipcal.controller;

import com.shipcal.shipcal.model.Shipment;
import com.shipcal.shipcal.repository.JDBCShipmentRepository;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ControllerTest {

    @InjectMocks
    ShipCalController shipCalController;

    @Mock
    JDBCShipmentRepository jdbcShipmentRepository;

    @Test
    public void testFindAll(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Object responseEntity = shipCalController.getAllShipment();
        assert(responseEntity!=null);
    }
    @Test
    public void addnew(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(jdbcShipmentRepository.save(any(Shipment.class))).thenReturn(1);
        Object responseEntity = shipCalController.addShipment(new Shipment());
        assert(responseEntity!=null);
    }
}
