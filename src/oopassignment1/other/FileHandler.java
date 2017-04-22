/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignment1.other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import oopassignment1.model.Vehicle;

/**
 *
 * @author DELL
 */
public class FileHandler {

    public void writeData(Vehicle vehicle) {
        List<Vehicle> list = readData();
        list.add(vehicle);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Data.txt"))) {

            objectOutputStream.writeObject(list);//write object to txt  file 
            objectOutputStream.flush();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /*

* This method read data from txt file

     */
    public List<Vehicle> readData() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {

            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Data.txt"))) {

                Object line = null;

                while ((line = objectInputStream.readObject()) != null) {// check not EOF
                    vehicles = (List<Vehicle>) line; //read line by line and add to array

                }

            }

        } catch (ClassNotFoundException | IOException ex) {

            System.out.println(ex.getMessage());

        } finally {

        }

        return vehicles;//return values

    }

}
