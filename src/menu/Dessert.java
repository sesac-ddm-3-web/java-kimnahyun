package menu;

public class Dessert extends MenuItem {
    private String sweetness;
    private String allergyInfo;

    public Dessert(int id, String name, int price, int cookingTime, int stock, String sweetness, String allergyInfo) {
        super(id, name, price, MenuCategory.DESSERT, cookingTime, stock);
        this.sweetness = sweetness;
        this.allergyInfo = allergyInfo;
    }

    @Override
    public void getDescription() {
        // 당도, 알레르기 정보
        System.out.println(id + ". " + name + " - " + price + "원");
        System.out.println("설명 : " + category.getDisplayName() + " - " + name + " (당도: " + sweetness + ", 알레르기 : " + allergyInfo + ")");
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
