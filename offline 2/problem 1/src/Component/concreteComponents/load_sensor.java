package Component.concreteComponents;

import Component.WeightMeasurement;

public class load_sensor extends WeightMeasurement {
    @Override
    public String getWeightMeasurementName() {
        return "Load Sensor";
    }
}
