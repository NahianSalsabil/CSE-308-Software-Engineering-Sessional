package Component.concreteComponents;

import Component.InternetConnection;

public class Wifi extends InternetConnection {
    @Override
    public String getInternetConnectionName() {
        return "Wifi";
    }
}
