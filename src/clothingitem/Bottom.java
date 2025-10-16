package clothingitem;

import option.Gender;
import option.Season;
import option.Style;

import java.util.Set;

public class Bottom extends ClothingItem {

    public Bottom(String name, Set<Gender> gender, Set<Season> season, Set<Style> style, String color, String category) {
        super(name, gender, season, style, color, category);
    }
}
