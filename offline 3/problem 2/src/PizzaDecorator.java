public abstract class PizzaDecorator implements Pizza{
    public Pizza newPizza;
    public PizzaDecorator(Pizza newPizza){
        this.newPizza = newPizza;
    }

    @Override
    public double cost(){
        return newPizza.cost();
    }
}
