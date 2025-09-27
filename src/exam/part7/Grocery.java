package exam.part7;

public class Grocery extends Item {
    Grocery(String name, int price) {
        super(name, price);
    }

    @Override
    public int getFinalPrice() {
        return price + 5000;
    }
}
