package com.shipcal.shipcal.repository;

import com.shipcal.shipcal.model.Shipment;

import java.util.List;

public interface ShipmentRepository {

    int save(Shipment shipment);
    List<Shipment> findAll();
}
