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
public class Van extends Vehicle {

    private int cargoVolume;

    public Van() {
    }

    public Van(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    /**
     * @return the cargoVolume
     */
    public int getCargoVolume() {
        return cargoVolume;
    }

    /**
     * @param cargoVolume the cargoVolume to set
     */
    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }
}
