package sample;

import java.util.Scanner;

public class ManagingDirector extends Officer{
    @Override
    public void seeFund(){
        System.out.println("Bank's Internal Fund "+Bank.getFund() + "$");
    }

    @Override
    public void changeIntersetRate(String type,Double rate){
        if(type.equalsIgnoreCase("student"))
            Student.setInterest_rate(rate);
        else if(type.equalsIgnoreCase("savings"))
            Savings.setInterest_rate(rate);
        else if(type.equalsIgnoreCase("fixed deposit"))
            FixedDeposit.setInterest_rate(rate);
        System.out.println("interset rate has been changed");
    }
}
