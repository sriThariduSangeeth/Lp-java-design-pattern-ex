package com.virtusa.main;

import com.virtusa.imp.Computer;

/**
 * @author dtsangeeth
 * @created 28 / 12 / 2020
 * @project Lp-builder-design-pattern-demo
 */
public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.displayOneEx();
    }

    public void displayOneEx(){
        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Computer comp = new Computer.ComputerBuilder(
                "500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();
        System.out.println(comp.getHDD());
    }
}
