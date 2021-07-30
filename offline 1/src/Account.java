package sample;

public abstract class Account {
    private String name;
    private double balance;
    private String type;
    private boolean loan;
    private boolean loan_request;
    private int loan_amount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getLoan_request(){
        return loan_request;
    }

    public void setLoan_request(boolean loan_request) {
        this.loan_request = loan_request;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getLoan() {
        return loan;
    }

    public void setLoan(boolean loan) {
        this.loan = loan;
    }

    public int getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(int loan_amount) {
        this.loan_amount = loan_amount;
    }

    public void setInfo(String name, double balance, String type){
        setName(name);
        setBalance(balance);
        setType(type);
        System.out.println(type + " account for " + name + " Created; initial balance " + balance + "$");
    }

    public void deposit(int deposit_amount){
        setBalance(getBalance()+deposit_amount);
        System.out.println(deposit_amount+"$ deposited; current balance "+getBalance()+"$");
    }

    public abstract void withdraw(int amount);

    public void query(){
        if(getLoan())
                System.out.println("Current Balance "+getBalance()+"$, loan "+ getLoan_amount()+"$");
            else
                System.out.println("Current Balance "+getBalance()+"$");
    }

    public abstract void request(int loan_amount);

    public abstract void Interest(Account acnt);

    public void deduct(Account acnt){
        acnt.balance = acnt.balance - 500;
    }

    public void loanDeduct(Account acnt){
        acnt.balance = acnt.balance - acnt.loan_amount * 0.1;
    }
}
