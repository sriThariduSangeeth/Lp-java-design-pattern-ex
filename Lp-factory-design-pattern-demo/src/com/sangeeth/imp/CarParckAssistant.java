package com.sangeeth.imp;

import com.sangeeth.factory.VehicleFactory;
import com.sangeeth.main.Application;
import com.sangeeth.util.ColorBank;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author dtsangeeth
 * @created 14 / 12 / 2020
 * @project LPTraining
 */
public class CarParckAssistant implements CarParckSystem {


    private Scanner sc = null;
    //Create vehicle object array
    public List <Vehicle> vehicleslist = null;
    //free slot counter
    static int slotCounter = 10;
    //keeps track of the different vehicle parked
    static int carCounter,vanCounter,bikeCounter;

    private Vehicle veh;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Calendar cal = Calendar.getInstance();

    @Override
    public void initialize(List<Vehicle> list) throws IOException {
        this.vehicleslist = list;
        System.out.println(ColorBank.PURPLE + "\n \t \t \tW E L C O M E \t T O \t T H E \t C A R P A R K" + ColorBank.RESET);
        System.out.println();
        this.run();
    }

    private void run() throws IOException {


//        System.out.println(dateFormat.format(cal.getTime()));

        sc = new Scanner(System.in);
        int option;
        System.out.println("\n \t \t-----------------------------------------------------");
        System.out.println("\t \t- - - - - - - - - - - CarPark Menu- - - - - - - - - - ");
        System.out.println("\t \t-----------------------------------------------------");
        System.out.println();
        System.out.println("1. Add a new Vehicle");
        System.out.println("2. Delete a Vehicle");
        System.out.println("3. Print a list of vehicle currently parked");
        System.out.println("4. Back to main menu");

        try {
            System.out.print(ColorBank.CYAN+"\nEnter option : "+ColorBank.RESET);
            option = sc.nextInt();

            switch (option){
                case 1:
                    this.addVehicle();
                    break;
                case 2:
                    this.deleteVehicle();
                    break;
                case 3:
                    this.allListOfVehicles();
                    break;
                case 4:
                    this.backToMainMenu();
                    break;
                default:
                    System.out.println(ColorBank.RED + "\nInvalid option!"+ColorBank.RESET);
                    this.run();
                    break;
            }
        }catch (InputMismatchException ex){
            System.out.println(ColorBank.RED + "\nInvalid option!" + ColorBank.RESET);
            System.out.println(ex.getMessage() +" " + ex);
            sc.hasNextInt(); //consumes the type mismatch exception
            this.run();
        }catch (NumberFormatException e){
            System.out.println(ColorBank.RED + "\nString input not nvalid!" + ColorBank.RESET);
            System.out.println(e.getMessage() +" " + e);
            sc.hasNextInt(); //consumes the type mismatch exception
            this.run();
        }
    }

    private void addVehicle() throws InputMismatchException, NumberFormatException, IOException {

        sc = new Scanner(System.in);
        int selecttype;

        String id = null;
        String brand = null;
        String vtype = null;
        Date date = null;
        Double cargo = 0.0;
        int tire = 0;
        String color = null;
        int door = 0;
        String capacity = null;


        if(getFreeSlots()){

            System.out.println("Please select the type of the Vehicle");
            System.out.println("\t 1. Car");
            System.out.println("\t 2. Van");
            System.out.println("\t 3. Motorbike");

            System.out.println("\n Enter option : ");
            selecttype = sc.nextInt();

            switch (selecttype){
                case 1:
                    vtype = "Car";
                    date = new Date();
                    System.out.println(ColorBank.GREEN + "\n\t- - - - Add a car to the park - - - - " + ColorBank.RESET);
                    System.out.println("\nPlease enter the ID Plate number of the Car");
                    id = sc.next();

                    System.out.println("Please enter the Brand of the Car");
                    brand = sc.next();

                    System.out.println("Please enter the number of Doors of the Car");
                    door = sc.nextInt();

                    System.out.println("Please enter the Color of the Car");
                    color = sc.next();
                    carCounter++;
                    break;

                case 2:
                    vtype = "Van";
                    date = new Date();
                    System.out.println(ColorBank.GREEN + "\n\t- - - - Add a Van to the park - - - - " + ColorBank.RESET);
                    System.out.println("\nPlease enter the ID Plate number of the Van");
                    id = sc.next();

                    System.out.println("Please enter the Brand of the Van");
                    brand = sc.next();

                    System.out.println("Please enter the cargo volume of the van in Cubic Feet");
                    cargo = sc.nextDouble();

                    System.out.println("Please enter the number of tires in van");
                    tire = sc.nextInt();
                    vanCounter++;
                    break;
                case 3:
                    vtype = "Motorbike";
                    date = new Date();
                    System.out.println(ColorBank.GREEN + "\n\t- - - - Add a Motorbike to the park - - - - " + ColorBank.RESET);

                    System.out.println("\nPlease enter the ID Plate number of the Motorbike");
                    id = sc.next();

                    System.out.println("Please enter the Brand of the Motorbike");
                    brand = sc.next();

                    System.out.println("Please enter the engine capacity of the Motorbike");
                    capacity = sc.next();
                    bikeCounter++;
                    break;
                default:
                    break;
            }
            veh = VehicleFactory.getVehicle(vtype,id,brand,date,cargo,tire,color,door,capacity);
            vehicleslist.add(veh);
            slotCounter--;
            this.run();
        }else {
            return;
        }

    }

