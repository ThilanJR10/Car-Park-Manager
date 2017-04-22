/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignment1;

import oopassignment1.model.Vehicle;

/**
 *
 * @author Sahan Thinusha
 */
public interface CarParkManager {

    public void addVehicle(Vehicle vehicle);

    public Vehicle deleteVehicle(String iDPlate);

    public Vehicle getVehicle(String iDPlate);

    public void printAllVehicleDetails();

   

}
