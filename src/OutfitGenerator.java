import clothingitem.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OutfitGenerator {
    private ClothingRepository repository;

    private Random random = new Random();

    public OutfitGenerator(ClothingRepository repository) {
        this.repository = repository;
    }

    public Outfit generateOutfit(String gender, String style, String season) {
        List<ClothingItem> tops = new ArrayList<>();
        List<ClothingItem> bottoms = new ArrayList<>();
        List<ClothingItem> shoesList = new ArrayList<>();
        List<ClothingItem> accessories = new ArrayList<>();

        List<ClothingItem> filtered = repository.filterClothes(gender, style, season);

        for (ClothingItem item : filtered) {
            switch (item.getCategory()) {
                case "Top" -> tops.add(item);
                case "Bottom" -> bottoms.add(item);
                case "Shoes" -> shoesList.add(item);
                case "Accessory" -> accessories.add(item);
            }
        }

        Top top = (Top) pickRandom(tops);
        Bottom bottom = (Bottom) pickRandom(bottoms);
        Shoes shoes = (Shoes) pickRandom(shoesList);
        Accessory accessory = (Accessory) pickRandom(accessories);

        Outfit outfit = new Outfit(top, bottom, shoes, accessory);

        String myOptions = gender + " / " + style + " / " + season;
        repository.addMyOufit(myOptions, outfit);

        return outfit;
    }

    private ClothingItem pickRandom(List<ClothingItem> item) {
        if (item == null || item.isEmpty()) return null;
        return item.get(random.nextInt(item.size()));
    }
}