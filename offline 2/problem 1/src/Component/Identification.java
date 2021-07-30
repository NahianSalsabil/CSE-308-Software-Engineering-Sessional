package Component;

import Component.Components;

public abstract class Identification implements Components {
    @Override
    public String getMicroprocessorName() {
        return null;
    }

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

    public abstract String getIdentificationName();

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
