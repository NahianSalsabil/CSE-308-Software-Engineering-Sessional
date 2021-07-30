package sample;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                String input = scanner.nextLine();
                bank.takeInput(input);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }



    }
}
