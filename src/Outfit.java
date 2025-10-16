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
}