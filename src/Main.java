import menu.MenuCategory;
import order.Order;
import pay.CardPayment;
import pay.CashPayment;
import pay.PointPayment;
import view.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        View view = new View();
        Scanner sc = new Scanner(System.in);

        boolean play = true;

        while (play) {
            view.showStartOption();

            int choice = sc.nextInt();
            System.out.println();

            Order currentOrder = null;

            switch (choice) {
                case 1:
                    System.out.println("===== 메뉴 상세 정보 =====");

                    // 메뉴 출력
                    restaurant.displayMenu(MenuCategory.MAIN_DISH);
                    restaurant.displayMenu(MenuCategory.SIDE_DISH);
                    restaurant.displayMenu(MenuCategory.BEVERAGE);
                    restaurant.displayMenu(MenuCategory.DESSERT);
                    break;
                case 2:
                    currentOrder = restaurant.createOrder();
                    break;
                case 3:
                    if (currentOrder == null) {
                        System.out.println("먼저 주문을 생성하세요. (2번) ⚠️⚠️\n");
                        break;
                    }

                    view.showSelectPayment();
                    int selectedPayment = sc.nextInt();

                    if (selectedPayment == 1) {
                        String cardNum = view.promptCard();
                        restaurant.processOrder(currentOrder, new CardPayment(cardNum));
                    } else if (selectedPayment == 2) {
                        view.promptCash();
                        restaurant.processOrder(currentOrder, new CashPayment());
                    } else if (selectedPayment == 3) {
                        int point = view.promptPoint();
                        restaurant.processOrder(currentOrder, new PointPayment(point));
                    } else {
                        System.out.println("1~3번 중에서 선택해주세요.");
                        break;
                    }

                    currentOrder = null;
                    break;
                case 4:
                    System.out.println("종료하겠습니다.");
                    play = false;
                    break;
                default:
                    System.out.println("1, 2, 3, 4만 입력해주세요.");
                    break;
            }

        }

    }
}
