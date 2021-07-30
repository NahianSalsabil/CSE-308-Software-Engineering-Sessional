package Component;

import Component.Components;

public abstract class Storage implements Components {
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

    @Override
    public String getIdentificationName() {
        return null;
    }

    @Override
    public String getInternetConnectionName() {
        return null;
    }

    public abstract String getStorageName();

    @Override
    public String getControllerName() {
        return null;
    }
}
