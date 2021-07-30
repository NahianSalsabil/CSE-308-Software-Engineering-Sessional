package Component;

import Component.Components;

public abstract class Framework implements Components {
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

    public abstract String getFrameworkName();

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
