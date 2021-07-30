public class Coffee extends Drinks {
    public Coffee(Pizza newPizza) {
        super(newPizza);
    }

    public double cost(){
        return super.cost() + 60.0;
    }
}
