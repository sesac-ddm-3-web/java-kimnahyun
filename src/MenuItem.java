public abstract class MenuItem {
    protected String id;
    protected String name;
    protected int price;
    protected MenuCategory category;
    protected int stock;

    // 추상 메서드: 각 메뉴 타입별로 다르게 구현
    public abstract String getDescription();
    public abstract int getPreparationTime(); // 조리 시간(분)
    public abstract boolean isAvailable(); // 주문 가능 여부

    // 공통 메서드
    public void reduceStock(int quantity) {
        // 재고 감소 로직
    }
}