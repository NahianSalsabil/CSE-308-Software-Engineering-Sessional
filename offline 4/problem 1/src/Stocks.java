public class Stocks {

    private String stockname;
    private int stockcount;
    private float stockprice;

    public Stocks(String stockname, int stockcount, float stockprice){
        this.stockname = stockname;
        this.stockcount = stockcount;
        this.stockprice = stockprice;
    }

    public String getStockname(){
        return this.stockname;
    }

    public int getStockcount(){
        return this.stockcount;
    }

    public float getStockprice(){
        return this.stockprice;
    }

    public void changeStockCount(int stockcount){
        this.stockcount += stockcount;
    }

    public void IncreaseStockPrice(float stockprice){
        this.stockprice += stockprice;
    }

    public void DecreaseStockPrice(float stockprice){
        this.stockprice -= stockprice;
    }

}
