package com.sangeeth.main;

import com.sangeeth.imp.CarParckAssistant;
import com.sangeeth.imp.CarParckSystem;
import com.sangeeth.imp.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dtsangeeth
 * @created 22 / 12 / 2020
 * @project Lp-factory-design-pattern-demo
 */
public class Application {

    static List<Vehicle> vehicleslist = new ArrayList<>();

    public static void main(String[] args) {
        Application main = new Application();
        main.display();

    }

    public void display(){

        try {
            CarParckSystem carParckSystem = new CarParckAssistant();
            carParckSystem.initialize(vehicleslist);
        }catch (IOException io){
            display();
        }
    }
}