    private void deleteVehicle() throws InputMismatchException, IOException {
        System.out.println();
        System.out.println("- - - - - - - - - Delete a vehicle- - - - - - - - - \n ");

        float totalVehicles = (carCounter+vanCounter+bikeCounter);

        if (totalVehicles==0) {
            System.out.println(ColorBank.RED+"The parking is empty at the moment! Please try again later."+ColorBank.RESET);
        }else{
            System.out.println("List of Vehicles in the parking\n");
            for (Vehicle vehicle : vehicleslist) {
                String ID = vehicle.getIdPlate();
                if (ID != null)
                    System.out.println("\t" + ID + " \t (" + vehicle.getVehicleType()+")");
            }
            System.out.println("\nPlease select the vehicle you wish to delete :");
            String deleteVehicle = sc.next();
            //getIndexProperty method will return an integer
            String leavingVehicle = vehicleslist.get(getIndexByProperty(deleteVehicle)).getVehicleType();
                slotCounter++;
                carCounter--;
            vehicleslist.remove(getIndexByProperty(deleteVehicle));
            System.out.println(ColorBank.YELLOW + "\nA " + leavingVehicle + " is leaving the park." + ColorBank.RESET);
        }
        this.run();
    }

    //returns the index of the desired vehicle
    private int getIndexByProperty(String yourString) {
        for (int i = 0; i < vehicleslist.size(); i++) {
            if (vehicleslist.get(i).getIdPlate() !=null && vehicleslist.get(i).getIdPlate().equalsIgnoreCase(yourString)) {
                //System.out.println(i);
                return i;
            }
        }
        System.out.println(ColorBank.RED+"\nSorry! There's no vehicle in the park with the specified ID plate.\n"+ColorBank.RESET);
        return -1;// not there is list
    }

    private void allListOfVehicles() throws IOException {

        System.out.println();
        System.out.println("- - - - - - - - List of Vehicles in the Parking - - - - - - - - \n ");

        float totalVehicles = (carCounter+vanCounter+bikeCounter);

        if (totalVehicles==0) {
            System.out.println(ColorBank.RED+"The parking is empty at the moment! Please try again later."+ColorBank.RESET);
        }else {
            for (Vehicle vehicle : vehicleslist) {

                System.out.println(ColorBank.BLUE + "ID Plate - " + ColorBank.RESET + vehicle.getIdPlate() + " " +
                        ColorBank.BLUE + "Entrance Date & Time - " + ColorBank.RESET + vehicle.getDateTime() +" "+ ColorBank.BLUE + " The type of the vehicle - " + ColorBank.RESET + vehicle.getVehicleType());
            }
        }
        this.run();
    }

    public void backToMainMenu(){
        Application m = new Application();
        m.display();
    }


    public boolean getFreeSlots(){

        if(slotCounter>0){
            System.out.println(ColorBank.CYAN + " \n There are " +slotCounter+ " free slots left. \n" + ColorBank.RESET);
            return true;
        }else {
            System.out.println(ColorBank.RED + "\n Sorry! There are no free slots left. \n" + ColorBank.RESET );
            return false;
        }
    }

}
