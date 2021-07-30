public class French_Fry extends Appetizer{
    public French_Fry(Pizza newPizza) {
        super(newPizza);
    }

    public double cost(){
        return super.cost() + 100.0;
    }
}
