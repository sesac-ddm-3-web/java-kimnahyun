package menu;

public class Beverage extends MenuItem {
    private int capacity;
    private String temperature;

    public Beverage(int id, String name, int price, int cookingTime, int stock, int capacity, String temperature) {
        super(id, name, price, MenuCategory.BEVERAGE, cookingTime, stock);
        this.capacity = capacity;
        this.temperature = temperature;
    }

    /*
        5. 콜라 - 3,000원
       설명: 음료 - 콜라 (500ml, COLD)
       조리시간: 2분
       재고: 25개
       주문가능: ⭕
         */
    @Override
    public void getDescription() {
        // 용량, 온도
        System.out.println(id + ". " + name + " - " + price + "원");
        System.out.println("설명 : " + category.getDisplayName() + " - " + name + " (" + capacity + "ml, " + temperature + ")");
        System.out.println("조리시간 : " + cookingTime + "분");
        System.out.println("재고 : " + stock + "개");
        System.out.print("주문가능 : ");

        if (isAvailable() == true) {
            System.out.println("⭕");
        } else {
            System.out.println("❌ (재고 부족)");
        }
    }
}
