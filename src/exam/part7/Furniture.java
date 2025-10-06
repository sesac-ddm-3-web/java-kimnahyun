package exam.part7;

public class Furniture extends Item {

    Furniture(String name, int price) {
        super(name, price);
    }

    @Override
    public int getFinalPrice() {
        return super.getFinalPrice() + (price / 100) * 5;
    }
}
