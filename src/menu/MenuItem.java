package menu;

import menu.MenuCategory;

public abstract class MenuItem {
    protected int id;
    protected String name;
    protected int price;
    protected MenuCategory category;
    protected int cookingTime;
    protected int stock;

    public MenuItem(int id, String name, int price, MenuCategory category, int cookingTime, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.cookingTime = cookingTime;
        this.stock = stock;
    }

    // 각 메뉴 타입별로 다른 설명 표시
    public abstract void getDescription();

    // --------------- 공통 메서드 ---------------

    // 조리 시간
    public int getCookingTime() {
        return cookingTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    // 재고 기반 주문 가능 여부 확인
    public boolean isAvailable() {
        return stock > 0;
    }

    public void reduceStock(int quantity) {
        // 재고 감소 로직
        stock -= quantity;
    }
}