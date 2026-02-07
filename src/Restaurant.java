import menu.*;
import order.Order;
import pay.PaymentMethod;
import pay.Receipt;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    Receipt receipt = new Receipt();
    Scanner sc = new Scanner(System.in);

    private List<MenuItem> menu = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public Restaurant() {
        // 메뉴 초기화
        // [메인 요리]
        menu.add(new MainDish(1, "스테이크", 25000, 30, 5, "HIGH", 800));
        menu.add(new MainDish(2, "파스타", 15000, 20, 8, "MEDIUM", 600));

        // [사이드 메뉴]
        menu.add(new SideDish(3, "감자튀김", 5000, 10, 15, "MEDIUM"));
        menu.add(new SideDish(4, "샐러드", 7000, 5, 10, "LARGE"));

        // [음료]
        menu.add(new Beverage(5, "콜라", 3000, 2, 80, 330, "COLD"));
        menu.add(new Beverage(6, "녹차", 4000, 5, 25, 450, "HOT"));

        // [디저트]
        menu.add(new Dessert(7, "초코케이크", 7000, 3, 8, "MEDIUM", "밀, 우유, 계란"));
        menu.add(new Dessert(8, "티라미수", 8000, 3, 0, "LOW", "밀, 우유, 계란"));
    }

    public void displayMenu(MenuCategory category) {
        System.out.println("[" + category.getDisplayName() + "]");

        for (MenuItem menuItem : menu) {
            if (menuItem.getCategory() == category) {
                menuItem.getDescription();
                System.out.println();
            }
        }
    }

    // 장바구니에 메뉴 추가
    public Order createOrder() {
        System.out.println("===== 주문하기 =====");
        System.out.print("닉네임을 입력해주세요 : ");

        String nickName = sc.next();

        Order myOrder = new Order(nickName); // 주문 전체

        boolean play = true;

        while (play) {
            System.out.print("메뉴 번호 입력 : ");
            int menuNum = sc.nextInt();

            System.out.print("수량 입력 : ");
            int count = sc.nextInt();
            System.out.println();

            MenuItem foundItem = null; // 주문 낱개
            for (MenuItem menuItem : menu) {
                if (menuItem.getId() == menuNum) {
                    foundItem = menuItem;
                    menuItem.reduceStock(count);
                }
            }

            // 메뉴 추가
            myOrder.addItem(foundItem, count);

            // 장바구니 추가 멘트
            System.out.println("✅ '" + foundItem.getName() + "' " + count + "개가 장바구니에 추가되었습니다.\n");

            // 계속 주문 멘트
            System.out.print("계속 주문하시겠습니까? (y/n) :");
            String keepOrder = sc.next();

            if (keepOrder.equals("n")) {
                play = false;
                myOrder.calculateTotal(); // 총액 계산
            } else if (!keepOrder.equals("n") && !keepOrder.equals("y")) {
                System.out.println("y/n만 입력하세요.");
            }
        }

        return myOrder;
    }


    // 결제 진행 - 결제 - 영수증
    public void processOrder(Order order, PaymentMethod payment) {
       if (payment.processPayment(order.getSumPrice())){
           receipt.viewReceipt(order, payment);
       }
    }
}

/*
===== 🍽️ 레스토랑 주문 시스템 =====

1. 메뉴 보기
2. 주문하기
3. 결제하기
4. 종료
선택: 1

===== 메뉴 상세 정보 =====
[메인 요리]
1. 스테이크 - 25,000원
   설명: 메인 요리 - 스테이크 (난이도: HIGH, 800kcal)
   조리시간: 30분
   재고: 5개
   주문가능: ⭕

2. 파스타 - 15,000원
   설명: 메인 요리 - 파스타 (난이도: MEDIUM, 600kcal)
   조리시간: 20분
   재고: 8개
   주문가능: ⭕

[사이드 메뉴]
3. 감자튀김 - 5,000원
   설명: 사이드 메뉴 - 감자튀김 (사이즈: MEDIUM)
   조리시간: 10분
   재고: 15개
   주문가능: ⭕

4. 샐러드 - 7,000원
   설명: 사이드 메뉴 - 샐러드 (사이즈: LARGE)
   조리시간: 5분
   재고: 10개
   주문가능: ⭕

[음료]
5. 콜라 - 3,000원
   설명: 음료 - 콜라 (500ml, COLD)
   조리시간: 2분
   재고: 25개
   주문가능: ⭕

[디저트]
6. 초코케이크 - 7,000원
   설명: 디저트 - 초코케이크 (당도: MEDIUM, 알레르기: 밀, 우유, 계란)
   조리시간: 3분
   재고: 8개
   주문가능: ⭕

7. 티라미수 - 8,000원
   설명: 디저트 - 티라미수 (당도: LOW, 알레르기: 밀, 우유, 계란)
   조리시간: 3분
   재고: 0개
   주문가능: ❌ (재고 부족)
 */