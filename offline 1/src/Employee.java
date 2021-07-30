package sample;

public class Employee {

    public void lookup(String name){
        for(int i = 0; i < Bank.account.size(); i++){
            if(Bank.account.get(i).getName().equalsIgnoreCase(name)){
                System.out.println(Bank.account.get(i).getName()+"'s current balance is "+Bank.account.get(i).getBalance()+"$");
            }
        }
    }

    public void approveLoan(){

    }

    public void seeFund(){
        System.out.println("You don’t have permission for this operation");
    }

    public void changeIntersetRate(String type,Double rate){
        System.out.println("You don’t have permission for this operation");
    }
}
