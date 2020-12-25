package com.virtusa.factory;

import com.virtusa.imp.Car;
import com.virtusa.imp.Motorbike;
import com.virtusa.imp.Van;
import com.virtusa.imp.Vehicle;

import java.util.Date;

/**
 * @author dtsangeeth
 * @created 15 / 12 / 2020
 * @project LPTraining
 */
public class VehicleFactory {

    public static Vehicle getVehicle (String type , String id , String brand , Date date , Double cargo , int tire , String color , int door , String capacity){

        if(type.equalsIgnoreCase("Car")){
            return new Car(type,id,brand,date,color,door);
        }else if(type.equalsIgnoreCase("Van")){
            return new Van(type,id,brand,date,cargo,tire);
        }else if(type.equalsIgnoreCase("Motorbike")){
            return new Motorbike(type,id,brand,date,capacity);
        }
        return null;
    }
}
