import java.util.ArrayList;


public class User {
    private ArrayList<Stocks> subscribedStock = new ArrayList<>();

    public User(){
    }

    public ArrayList<Stocks> getSubscribedStock(){
        return subscribedStock;
    }
    public void addStock(Stocks stock){
        subscribedStock.add(stock);
    }

    public void removeStock(Stocks stock){
        for(int i = 0; i < subscribedStock.size(); i++){
            if(subscribedStock.get(i) == stock){
                subscribedStock.remove(i);
            }
        }
    }
    public String ShowStock(){
        String stockdetails = "Your Subscribed Stock: \n";
       for(int i = 0; i < subscribedStock.size(); i++){
           System.out.println(subscribedStock.get(i).getStockname());
           stockdetails += subscribedStock.get(i).getStockname()  + " " + subscribedStock.get(i).getStockcount() + " " + subscribedStock.get(i).getStockprice() + "\n";
       }
       return stockdetails;
    }
}
