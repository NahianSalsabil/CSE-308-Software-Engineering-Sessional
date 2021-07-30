package sample;

public class MakeComponent {
    private PackageBuilder packagebuilder;

    public MakeComponent(PackageBuilder packagebuilder){
        this.packagebuilder = packagebuilder;
    }

    public void makeComponents(String connection, String framework){
        packagebuilder.setMicroprocessorName();
        packagebuilder.setWeightMeasurementName();
        packagebuilder.setIdentificationName();
        packagebuilder.setDisplayName();
        packagebuilder.setInternetConnection(connection);
        packagebuilder.setStorageName();
        packagebuilder.setControllerName();
        packagebuilder.setFrameworkName(framework);
    }
}
