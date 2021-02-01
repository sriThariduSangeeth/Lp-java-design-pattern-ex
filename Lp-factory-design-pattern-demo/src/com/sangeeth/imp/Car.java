package com.sangeeth.imp;

import java.util.Date;

/**
 * @author dtsangeeth
 * @created 15 / 12 / 2020
 * @project LPTraining
 */
public class Car extends Vehicle{

    private String carColor;
    private int numberOfDoor;

    public Car(String type , String id , String brand , Date date , String color , int door){
        vehicleType = type;
        idPlate = id;
        vehicleBrand = brand;
        dateTime = date;
        carColor = color;
        numberOfDoor = door;
    }

    public String getColor(){
        return this.carColor;
    }

    public void setColor(String color){
        this.carColor = color;
    }

    public int getNumberOfDoor(){
        return this.numberOfDoor;
    }

    public void setNumberOfDoor(int numberOfDoor){
        this.numberOfDoor = numberOfDoor;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public void setVehicleType(String vehicleType) {

    }

    @Override
    public String getIdPlate() {
        return idPlate;
    }

    @Override
    public void setIdPlate(String idPlate) {

    }

    @Override
    public String getVehicleBrand() {
        return vehicleBrand;
    }

    @Override
    public void setVehicleBrand(String vehicleBrand) {

    }

    @Override
    public Date getDateTime() {
        return dateTime;
    }

    @Override
    public void setDateTime(Date dateTime) {

    }
}
