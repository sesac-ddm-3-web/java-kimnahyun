import clothingitem.*;
import option.Gender;
import option.Season;
import option.Style;

import java.util.*;

public class ClothingRepository {

    List<ClothingItem> items = new ArrayList<>();
    Map<String, List<Outfit>> myOutfits = new LinkedHashMap<>();

    public List<ClothingItem> filterClothes(String gender, String style, String season) {
        List<ClothingItem> matched = new ArrayList<>();
        for (ClothingItem item : items) {
            if (item.matches(gender, style, season)) {
                matched.add(item);
            }
        }
        return matched;
    }

    public void addMyOufit(String myOptions, Outfit outfit) {
        if (!myOutfits.containsKey(myOptions)) {
            myOutfits.put(myOptions, new ArrayList<Outfit>());
        }

        List<Outfit> outfitList = myOutfits.get(myOptions);
        outfitList.add(outfit);
    }

    public Map<String, List<Outfit>> getMyOutfits() {
        return myOutfits;
    }

    public ClothingRepository() {
        // 상의 -------------------------------------
        items.add(new Top(
                "흰 반팔 티셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "White",
                "Top"
        ));

        items.add(new Top(
                "흰 긴팔 티셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE, Style.OFFICE),
                "White",
                "Top"
        ));

        items.add(new Top(
                "검은 긴팔 티셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE, Style.OFFICE),
                "Black",
                "Top"
        ));

        items.add(new Top(
                "검은 반팔 티셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE),
                "Black",
                "Top"
        ));
        items.add(new Top(
                "핑크 반팔 티셔츠",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE),
                "Pink",
                "Top"
        ));

