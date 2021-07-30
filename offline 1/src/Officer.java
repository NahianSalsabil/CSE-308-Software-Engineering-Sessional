package sample;

public class Officer extends Employee {
    @Override
    public void approveLoan(){
        for(int i = 0; i < Bank.account.size(); i++){
            if(Bank.account.get(i).getLoan_request()){
                if((Bank.account.get(i).getLoan_amount() < Bank.account.get(i).getBalance()) && (Bank.account.get(i).getLoan_amount() <= Bank.getFund())){
                    Bank.account.get(i).setLoan_request(false);
                    Bank.account.get(i).setLoan(true);
                    Bank.account.get(i).setBalance(Bank.account.get(i).getBalance()+Bank.account.get(i).getLoan_amount());
                    Bank.setFund(Bank.getFund() - Bank.account.get(i).getLoan_amount());
                    System.out.println("Loan for "+ Bank.account.get(i).getName()+ " approved");
                }
                else{
                    Bank.account.get(i).setLoan_request(false);
                    Bank.account.get(i).setLoan(false);
                    System.out.println("Loan for "+ Bank.account.get(i).getName()+ " denied");
                }
            }
        }
    }


}
