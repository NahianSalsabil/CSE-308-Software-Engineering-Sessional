package sample;

import Component.concreteComponents.*;

public class DiamondBuilder implements PackageBuilder{
    private Package pack;
    public DiamondBuilder(Package pack){
        this.pack = pack;
    }

    @Override
    public void setMicroprocessorName() {
        pack.addComponents(new Raspberry_Pi());
    }

    @Override
    public void setWeightMeasurementName() {
        pack.addComponents(new load_sensor());
    }

    @Override
    public void setIdentificationName() {
        pack.addComponents(new NFC_Card());
    }

    @Override
    public void setDisplayName() {
        pack.addComponents(new Touch());
    }

    @Override
    public void setInternetConnection(String connection) {
        if(connection.equalsIgnoreCase("wifi"))
            pack.addComponents(new Wifi());
        else if(connection.equalsIgnoreCase("gsm"))
            pack.addComponents(new GSM());
        else if(connection.equalsIgnoreCase("ethernet"))
            pack.addComponents(new Ethernet());
    }

    @Override
    public void setStorageName() {
        pack.addComponents(new Auto_Storage());
    }

    @Override
    public void setControllerName() {
        pack.addComponents(new touch_screen());
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
