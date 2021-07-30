package Component.concreteComponents;

import Component.InternetConnection;

public class Ethernet extends InternetConnection {
    @Override
    public String getInternetConnectionName() {
        return "Ethernet";
    }
}
