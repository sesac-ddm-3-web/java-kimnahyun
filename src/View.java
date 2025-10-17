import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public void displayMenu() { // 시작 화면
        System.out.println(
                "1. 코디 추천 받기\n" +
                        "2. 코디 히스토리 보기\n" +
                        "3. 종료");
        System.out.print("선택 : ");
    }

    public List<String> getUserInput() { // 옵션 입력
        System.out.print("성별 입력 (Male/Female): ");
        String gender = sc.next();
        System.out.print("상황 입력 (Casual/Office/Sports/Date/Party): ");
        String style = sc.next();
        System.out.print("계절 입력 (Spring/Summer/Fall/Winter): ");
        String season = sc.next();

        List<String> optionInput = Arrays.asList(gender, style, season);
        return optionInput;
    }

    public void showRandomOutfit(Outfit outfit) {
        System.out.println("\uD83D\uDC5A 상의 : " + outfit.top.getName());
        System.out.println("\uD83D\uDC56 하의 : " + outfit.bottom.getName());
        System.out.println("\uD83D\uDC5F 신발 : " + outfit.shoes.getName());
        System.out.println("\uD83D\uDD76 악세사리 : " + outfit.accessory.getName());
        System.out.println("-----------------------\n");
    }

    public void showMyOutfit(Map<String, List<Outfit>> myOutfits) {
        myOutfits.forEach((key, outfitList) -> {
            System.out.println("[" + key + "]");

            for (Outfit outfit : outfitList) {
                showRandomOutfit(outfit);
            }
        });
    }
}