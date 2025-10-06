import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private List<OrderItem> items;
    private OrderStatus status;
    private LocalDateTime orderTime;
    private int totalAmount;

    public void addItem(MenuItem menuItem, int quantity) { }
    public void removeItem(String menuItemId) { }
    public int calculateTotal() { }
    public void updateStatus(OrderStatus status) { }
}