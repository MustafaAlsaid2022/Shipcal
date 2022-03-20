package com.shipcal.shipcal.controller;

import com.shipcal.shipcal.model.Shipment;
import com.shipcal.shipcal.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api")
@CrossOrigin
@RestController
public class ShipCalController {
    @Autowired
    ShipmentRepository shipmentRepository;

    @PostMapping(value = "addBoxes")
    @ResponseBody
    public Object addShipment(@RequestBody Shipment shipment) {
        shipmentRepository.save(shipment);
        return  new ResponseEntity<>(shipment, HttpStatus.CREATED);
    }


    @RequestMapping(value = "listBoxes")
    @ResponseBody
    public Object getAllShipment() {
        List<Shipment> shipmentList=shipmentRepository.findAll();
        return new ResponseEntity<>(shipmentList, HttpStatus.OK);
    }




}
