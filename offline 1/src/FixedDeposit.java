package sample;

public class FixedDeposit extends Account {
    static Double interest_rate;

    FixedDeposit(){
        interest_rate = 0.15;
    }

    public Double getInterest_rate() {
        return interest_rate;
    }

    public static void setInterest_rate(Double rate) {
        interest_rate = rate/100;
    }

    @Override
    public void deposit(int deposit_amount){
        if(deposit_amount >= 50000) {
            setBalance(getBalance()+deposit_amount);
            System.out.println(deposit_amount+"$ deposited; current balance "+getBalance()+"$");
        }
        else
            System.out.println("deposit amount is not sufficient");
    }
    @Override
    public void request(int loan_amount){
        if(loan_amount <= 100000){
            setLoan_request(true);
            setLoan_amount(loan_amount);
            System.out.println("Loan request successful, sent for approval");
        }
        else
            System.out.println("loan request denied");

    }
    @Override
    public void Interest(Account acnt){
        acnt.setBalance(acnt.getBalance() + acnt.getBalance() * getInterest_rate());
    }

    @Override
    public void withdraw(int amount){
        if(Bank.getYear() >= 1){
            setBalance(getBalance()-amount);
            System.out.println("money withdrawn. current balance "+ getBalance() +"$");
        }
        else
            System.out.println("Invalid transaction; current balance " +getBalance()+"$");
    }
}
