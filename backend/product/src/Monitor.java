public class Monitor extends Product {
    private int size;
    private String resolution;

    public Monitor(String model, int width, int height, int depth, int size, String resolution) {
        super(model, width, height, depth);
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println(String.format("Drawing pixel at %d,%d in color %s", x, y, color));
    }
}