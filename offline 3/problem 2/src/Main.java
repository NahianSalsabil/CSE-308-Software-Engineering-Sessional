import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        do{
            System.out.println("Menu:");
            System.out.println("1.Beef Pizza with French fry");
            System.out.println("2.Veggi Pizza with onion rings");
            System.out.println("3.A combo meal with Veggi Pizza, French Fry and Coke");
            System.out.println("4.A combo meal with Veggi Pizza, Onion Rings and Coffee");
            System.out.println("5.A Beef Pizza only");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:{         // Beef Pizza with French fry
                    Pizza meal = new French_Fry((Pizza) new Beef_Pizza());
                    System.out.println("Total Cost: " + meal.cost());
                }
                break;

                case 2:{           // Veggi Pizza with onion rings
                    Pizza meal = new Onion_Ring((Pizza) new Veggi_Pizza());
                    System.out.println("Total Cost: " + meal.cost());
                }
                break;
                case 3:{           // A combo meal with Veggi Pizza, French Fry and Coke
                    Pizza meal = new Coke((Pizza) new French_Fry((Pizza) new Veggi_Pizza()));
                    System.out.println("Total Cost: " + meal.cost());
                }
                break;
                case 4:{          // A combo meal with Veggi Pizza, Onion Rings and Coffee
                    Pizza meal = new Coffee((Pizza) new Onion_Ring((Pizza) new Veggi_Pizza()));
                    System.out.println("Total Cost: " + meal.cost());
                }
                break;
                case 5:{          // A Beef Pizza only
                    Beef_Pizza beef_pizza = new Beef_Pizza();
                    System.out.println("Total Cost: " + beef_pizza.cost());
                }
                break;

                default:{
                    System.out.println("Not Available!");
                }
                return;
            }

        }
        while(choice!=6);
    }
}

