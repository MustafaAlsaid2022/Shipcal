package com.shipcal.shipcal.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipmentTest {

    @Test
    @DisplayName("ShipmentTest model class test ")
    void ShipmenModel() {
        Shipment shipment=new Shipment();
        shipment.setName("ANDY");
        shipment.setWeight(10.24f);
        shipment.setColor("#0000f");
        shipment.setDestination("china");

        String name=shipment.getName();
        float weight=shipment.getWeight();
        String color=shipment.getColor();
        String destination=shipment.getDestination();
        assertEquals("ANDY", name);
        assertEquals(10.24f, weight);
        assertEquals("#0000f", color);
        assertEquals("china", destination);
    }
}
