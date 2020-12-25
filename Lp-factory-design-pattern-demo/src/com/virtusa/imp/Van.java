package com.virtusa.imp;

import java.util.Date;

/**
 * @author dtsangeeth
 * @created 15 / 12 / 2020
 * @project LPTraining
 */
public class Van  extends Vehicle{


    private Double cargoVolume;
    private int numberOfTire;

    public Van(String type , String id , String brand , Date date , Double cargo , int tire){
        vehicleType = type;
        idPlate = id;
        vehicleBrand = brand;
        dateTime = date;
        cargoVolume = cargo;
        numberOfTire = tire;
    }


    public int getNumberOfTire() {
        return numberOfTire;
    }

    public void setNumberOfTire(int numberOfTire) {
        this.numberOfTire = numberOfTire;
    }

    public Double getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(Double cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getIdPlate() {
        return idPlate;
    }

    @Override
    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    @Override
    public String getVehicleBrand() {
        return vehicleBrand;
    }

    @Override
    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    @Override
    public Date getDateTime() {
        return dateTime;
    }

    @Override
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
