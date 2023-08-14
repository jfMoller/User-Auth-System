public class DishWasher extends WorkState {

    public DishWasher(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }

    public void doDishes() {
        setHasWorkToDo(true);
        if (this.hasWorkToDo) System.out.println("Dishes are being done.");
        setHasWorkToDo(false);
    }
}
