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
    String imagePath;

    public ClothingItem(String name, Set<Gender> gender, Set<Season> season, Set<Style> style, String color, String category, String imagePath) {
        this.name = name;
        this.gender = gender;
        this.season = season;
        this.style = style;
        this.color = color;
        this.category = category;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}