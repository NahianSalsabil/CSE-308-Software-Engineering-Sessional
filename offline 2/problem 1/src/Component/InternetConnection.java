package Component;

import Component.Components;

public abstract class InternetConnection implements Components {
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

    public abstract String getInternetConnectionName();

    @Override
    public String getStorageName() {
        return null;
    }

    @Override
    public String getControllerName() {
        return null;
    }
}
