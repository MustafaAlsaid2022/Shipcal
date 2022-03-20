package com.shipcal.shipcal.repository;

import com.shipcal.shipcal.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCShipmentRepository implements ShipmentRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Shipment shipment) {
        String country=shipment.getDestination();
        float cost=0.0f;
        if(country.equalsIgnoreCase("Sweden")){
            cost=Math.round(shipment.getWeight() * 1.3 * 100.0f) /100.0f;
        }else if(country.equalsIgnoreCase("China")){
            cost=Math.round(shipment.getWeight() * 4 * 100.0f) /100.0f;
        }else if(country.equalsIgnoreCase("Brazil")){
            cost=Math.round(shipment.getWeight() * 8.6 * 100.0f) /100.0f;
        }else if(country.equalsIgnoreCase("Australia")){
            cost=Math.round(shipment.getWeight() * 7.2 * 100.0f) /100.0f;
        }
        return jdbcTemplate.update("INSERT INTO SHIPMENT(name,weight,color,destination,cost) VALUES(?,?,?,?,?)",
                new Object[] { shipment.getName(), shipment.getWeight(), shipment.getColor(),shipment.getDestination(),cost });
    }
    @Override
    public List<Shipment> findAll() {
        return jdbcTemplate.query("SELECT * from shipment", BeanPropertyRowMapper.newInstance(Shipment.class));
    }
}