        items.add(new Top(
                "검은 크롭티",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.PARTY, Style.DATE),
                "Black",
                "Top"
        ));

        items.add(new Top(
                "흰 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "White",
                "Top"
        ));

        items.add(new Top(
                "하늘색 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "Sky Blue",
                "Top"
        ));

        items.add(new Top(
                "회색 맨투맨",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Gray",
                "Top"
        ));

        items.add(new Top(
                "네이비 니트",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.OFFICE),
                "Navy",
                "Top"
        ));

        items.add(new Top(
                "흰 후드티",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "White",
                "Top"
        ));

        items.add(new Top(
                "검은 니트 ",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Black",
                "Top"
        ));

        items.add(new Top(
                "베이지 니트 ",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Beige",
                "Top"
        ));

        items.add(new Top(
                "베이지 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Beige",
                "Top"
        ));

        items.add(new Top(
                "화이트 린넨 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "White",
                "Top"
        ));

        items.add(new Top(
                "네이비 폴로 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.OFFICE),
                "Navy",
                "Top"
        ));

        items.add(new Top(
                "블랙 실키 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.SUMMER, Season.FALL),
                EnumSet.of(Style.PARTY, Style.DATE),
                "Black",
                "Top"
        ));

        items.add(new Top(
                "블랙 터틀넥 니트",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.PARTY, Style.DATE, Style.CASUAL),
                "Black",
                "Top"
        ));

        // 하의 -----------------------------------------------
        items.add(new Bottom(
                "긴 청바지",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.OFFICE),
                "Blue",
                "Bottom"
        ));
        items.add(new Bottom(
                "청반바지",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Blue",
                "Bottom"
        ));

        items.add(new Bottom(
                "짧은 청바지",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE),
                "Blue",
                "Bottom"
        ));

        items.add(new Bottom(
                "검은 슬랙스",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "Black",
                "Bottom"
        ));

        items.add(new Bottom(
                "베이지 슬랙스",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "Beige",
                "Bottom"
        ));

        items.add(new Bottom(
                "베이지 린넨 슬랙스",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "Beige",
                "Bottom"
        ));

        items.add(new Bottom(
                "회색 트레이닝 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Gray",
                "Bottom"
        ));

        items.add(new Bottom(
                "검은 트레이닝 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Black",
                "Bottom"
        ));

        items.add(new Bottom(
                "베이지 짧은 치마",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.DATE, Style.PARTY),
                "Beige",
                "Bottom"
        ));
        items.add(new Bottom(
                "블랙 가죽 짧은 치마",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Black",
                "Bottom"
        ));
        items.add(new Bottom(
                "블랙 가죽 짧은 바지",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Black",
                "Bottom"
        ));
        items.add(new Bottom(
                "블랙 가죽 긴 바지",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Black",
                "Bottom"
        ));
        items.add(new Bottom(
                "브라운 가죽 짧은 치마",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Brown",
                "Bottom"
        ));
        items.add(new Bottom(
                "브라운 가죽 짧은 바지",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Brown",
                "Bottom"
        ));

        items.add(new Bottom(
                "카키색 버뮤다 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Khaki",
                "Bottom"
        ));

        items.add(new Bottom(
                "흰 반바지",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "White",
                "Bottom"
        ));
        items.add(new Bottom(
                "검은 반바지",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Black",
                "Bottom"
        ));

        items.add(new Bottom(
                "흰색 와이드 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.OFFICE),
                "White",
                "Bottom"
        ));
        items.add(new Bottom(
                "화이트 코튼 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.OFFICE, Style.PARTY),
                "White",
                "Bottom"
        ));

        items.add(new Bottom(
                "블랙 데님 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.DATE, Style.OFFICE),
                "Black",
                "Bottom"
        ));

        // 신발 -----------------------------------------------
        items.add(new Shoes(
                "흰 운동화",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.SUMMER, Season.FALL),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE, Style.OFFICE),
                "White",
                "Shoes"
        ));

        items.add(new Shoes(
                "검은 운동화",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.SUMMER, Season.FALL),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE, Style.OFFICE),
                "Black",
                "Shoes"
        ));

        items.add(new Shoes(
                "갈색 로퍼",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "Brown",
                "Shoes"
        ));

        items.add(new Shoes(
                "검은 구두",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.PARTY, Style.DATE),
                "Black",
                "Shoes"
        ));

        items.add(new Shoes(
                "베이지 샌들",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Beige",
                "Shoes"
        ));
        items.add(new Shoes(
                "베이지 어그부츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.DATE, Style.SPORTS),
                "Beige",
                "Shoes"
        ));

        items.add(new Shoes(
                "블랙 하이힐",
                EnumSet.of(Gender.FEMALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Black",
                "Shoes"
        ));

        items.add(new Shoes(
                "레드 하이힐",
                EnumSet.of(Gender.FEMALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Red",
                "Shoes"
        ));

        items.add(new Shoes(
                "블랙 워커",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.PARTY, Style.DATE),
                "Black",
                "Shoes"
        ));

        // 악세사리
        items.add(new Accessory(
                "갈색 가죽 시계",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE, Style.PARTY),
                "Brown",
                "Accessory"
        ));
        items.add(new Accessory(
                "블랙 타이",
                EnumSet.of(Gender.MALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.PARTY),
                "Black",
                "Accessory"
        ));

        items.add(new Accessory(
                "화이트 헤어밴드",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.SPORTS, Style.CASUAL),
                "White",
                "Accessory"
        ));

        items.add(new Accessory(
                "블랙 헤어밴드",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.SPORTS, Style.CASUAL),
                "Black",
                "Accessory"
        ));

        items.add(new Accessory(
                "실버 목걸이",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Silver",
                "Accessory"
        ));

        items.add(new Accessory(
                "실버 귀걸이",
                EnumSet.of(Gender.FEMALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Silver",
                "Accessory"
        ));

        items.add(new Accessory(
                "골드 목걸이",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Silver",
                "Accessory"
        ));

        items.add(new Accessory(
                "블랙 벨트",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "Black",
                "Accessory"
        ));

        items.add(new Accessory(
                "블랙 볼캡",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Black",
                "Accessory"
        ));
        items.add(new Accessory(
                "화이트 볼캡",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "White",
                "Accessory"
        ));
        items.add(new Accessory(
                "블루 볼캡",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Blue",
                "Accessory"
        ));

        items.add(new Accessory(
                "블랙 베레모",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Black",
                "Accessory"
        ));

        items.add(new Accessory(
                "회색 비니",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Gray",
                "Accessory"
        ));

        items.add(new Accessory(
                "갈색 가죽 팔찌",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Brown",
                "Accessory"
        ));

        items.add(new Accessory(
                "선글라스",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.PARTY, Style.DATE),
                "Black",
                "Accessory"
        ));
    }
}