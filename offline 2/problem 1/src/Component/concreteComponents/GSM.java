package Component.concreteComponents;

import Component.InternetConnection;

public class GSM extends InternetConnection {
    @Override
    public String getInternetConnectionName() {
        return "GSM";
    }
}
