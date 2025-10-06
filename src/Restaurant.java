import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;
    private List<Order> orders;

    public void displayMenu(MenuCategory category) { }
    public Order createOrder() { }
    public void processOrder(Order order, PaymentMethod payment) { }
}