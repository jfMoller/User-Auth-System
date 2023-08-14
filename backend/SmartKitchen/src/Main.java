public class Main {
    public static void main(String[] args) {
SmartKitchen kitchen = new SmartKitchen(new CoffeeMaker(false), new DishWasher(false), new Refrigerator(false));
kitchen.setKitchenState(true, true, true);
    }
}
