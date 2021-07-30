public class Onion_Ring extends Appetizer{
    public Onion_Ring(Pizza newPizza) {
        super(newPizza);
    }

    public double cost(){
        return super.cost() + 100.0;
    }
}
