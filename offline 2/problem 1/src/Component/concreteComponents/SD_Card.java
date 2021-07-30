package Component.concreteComponents;

import Component.Storage;

public class SD_Card extends Storage {
    @Override
    public String getStorageName() {
        return "SD Card";
    }
}
