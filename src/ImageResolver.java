import clothingitem.ClothingItem;

import java.util.List;

public class ImageResolver {
    // 이미지 경로 자동 생성
    public static void fillMissingPaths(List<ClothingItem> items) {
        for (ClothingItem item : items) {
            if (item.getImagePath() == null || item.getImagePath().isBlank()) {
                item.setImagePath(toResourcePath(item));
            }
        }
    }

    // 경로 규칙: /images/{category}/{name}.jpg
    // -> /images/top/흰_반팔_티셔츠.jpg
    private static String toResourcePath(ClothingItem item) {
        String category = item.getCategory().toLowerCase().trim();
        String name = item.getName()
                .trim()
                .replaceAll("\\s+", "_")
                .replaceAll("[^_가-힣]", "");
       // return "/images/" + category + "/" + name + ".jpg";
        return "/" + category + "/" + name + ".png";
    }
}
