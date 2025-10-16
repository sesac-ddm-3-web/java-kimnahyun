import java.util.List;

public class Main {
    public static void main(String[] args) {
        View view = new View();

        // 1. Repository 생성 및 데이터 초기화
        ClothingRepository repository = new ClothingRepository(); // 샘플 데이터 추가

        boolean play = true;
        while (play){
            view.displayMenu();

        }

        // 2. OutfitGenerator 생성
        List<String> optionInput = view.getUserInput();

        OutfitGenerator generator = new OutfitGenerator(repository);
        Outfit outfit = generator.generateOutfit(optionInput.get(0), optionInput.get(1), optionInput.get(2));

        // 3. View 생성 및 실행
        view.showRandomOutfit(outfit);
    }
}