public class Computercase extends Product {
    private String powerSupply;
    public Computercase(String model, int width, int height, int depth, String powerSupply) {
        super(model, width, height, depth);
        this.powerSupply = powerSupply;
    }

    public void pressPowerButton() {
        System.out.println("Power button pressed");
    }
}