package Component;

import Component.Components;

public abstract class Microprocessor implements Components {
    public abstract String getMicroprocessorName();


    @Override
    public String getWeightMeasurementName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getFrameworkName() {
        return null;
    }

    @Override
    public String getIdentificationName() {
        return null;
    }

    @Override
    public String getInternetConnectionName() {
        return null;
    }

    @Override
    public String getStorageName() {
        return null;
    }

    @Override
    public String getControllerName() {
        return null;
    }
}
