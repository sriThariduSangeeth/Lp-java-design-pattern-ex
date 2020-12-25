package com.virtusa.imp;

import java.util.Date;

/**
 * @author dtsangeeth
 * @created 15 / 12 / 2020
 * @project LPTraining
 */
public abstract class Vehicle {

    //instance variables
    public String vehicleType;
    public String idPlate;
    public String vehicleBrand;
    public Date dateTime;

    public abstract String getVehicleType();

    public abstract void setVehicleType(String vehicleType);

    public abstract String getIdPlate();

    public abstract void setIdPlate(String idPlate);

    public abstract String getVehicleBrand();

    public abstract void setVehicleBrand(String vehicleBrand);

    public abstract Date getDateTime();

    public abstract void setDateTime(Date dateTime);


    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType='" + vehicleType + '\'' +
                ", idPlate='" + idPlate + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
