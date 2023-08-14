public class Main {
    public static void main(String[] args) {
Computercase theCase = new Computercase("Dell", 40, 30, 5, "Fusion energy");
Monitor theMonitor = new Monitor("27inch Beast", 10, 10, 10, 27, "2540 + 1440");
Motherboard theMotherboard = new Motherboard("BD-2000", 10, 10 , 10, 4, 6, "v3.44");

PersonalComputer thePC = new PersonalComputer("2088 Beast", 30, 30, 30, theCase, theMonitor, theMotherboard);

//thePC.getMonitor().drawPixelAt(10, 10, "red");
//thePC.getMotherboard().loadProgram("Windows OS");
//thePC.getComputercase().pressPowerButton();

thePC.powerUp();
    }
}
