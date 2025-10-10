package menu;

public class MainDish extends MenuItem {

    /*
    1. 스테이크 - 25,000원
   설명: 메인 요리 - 스테이크 (난이도: HIGH, 800kcal)
   조리시간: 30분
   재고: 5개
   주문가능: ⭕
     */

    private String difficulty;
    private int calory;

    public MainDish(int id, String name, int price, int cookingTime, int stock, String difficulty, int calory) {
        super(id, name, price, MenuCategory.MAIN_DISH, cookingTime, stock);
        this.difficulty = difficulty;
        this.calory = calory;
    }

    @Override
    public void getDescription() {
        System.out.println(id + ". " + name + " - " + price + "원");
        System.out.println("설명 : " + category.getDisplayName() + " - " + name + " (난이도: " + difficulty + ", " + calory + "kcal)");
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
