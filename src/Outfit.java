import clothingitem.Accessory;
import clothingitem.Bottom;
import clothingitem.Shoes;
import clothingitem.Top;

public class Outfit {
    Top top;
    Bottom bottom;
    Shoes shoes;
    Accessory accessory;

    public Outfit(Top top, Bottom bottom, Shoes shoes, Accessory accessory) {
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
        this.accessory = accessory;
    }

    public Top getTop() {
        return top;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public Accessory getAccessory() {
        return accessory;
    }
}