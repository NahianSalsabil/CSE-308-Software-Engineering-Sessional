package sample;

import java.util.ArrayList;

public class Bank {
    private static double initial_fund;
    private static int year_clock;
    static ArrayList<Account> account = new ArrayList<>();
    private int current_index;
    private  String current_emp;
    Employee MD,O1,O2,C1,C2,C3,C4,C5,current_obj;

    Bank(){
        initial_fund = 1000000;
        year_clock = 0;
        MD = new ManagingDirector();
        O1 = new Officer();
        O2 = new Officer();
        C1 = new Employee();
        C2 = new Employee();
        C3 = new Employee();
        C4 = new Employee();
        C5 = new Employee();
        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");
    }

    void takeInput(String inputString){
        String[] commands = inputString.split(" ");

        if(commands[0].equalsIgnoreCase("create")){
            String name = commands[1];
            String type = commands[2];
            int amount;
            if(type.equalsIgnoreCase("fixed")){
                type = type.concat(" deposit");
                amount = Integer.parseInt(commands[4]);
            }
            else
                amount = Integer.parseInt(commands[3]);

            if(!isExist(name)) {
                if (type.equalsIgnoreCase("fixed deposit")) {
                    if (amount >= 100000) {
                        account.add(new FixedDeposit());
                        account.get(account.size()-1).setInfo(name,amount,type);
                        current_index = account.size() - 1;
                    }
                    else
                        System.out.println("required amount is minimum 100000");
                }
                else if (type.equalsIgnoreCase("savings")) {
                    account.add(new Savings());
                    account.get(account.size()-1).setInfo(name,amount,type);
                    current_index = account.size() - 1;
                }
                else if (type.equalsIgnoreCase("student")) {
                    account.add(new Student());
                    account.get(account.size()-1).setInfo(name,amount,type);
                    current_index = account.size() - 1;
                }
            }
            else
                System.out.println("account already exists");
        }
        else if(commands[0].equalsIgnoreCase("deposit")){
            int deposit_amount = Integer.parseInt(commands[1]);
            account.get(current_index).deposit(deposit_amount);
        }
        else if(commands[0].equalsIgnoreCase("withdraw")){
            int amount = Integer.parseInt(commands[1]);
            account.get(current_index).withdraw(amount);
        }
        else if(commands[0].equalsIgnoreCase("query")){
            account.get(current_index).query();
        }
        else if(commands[0].equalsIgnoreCase("request")){
            int loan_amount = Integer.parseInt(commands[1]);
            account.get(current_index).request(loan_amount);
        }
        else if(commands[0].equalsIgnoreCase("Inc")){
            increment_year();
            for(int i = 0; i < account.size(); i++){
                account.get(i).Interest(account.get(i));
                if(account.get(i).getType().equalsIgnoreCase("fixed deposit") || account.get(i).getType().equalsIgnoreCase("Savings"))
                    account.get(i).deduct(account.get(i));
                if(account.get(i).getLoan())
                    account.get(i).loanDeduct(account.get(i));
            }
            System.out.println(year_clock+ " year passed");
        }
        else if(commands[0].equalsIgnoreCase("close")){
            if(current_emp == "MD" || current_emp == "O1" || current_emp == "O2" || current_emp == "C1" || current_emp == "C2" || current_emp == "C3" || current_emp == "C4" || current_emp == "C5"){
                System.out.println("Operations for "+ current_emp+ " closed");
                current_emp = "";
                current_obj = null;
            }
            else{
                System.out.println("Transaction Closed for " + account.get(current_index).getName());
                current_index = -1;
            }
        }
        else if(commands[0].equalsIgnoreCase("open")){
            String name = commands[1];
            if(name.equalsIgnoreCase("MD")){
                current_emp = "MD";
                current_obj = MD;
                System.out.print(name+ " active");
                if(isLoan())
                    System.out.println(", there are loan approvals pending");
                else
                    System.out.println("");
            }

            if(name.equalsIgnoreCase("O1")) {
                current_emp = "O1";
                current_obj = O1;
                System.out.print(name + " active");
                if (isLoan())
                    System.out.println(", there are loan approvals pending");
                else
                    System.out.println("");
            }
            if(name.equalsIgnoreCase("O2")){
                current_emp = "O2";
                current_obj = O2;
                System.out.print(name+ " active");
                if(isLoan())
                    System.out.println(", there are loan approvals pending");
                else
                    System.out.println("");
            }
            if(name.equalsIgnoreCase("C1")){
                current_emp = "C1";
                current_obj = C1;
                System.out.println(name+ " active");
            }
            if(name.equalsIgnoreCase("C2")) {
                current_emp = "C2";
                current_obj = C2;
                System.out.println(name + " active");
            }
            if(name.equalsIgnoreCase("C3")){
                current_emp = "C3";
                current_obj = C3;
                System.out.println(name+ " active");
            }
            if(name.equalsIgnoreCase("C4")){
                current_emp = "C4";
                current_obj = C4;
                System.out.println(name+ " active");
            }
            if(name.equalsIgnoreCase("C5")){
                current_emp = "C5";
                current_obj = C5;
                System.out.println(name+ " active");
            }

            for(int i = 0; i < account.size(); i++){
                if(account.get(i).getName().equalsIgnoreCase(name)){
                    current_index = i;
                    System.out.println("Welcome back, "+ name);
                    break;
                }
            }
        }
        else if(commands[0].equalsIgnoreCase("approve")){
            current_obj.approveLoan();
        }
        else if(commands[0].equalsIgnoreCase("change")){
            String type = commands[1];
            double rate;
            if(type.equalsIgnoreCase("fixed")){
                type = type.concat(" deposit");
                rate = Double.parseDouble(commands[3]);
            }
            else
                 rate = Double.parseDouble(commands[2]);
            current_obj.changeIntersetRate(type,rate);
        }
        else if(commands[0].equalsIgnoreCase("lookup")){
            String name = commands[1];
            current_obj.lookup(name);
        }
        else if(commands[0].equalsIgnoreCase("see")){
            current_obj.seeFund();
        }

    }
    static int getYear(){
        return year_clock;
    }

    static double getFund(){
        return initial_fund;
    }

    static void setFund(double fund){
        initial_fund = fund;
    }

    boolean isLoan(){
        for(int i = 0; i < account.size(); i++){
            if(account.get(i).getLoan_request())
                return true;
        }
        return false;
    }

    boolean isExist(String name){
            for(int i = 0; i < account.size(); i++){
                if(account.get(i).getName().equalsIgnoreCase(name)){
                    return true;
                }
            }
            return false;
    }

    void increment_year(){
        year_clock++;
    }

}
