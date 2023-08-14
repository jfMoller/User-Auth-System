public class PersonalComputer extends Product{
    private Computercase computercase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PersonalComputer(String model, int width, int height, int depth, Computercase computercase, Monitor monitor, Motherboard motherboard) {
        super(model, width, height, depth);
        this.computercase = computercase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

  private void drawLogo() {
        monitor.drawPixelAt(1200,50,"Yellow");
  }

  public void powerUp() {
        computercase.pressPowerButton();
        drawLogo();
  }
}
