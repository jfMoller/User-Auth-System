public class CoffeeMaker extends WorkState {

    public CoffeeMaker(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }

    public void brewCoffee() {
        setHasWorkToDo(true);
        if (this.hasWorkToDo) System.out.println("Coffee is being brewed");
        setHasWorkToDo(false);
    }
}
