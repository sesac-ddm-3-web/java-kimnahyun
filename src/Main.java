import java.util.*;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Scanner sc = new Scanner(System.in);

        // 1. Repository 생성 및 데이터 초기화
        ClothingRepository repository = new ClothingRepository(); // 샘플 데이터 추가

        boolean play = true;
        while (play) {
            view.displayMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // 2. OutfitGenerator 생성
                    List<String> optionInput = view.getUserInput();

                    OutfitGenerator generator = new OutfitGenerator(repository);
                    Outfit outfit = generator.generateOutfit(optionInput.get(0), optionInput.get(1), optionInput.get(2));

                    // 3. View 생성 및 저장
                    System.out.println("\n====  오늘의 추천 코디 ====");
                    view.showRandomOutfit(outfit);
                    break;
                case 2:
                    Map<String, Outfit> myOutfits = repository.getMyOutfits();
                    view.showMyOutfit(myOutfits);
                    break;
                case 3:
                    System.out.println("종료합니다.");
                    play = false;
                    break;
                default:
                    System.out.println("1, 2, 3만 선택해주세요");
                    break;
            }
        }


    }
}