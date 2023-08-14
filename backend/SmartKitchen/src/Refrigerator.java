public class Refrigerator extends WorkState {

    public Refrigerator(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }
    public void orderFood() {
        setHasWorkToDo(true);
        if (this.hasWorkToDo) System.out.println("Ordering food.");
        setHasWorkToDo(false);
    }
}
