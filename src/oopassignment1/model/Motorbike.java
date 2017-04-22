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
public class Motorbike extends Vehicle {

    private int engineSize;
    
    public Motorbike() {
    }

    public Motorbike(int engineSize) {
        this.engineSize = engineSize;
    }
 
    /**
     * @return the engineSize
     */
    public int getEngineSize() {
        return engineSize;
    }

    /**
     * @param engineSize the engineSize to set
     */
    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

}
