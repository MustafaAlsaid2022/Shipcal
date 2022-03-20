package com.shipcal.shipcal.repository;


import com.shipcal.shipcal.model.Shipment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class JDBCShipmentRepositoryTest {
    @Mock
    JDBCShipmentRepository jdbcShipmentRepository;

    @Test
    @DisplayName("find all shipment test ")
    void findAll() {
       Mockito.when(jdbcShipmentRepository.findAll()).thenReturn(new ArrayList<>());
        List<Shipment> allShipments=jdbcShipmentRepository.findAll();
        assert(allShipments!=null);

    }
    @Test
    @DisplayName("Add new ")
    void addNew() {
        Mockito.when(jdbcShipmentRepository.save(any(Shipment.class))).thenReturn(1);
        int result=jdbcShipmentRepository.save(new Shipment());
        assert(result==1);

    }

}
