package pay;

import menu.MenuItem;
import order.Order;
import order.OrderItem;

public class Receipt {

    public void viewReceipt(Order order, PaymentMethod payment) {
        System.out.println("===== 영수증 =====\n" +
                "닉네임 : " + order.getOrderId() +
                "\n주문시간: " + order.getOrderTime() +
                "\n─────────────────────────\n");

        for (OrderItem item : order.getItems()){
            String name =  item.getMenuItem().getName();
            int count = item.getQuantity();
            int subtotal = item.getSubtotal();
            System.out.println( name + " x " + count + " = " + subtotal );

        }

        System.out.println("─────────────────────────");


        System.out.println("총 금액 :          "  + order.getSumPrice() + "원");
        System.out.println("결제방법 :          "  + payment.getType().getDisplayName());
        System.out.println(payment.getPaymentReceipt());

        System.out.println("─────────────────────────");

        System.out.println();
    }
}
