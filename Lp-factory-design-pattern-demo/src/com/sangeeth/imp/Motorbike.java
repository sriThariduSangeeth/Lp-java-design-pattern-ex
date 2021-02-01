package com.sangeeth.imp;

import java.util.Date;

/**
 * @author dtsangeeth
 * @created 15 / 12 / 2020
 * @project LPTraining
 */
public class Motorbike  extends Vehicle{


    private String engineCapacity;

    public Motorbike(String type , String id , String brand , Date date , String capacity){
        vehicleType = type;
        idPlate = id;
        vehicleBrand = brand;
        dateTime = date;
        engineCapacity = capacity;
    }
    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
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
