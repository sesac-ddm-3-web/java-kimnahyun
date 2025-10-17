package clothingitem;

import option.Gender;
import option.Season;
import option.Style;

import java.util.Set;

public class Accessory extends ClothingItem {
    public Accessory(String name, Set<Gender> gender, Set<Season> season, Set<Style> style, String color, String category, String imagePath) {
        super(name, gender, season, style, color, category, imagePath);
    }
}
