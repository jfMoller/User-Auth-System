public class Motherboard extends Product {
    private int ramSlots;
    private int cardSlots;
    private String bios;

    public Motherboard(String model, int width, int height, int depth, int ramSlots, int cardSlots, String bios) {
        super(model, width, height, depth);
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Program " + programName + " is now loading...");
    }
}