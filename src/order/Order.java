package order;

import menu.MenuItem;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private List<OrderItem> items;
    private LocalDateTime orderTime;

    public Order(String orderId) {
        this.orderId = orderId;
        this.orderTime = LocalDateTime.now();
    }

    // 장바구니에 메뉴 추가
    public void addItem(MenuItem menuItem, int quantity) {
        items.add(new OrderItem(menuItem, quantity));
    }

    // 주문 내역 조회
    public void calculateTotal() {
        System.out.println("===== 장바구니 =====");

        int i = 1;
        int sumPrice = 0;
        int maxCookingTime = 0;

        for (OrderItem item : items) {
            System.out.println(i + ". " + item.getMenuItem().getName() + " x" + item.getQuantity() + ": " + item.getSubtotal() + "원");
            sumPrice += item.getSubtotal();

            if (maxCookingTime < item.getMenuItem().getCookingTime()) {
                maxCookingTime = item.getMenuItem().getCookingTime();
            }

            i++;
        }

        System.out.println("-------------------");
        System.out.println("총 금액 : " + sumPrice + "원");
        System.out.println("예상 조리 시간 : " + maxCookingTime + "분");
    }

}

/*
선택: 2

===== 주문하기 =====
메뉴 번호 입력: 1
수량 입력: 1

✅ '스테이크' 1개가 장바구니에 추가되었습니다.

계속 주문하시겠습니까? (y/n): y

메뉴 번호 입력: 5
수량 입력: 2

✅ '콜라' 2개가 장바구니에 추가되었습니다.

계속 주문하시겠습니까? (y/n): y

메뉴 번호 입력: 6
수량 입력: 1

✅ '초코케이크' 1개가 장바구니에 추가되었습니다.

계속 주문하시겠습니까? (y/n): n

===== 장바구니 =====
1. 스테이크 x1: 25,000원
2. 콜라 x2: 6,000원
3. 초코케이크 x1: 7,000원
─────────────────────────
총 금액: 38,000원
예상 조리 시간: 30분
 */