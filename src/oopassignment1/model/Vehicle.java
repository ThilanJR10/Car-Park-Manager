/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignment1.model;

import java.io.Serializable;
import oopassignment1.other.DateTime;

/**
 *
 * @author Sahan Thinusha
 */
public abstract class Vehicle implements Serializable{

    private String iDPlate;
    private String brand;
    private DateTime dateTime;

    public String getIDPlate() {
        return iDPlate;
    }

    public void setIDPlate(String iDPlate) {
        this.iDPlate = iDPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
