package sample;

import Component.concreteComponents.*;

public class SilverBuilder implements PackageBuilder{
    private Package pack;
    public SilverBuilder(Package pack){
        this.pack = pack;
    }

    @Override
    public void setMicroprocessorName() {
        pack.addComponents(new ATMega32());
    }

    @Override
    public void setWeightMeasurementName() {
        pack.addComponents(new load_sensor());
    }

    @Override
    public void setIdentificationName() {
        pack.addComponents(new RFID());
    }

    @Override
    public void setDisplayName() {
        pack.addComponents(new LCD());
    }

    @Override
    public void setInternetConnection(String connection) {
        if(connection.equalsIgnoreCase("wifi"))
            pack.addComponents(new Wifi());
        else if(connection.equalsIgnoreCase("gsm"))
            pack.addComponents(new GSM());
    }

    @Override
    public void setStorageName() {
        pack.addComponents(new SD_Card());
    }

    @Override
    public void setControllerName() {
        pack.addComponents(new Button());
    }

    @Override
    public void setFrameworkName(String framework) {
        if(framework.equalsIgnoreCase("django"))
            pack.addComponents(new Django());
        else if(framework.equalsIgnoreCase("spring"))
            pack.addComponents(new Spring());
        else if(framework.equalsIgnoreCase("laravel"))
            pack.addComponents(new Laravel());
    }
}
