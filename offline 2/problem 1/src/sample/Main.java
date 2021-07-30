package sample;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Package Name, Connection Name and Framework Name:");
        String packagename = scanner.nextLine();
        String connection = scanner.nextLine();
        String framework = scanner.nextLine();
        if((packagename.equalsIgnoreCase("silver") || packagename.equalsIgnoreCase("gold")) && connection.equalsIgnoreCase("ethernet")){
            System.out.println("The features are not compatible");
            return;
        }

        if(packagename.equalsIgnoreCase("silver")){
            Package pack = new Package();
            PackageBuilder packagebuilder = new SilverBuilder(pack);
            MakeComponent component = new MakeComponent(packagebuilder);
            component.makeComponents(connection,framework);
            pack.showItems();

        }
        else if(packagename.equalsIgnoreCase("gold")){
            Package pack = new Package();
            PackageBuilder packagebuilder = new GoldBuilder(pack);
            MakeComponent component = new MakeComponent(packagebuilder);
            component.makeComponents(connection,framework);
            pack.showItems();
        }
        else if(packagename.equalsIgnoreCase("diamond")){
            Package pack = new Package();
            PackageBuilder packagebuilder = new DiamondBuilder(pack);
            MakeComponent component = new MakeComponent(packagebuilder);
            component.makeComponents(connection,framework);
            pack.showItems();
        }
        else if(packagename.equalsIgnoreCase("platinum")){
            Package pack = new Package();
            PackageBuilder packagebuilder = new PlatinumBuilder(pack);
            MakeComponent component = new MakeComponent(packagebuilder);
            component.makeComponents(connection,framework);
            pack.showItems();
        }


    }
}
