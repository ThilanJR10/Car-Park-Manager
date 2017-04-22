/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import oopassignment1.model.Car;
import oopassignment1.model.Motorbike;
import oopassignment1.model.Van;
import oopassignment1.model.Vehicle;
import oopassignment1.other.DateTime;
import oopassignment1.other.FileHandler;

/**
 *
 * @author Sahan Thinusha
 */
public class WestminsterCarParkManager implements CarParkManager {

    private List<Vehicle> vehicles = new ArrayList<>(20);
    private final FileHandler fh = new FileHandler();
    public static int partkingSlots = 20;

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (vehicle.toString().equals("Van")) {
            partkingSlots -= 2;
        } else {
            partkingSlots--;
        }
        fh.writeData(vehicle);
        vehicles.add(vehicle);
    }

    @Override
    public Vehicle deleteVehicle(String iDPlate) {
        Vehicle v = null;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getIDPlate().equals(iDPlate)) {
                v = vehicles.get(i);
                if (v.toString().equals("Van")) {
                    partkingSlots += 2;
                } else {
                    partkingSlots++;
                }
                vehicles.remove(i);
            }
        }
        return v;
    }

    @Override
    public Vehicle getVehicle(String iDPlate) {
        try {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getIDPlate().equals(iDPlate)) {
                    return vehicle;
                }
            }
        } catch (NullPointerException e) {

        }
        return null;

    }

    @Override
    public void printAllVehicleDetails() {
        System.out.println("| ID Plate | Brand | Parked Time | Type |");
        List<Vehicle> tempVehicles = vehicles;
        Collections.reverse(tempVehicles);
        for (Vehicle v : tempVehicles) {
            System.out.println("| " + v.getIDPlate() + " | " + v.getBrand() + " | " + v.getDateTime().toString() + " | " + v.toString() + " | ");
        }
    }

    public int getSize() {
        return vehicles.size();
    }

    public List<Vehicle> searchParkingByDate(int year, int month, int day) {
        List<Vehicle> v = fh.readData();
        List<Vehicle> vehicleList = new ArrayList<>();

        for (Vehicle vehicle : v) {
            DateTime dateTime = vehicle.getDateTime();
            if (dateTime.getYear() == year && dateTime.getMonth() == month && dateTime.getDay() == day) {
                vehicleList.add(vehicle);
            }

        }
        return vehicleList;
    }

    public void printPresentages() {
        int total = getSize();
        int cars = 0;
        int vans = 0;
        int bikes = 0;
        for (Vehicle vehicle : vehicles) {
            switch (vehicle.toString()) {
                case "Car":
                    cars++;
                    break;
                case "Van":
                    vans++;
                    break;
                default:
                    bikes++;
                    break;
            }
        }
        System.out.println("Presentage if cars : " + (cars / total) * 100 + " %");
        System.out.println("Presentage if vans : " + (vans / total) * 100 + " %");
        System.out.println("Presentage if motorbikes : " + (bikes / total) * 100 + " %");
        Vehicle maxv = vehicles.get(0);
        Vehicle minv = vehicles.get(0);
        long max = maxv.getDateTime().timeDifference();
        long min = minv.getDateTime().timeDifference();
        for (int i = 1; i < vehicles.size(); i++) {
            if (max < vehicles.get(i).getDateTime().timeDifference()) {
                maxv = vehicles.get(i);
                max = maxv.getDateTime().timeDifference();
            }

            if (min > vehicles.get(i).getDateTime().timeDifference()) {
                minv = vehicles.get(i);
                min = minv.getDateTime().timeDifference();
            }
        }

        System.out.println("longest Vehicle | " + maxv.getIDPlate() + " | " + maxv.getBrand() + " | " + maxv.getDateTime().toString() + " | " + maxv.toString() + " | ");
        System.out.println("latest Vehicle | " + minv.getIDPlate() + " | " + minv.getBrand() + " | " + minv.getDateTime().toString() + " | " + minv.toString() + " | ");

    }

    public double calculatePayment(Vehicle vehicle) {
        double charge = 0;
        long time = vehicle.getDateTime().timeDifference();
        long hours = (time / (1000 * 60 * 60)) % 24;
        if (hours > 3) {
            charge = (9 + (hours - 3));
        } else if (hours <= 3) {
            charge = (int) (hours) * 3;
        }
        return charge;
    }

    public void printParkingCostforAllVehicle() {
        System.out.println("| ID Plate | Brand | Parked Time | Type | Fee |");

        for (Vehicle v : vehicles) {
            System.out.println("| " + v.getIDPlate() + " | " + v.getBrand() + " | " + v.getDateTime().toString() + " | " + v.toString() + " |  " + calculatePayment(v) + "$  | ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = null;
        WestminsterCarParkManager carParkManager = new WestminsterCarParkManager();
        System.out.println("Welcome..!");
        Loop:
        while (true) {
            System.out.println("Press 1 to add new vehicle.");
            System.out.println("Press 2 to delete vehicle.");
            System.out.println("Press 3 to Print the list of the vehicles currently parked.");
            System.out.println("Press 4 to Print Statistics.");
            System.out.println("Press 5 to Search parked vehicles by date.");
            System.out.println("Press 6 to Calculate car park fee.");

            char x = sc.next().charAt(0);
            switch (x) {
                case '1':
                    if (partkingSlots > 0) {

                        System.out.println("Enter ID Plate : ");
                        String id = sc.next();

                        System.out.println("Enter brand : ");
                        String brand = sc.next();

                        System.out.println("Press 1 to add car");
                        System.out.println("Press 2 to add van");
                        System.out.println("Press 3 to add motorbike");

                        int y = sc.nextInt();
                        switch (y) {
                            case 1:
                                int noOfDoors = 0;
                                do {
                                    try {
                                        System.out.println("Enter no of doors : ");
                                        noOfDoors = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input.");
                                    }
                                    sc.nextLine();
                                } while (noOfDoors <= 0);
                                System.out.println("Enter color : ");
                                String color = sc.next();
                                vehicle = new Car(noOfDoors, color);
                                vehicle.setIDPlate(id);
                                vehicle.setBrand(brand);
                                vehicle.setDateTime(new DateTime());
                                break;
                            case 2:
                                if (partkingSlots > 1) {
                                    int cargoVolume = 0;
                                    do {
                                        try {
                                            System.out.println("Enter cargo volume : ");
                                            cargoVolume = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Invalid input.");
                                        }
                                        sc.nextLine();
                                    } while (cargoVolume <= 0);
                                    vehicle = new Van(cargoVolume);
                                    vehicle.setIDPlate(id);
                                    vehicle.setBrand(brand);
                                    vehicle.setDateTime(new DateTime());

                                } else {
                                    System.out.println("Error there are no empty slots available");
                                }
                                break;
                            case 3:
                                int engineSize = 0;
                                do {
                                    try {
                                        System.out.println("Enter size of the engine : ");
                                        engineSize = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input.");
                                    }
                                    sc.nextLine();
                                } while (engineSize <= 0);
                                vehicle = new Motorbike(engineSize);
                                vehicle.setIDPlate(id);
                                vehicle.setBrand(brand);
                                vehicle.setDateTime(new DateTime());

                                break;

                            default:
                                System.out.println("Invalid Selection");
                        }

                        carParkManager.addVehicle(vehicle);

                        System.out.println(partkingSlots == 0 ? "There are no slots availble." : partkingSlots + " free slots availble.");
                    } else {
                        System.out.println("Error there are no empty slots available");
                    }
                    break;
                case '2':
                    System.out.println("Enter ID Plate : ");
                    String iDPlate = sc.next();
                    if (carParkManager.getVehicle(iDPlate) != null) {
                        Vehicle v = carParkManager.deleteVehicle(iDPlate);
                        System.out.println(v.toString() + " is leaving car park.");
                    } else {
                        System.out.println("Error unknown ID Plate.");
                    }
                    break;
                case '3':
                    carParkManager.printAllVehicleDetails();
                    break;

                case '4':
                    carParkManager.printPresentages();
                    break;
                case '5':
                    System.out.println("Enter Date ex(11/16/2016): ");
                    String day = sc.next();

                    String ar[] = day.split("/");
                    List<Vehicle> v = carParkManager.searchParkingByDate(Integer.parseInt(ar[2]), Integer.parseInt(ar[0]), Integer.parseInt(ar[1]));
                    if (v.isEmpty()) {
                        System.out.println("No vehicles are parked in " + day);
                    } else {
                        System.out.println("| ID Plate | Brand | Parked Time | Type |");
                        for (Vehicle vehicle1 : v) {
                            System.out.println("| " + vehicle1.getIDPlate() + " | " + vehicle1.getBrand() + " | " + vehicle1.getDateTime().toString() + " | " + vehicle1.toString() + " | ");
                        }
                    }
                    break;
                case '6':
                    carParkManager.printParkingCostforAllVehicle();
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;

            }
        }

    }
}
