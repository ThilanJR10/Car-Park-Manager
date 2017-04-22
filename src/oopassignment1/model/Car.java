/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignment1.model;

/**
 *
 * @author Sahan Thinusha
 */
public class Car extends Vehicle {

    private int noOfDoors;
    private String color;

    public Car() {
    }

    public Car(int noOfDoors, String color) {
        this.noOfDoors = noOfDoors;
        this.color = color;
    }

   

    /**
     * @return the noOfDoors
     */
    public int getNoOfDoors() {
        return noOfDoors;
    }

    /**
     * @param noOfDoors the noOfDoors to set
     */
    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

}
