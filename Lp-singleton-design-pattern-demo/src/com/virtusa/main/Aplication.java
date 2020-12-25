package com.virtusa.main;

import com.virtusa.imp.ReadPropertyFile;

import java.util.Properties;

import static com.virtusa.util.Constants.JETTY_SERVER_POST;

/**
 * @author dtsangeeth
 * @created 22 / 12 / 2020
 * @project Lp-singleton-design-pattern-demo
 */
public class Aplication {

    public static void main(String[] args) {
        Aplication aplication = new Aplication();
        aplication.display();
    }

    public void display(){

        Properties properties = ReadPropertyFile.getInstance().getProperties();

        System.out.println(properties.getProperty(JETTY_SERVER_POST));
    }
}
