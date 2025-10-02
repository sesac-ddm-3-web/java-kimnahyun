package part9;

public class Computer {
    private String brand;
    private String model;

    Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }

    public static class CPU {
        private int cores;
        private double speed;

        public CPU(int cores, double speed) {
            this.cores = cores;
            this.speed = speed;
        }

        public String getSpecification() {
            return cores + "코어, " + speed + "GHz";
        }
    }
}
