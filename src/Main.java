import java.util.*;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Scanner sc = new Scanner(System.in);

        // 1. Repository 생성 및 데이터 초기화
        ClothingRepository repository = new ClothingRepository(); // 샘플 데이터 추가
        ImageResolver.fillMissingPaths(repository.getAllItems()); // 이미지 경로 추가

        boolean play = true;

        System.out.println("===== 랜덤 코디 추천 =====");
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
                    System.out.println("\n==== 오늘의 추천 코디 ====");
                    view.showRandomOutfit(outfit);
                    ImageViewer.showOutfit(outfit);

                    break;
                case 2:
                    System.out.println("\n==== 코디 히스토리 ====");
                    Map<String, List<Outfit>> myOutfits = repository.getMyOutfits();
                    view.showMyOutfit(myOutfits);
                    break;
                case 3:
                    System.out.println("종료합니다.");
                    play = false;
                    break;
                default:
                    System.out.println("1, 2, 3만 선택해주세요\n");
                    break;
            }
        }
    }
}