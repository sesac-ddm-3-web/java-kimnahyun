package exam.part7;

public class Item {
    public String name;
    public int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public final void displayInfo() {
        System.out.println("상품명: " + name + ", 가격: " + price + "원");
    }

    public int getFinalPrice() {
        return price + 3000;
    }
}
