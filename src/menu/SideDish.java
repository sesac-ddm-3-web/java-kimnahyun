package menu;

public class SideDish extends MenuItem {
    private String size;

    public SideDish(int id, String name, int price, int cookingTime, int stock, String size) {
        super(id, name, price, MenuCategory.SIDE_DISH, cookingTime, stock);
        this.size = size;
    }

    /*
        3. 감자튀김 - 5,000원
       설명: 사이드 메뉴 - 감자튀김 (사이즈: MEDIUM)
       조리시간: 10분
       재고: 15개
       주문가능: ⭕
         */
    @Override
    public void getDescription() {
        // 크기 옵션
        System.out.println(id + ". " + name + " - " + price + "원");
        System.out.println("설명 : " + category.getDisplayName() + " - " + name + " (사이즈: " + size + ")");
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
