package com.sangeeth.main;

import com.sangeeth.imp.Employees;

import java.util.List;

/**
 * @author dtsangeeth
 * @created 28 / 12 / 2020
 * @project Lp-prototype-design-pattern-demo
 */
public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.display();
    }

    public void display(){

        try{
            Employees emps = new Employees();
            emps.loadData();

            //Use the clone method to get the Employee object
            Employees empsNew = (Employees) emps.clone();
            Employees empsNew1 = (Employees) emps.clone();
            List<String> list = empsNew.getEmpList();
            list.add("John");
            List<String> list1 = empsNew1.getEmpList();
            list1.remove("Pankaj");

            System.out.println("emps List: "+emps.getEmpList());
            System.out.println("empsNew List: "+list);
            System.out.println("empsNew1 List: "+list1);

        }catch (CloneNotSupportedException ex){
            System.out.println(""+ex);
        }
    }
}
