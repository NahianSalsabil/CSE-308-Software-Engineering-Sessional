public class Coke extends Drinks{
    public Coke(Pizza newPizza) {
        super(newPizza);
    }

    public double cost(){
        return super.cost() + 25.0;
    }
}
