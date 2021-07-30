package sample;

import Component.Components;

import java.util.ArrayList;

public class Package {
    private ArrayList<Components> components = new ArrayList<Components>();

    public Package(){}

    public void addComponents(Components component){
        components.add(component);
    }

    public void showItems(){
        System.out.println("Microprocessor: " + components.get(0).getMicroprocessorName());
        System.out.println("Weight Measurement: " + components.get(1).getWeightMeasurementName());
        System.out.println("Identification: " + components.get(2).getIdentificationName());
        System.out.println("Display: " + components.get(3).getDisplayName());
        System.out.println("Internet Connection: " + components.get(4).getInternetConnectionName());
        System.out.println("Storage: " + components.get(5).getStorageName());
        System.out.println("Controller: " + components.get(6).getControllerName());
        System.out.println("Framework: " + components.get(7).getFrameworkName());
    }
}
