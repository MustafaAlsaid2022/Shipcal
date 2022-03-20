package com.shipcal.shipcal.model;

public class Shipment {
    int id;
    String name;
    float weight;
    String color;
    String destination;
    float cost;

    public Shipment(int id, String name, float weight, String color, String destination, float cost) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.destination = destination;
        this.cost = cost;
    }

    public Shipment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
