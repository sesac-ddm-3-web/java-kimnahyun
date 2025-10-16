package clothingitem;

import option.Gender;
import option.Season;
import option.Style;

import java.util.Set;

public abstract class ClothingItem {
    String name;
    Set<Gender> gender;
    Set<Season> season;
    Set<Style> style;
    String color;
    String category;

    public ClothingItem(String name, Set<Gender> gender, Set<Season> season, Set<Style> style, String color, String category) {
        this.name = name;
        this.gender = gender;
        this.season = season;
        this.style = style;
        this.color = color;
        this.category = category;
    }

    public boolean matches(String gender, String style, String season) {
        return this.gender.contains(Gender.valueOf(gender.toUpperCase())) &&
                this.style.contains(Style.valueOf(style.toUpperCase())) &&
                this.season.contains(Season.valueOf(season.toUpperCase()));
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
}