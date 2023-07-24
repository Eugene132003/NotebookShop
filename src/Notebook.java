public class Notebook {
    private String brand;
    private String model;
    private String processor;
    private double screenSize;
    private int hddSize;
    private int rom;

    public Notebook(String brand, String model, String processor, double screenSize, int hddSize, int rom) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.screenSize = screenSize;
        this.hddSize = hddSize;
        this.rom = rom;

    }

    public String printInfo(){
        System.out.printf("Brand: %s, Model: %s, Processor: %s, ScreenSize: %s, Hdd Size: %s, ROM: %s", brand, model, processor, screenSize, hddSize, rom);
        return ".";
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProcessor() {
        return processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getHddSize() {
        return hddSize;
    }

    public int getRom() {
        return rom;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public void setHddSize(int hddSize) {
        this.hddSize = hddSize;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }
}
