public class SmartKitchen {
    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen(CoffeeMaker brewMaster, DishWasher dishWasher, Refrigerator iceBox) {
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }

    public void addWater() {
        brewMaster.brewCoffee();
    }
    public void pourMilk() {
        iceBox.orderFood();
    }
    public void loadDishwasher() {
        dishWasher.doDishes();
    }
    public void setKitchenState(boolean isRequestingCoffee, boolean isConsumingFood, boolean isDishesDirty) {
        if (isRequestingCoffee) addWater();
        if (isConsumingFood) pourMilk();
        if (isDishesDirty) loadDishwasher();
    }
    public void doKitchenWork() {}


}
