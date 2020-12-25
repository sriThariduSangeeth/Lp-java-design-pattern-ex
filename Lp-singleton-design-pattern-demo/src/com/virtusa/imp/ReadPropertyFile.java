package com.virtusa.imp;

import java.io.*;
import java.util.Properties;

import static com.virtusa.util.Constants.JETTY_SERVER_POST;

/**
 * @author dtsangeeth
 * @created 24 / 12 / 2020
 * @project Lp-singleton-design-pattern-demo
 */
public class ReadPropertyFile {

    private InputStream cinfig;
    private Properties properties;

    private ReadPropertyFile(){

        try{

            cinfig = new FileInputStream("./Properties/config.properties");
            properties = new Properties();
            properties.load(cinfig);

        }catch (FileNotFoundException filenotfound){
            System.out.println("Propertie file could not find");
            System.out.println(filenotfound.getMessage());
        } catch (IOException e){
            System.out.println("File could not load");
            System.out.println(e.getMessage());
        }
    }


    public Properties getProperties(){
        return properties;
    }

    public static ReadPropertyFile getInstance(){
        return ReadPropertyFile.Holder.INSTANCE;
    }

    private static class Holder{
        private static final ReadPropertyFile INSTANCE = new ReadPropertyFile();
    }

}
