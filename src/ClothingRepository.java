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

    public List<ClothingItem> getAllItems() {
        return items;
    }

    public ClothingRepository() {
        // 상의 -------------------------------------
        items.add(new Top(
                "흰 반팔 티셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "White",
                "Top",
                null
        ));

        items.add(new Top(
                "흰 긴팔 티셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE, Style.OFFICE),
                "White",
                "Top",
                null
        ));

        items.add(new Top(
                "검은 긴팔 티셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE, Style.OFFICE),
                "Black",
                "Top",
                null
        ));

        items.add(new Top(
                "검은 반팔 티셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE),
                "Black",
                "Top",
                null
        ));
        items.add(new Top(
                "핑크 반팔 티셔츠",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE),
                "Pink",
                "Top",
                null
        ));

        items.add(new Top(
                "검정 크롭티",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.PARTY, Style.DATE),
                "Black",
                "Top",
                null
        ));

        items.add(new Top(
                "흰 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "White",
                "Top",
                null
        ));

        items.add(new Top(
                "하늘색 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "Sky Blue",
                "Top",
                null
        ));

        items.add(new Top(
                "회색 맨투맨",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Gray",
                "Top",
                null
        ));

        items.add(new Top(
                "네이비 니트",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.OFFICE),
                "Navy",
                "Top",
                null
        ));

        items.add(new Top(
                "흰 후드티",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "White",
                "Top",
                null
        ));

        items.add(new Top(
                "검은 니트",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Black",
                "Top",
                null
        ));

        items.add(new Top(
                "베이지 니트",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Beige",
                "Top",
                null
        ));

        items.add(new Top(
                "베이지 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Beige",
                "Top",
                null
        ));

        items.add(new Top(
                "화이트 반팔 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "White",
                "Top",
                null
        ));

        items.add(new Top(
                "네이비 셔츠",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "Navy",
                "Top",
                null
        ));

        items.add(new Top(
                "흰 블라우스",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.SUMMER, Season.FALL),
                EnumSet.of(Style.PARTY, Style.DATE, Style.OFFICE),
                "White",
                "Top",
                null
        ));

        items.add(new Top(
                "핑크 블라우스",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.SUMMER, Season.FALL),
                EnumSet.of(Style.PARTY, Style.DATE, Style.OFFICE),
                "Pink",
                "Top",
                null
        ));

        items.add(new Top(
                "블랙 터틀넥 니트",
                EnumSet.of(Gender.MALE, Gender.FEMALE),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.PARTY, Style.DATE, Style.CASUAL),
                "Black",
                "Top",
                null
        ));

// 하의 -----------------------------------------------
        items.add(new Bottom(
                "긴 연청 바지",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.OFFICE, Style.DATE),
                "Blue",
                "Bottom",
                null
        ));
        items.add(new Bottom(
                "긴 중청 바지",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.OFFICE, Style.DATE),
                "Blue",
                "Bottom",
                null
        ));
        items.add(new Bottom(
                "청반바지",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Blue",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "짧은 청바지",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE),
                "Blue",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "검은 슬랙스",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE, Style.PARTY),
                "Black",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "베이지 슬랙스",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE, Style.PARTY),
                "Beige",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "네이비 슬랙스",
                EnumSet.of(Gender.FEMALE, Gender.MALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE, Style.PARTY),
                "Navy",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "회색 트레이닝 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Gray",
                "Bottom",
                null
        ));
        items.add(new Bottom(
                "회색 트레이닝 반바지",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Gray",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "검은 트레이닝 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Black",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "베이지 짧은 치마",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.DATE, Style.PARTY),
                "Beige",
                "Bottom",
                null
        ));
        items.add(new Bottom(
                "블랙 가죽 짧은 치마",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Black",
                "Bottom",
                null
        ));
        items.add(new Bottom(
                "블랙 가죽 짧은 바지",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Black",
                "Bottom",
                null
        ));
        items.add(new Bottom(
                "블랙 가죽 긴 바지",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Black",
                "Bottom",
                null
        ));
        items.add(new Bottom(
                "브라운 가죽 짧은 치마",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Brown",
                "Bottom",
                null
        ));
        items.add(new Bottom(
                "브라운 가죽 짧은 바지",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.WINTER, Season.FALL),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Brown",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "카모 버뮤다 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Khaki",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "흰 반바지",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "White",
                "Bottom",
                null
        ));
        items.add(new Bottom(
                "검은 반바지",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Black",
                "Bottom",
                null
        ));

        items.add(new Bottom(
                "흰색 와이드 팬츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.OFFICE, Style.DATE, Style.PARTY),
                "White",
                "Bottom",
                null
        ));


// 신발 -----------------------------------------------
        items.add(new Shoes(
                "흰 운동화",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.SUMMER, Season.FALL),
                EnumSet.allOf(Style.class),
                "White",
                "Shoes",
                null
        ));

        items.add(new Shoes(
                "검은 운동화",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.SUMMER, Season.FALL),
                EnumSet.allOf(Style.class),
                "Black",
                "Shoes",
                null
        ));

        items.add(new Shoes(
                "갈색 로퍼",
                EnumSet.of(Gender.FEMALE),
                EnumSet.of(Season.SPRING, Season.FALL),
                EnumSet.of(Style.OFFICE, Style.DATE),
                "Brown",
                "Shoes",
                null
        ));

        items.add(new Shoes(
                "검은 구두",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.PARTY, Style.DATE),
                "Black",
                "Shoes",
                null
        ));

        items.add(new Shoes(
                "블랙 샌들",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.DATE, Style.SPORTS),
                "Black",
                "Shoes",
                null
        ));
        items.add(new Shoes(
                "베이지 어그부츠",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.DATE, Style.SPORTS),
                "Beige",
                "Shoes",
                null
        ));

        items.add(new Shoes(
                "블랙 하이힐",
                EnumSet.of(Gender.FEMALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Black",
                "Shoes",
                null
        ));

        items.add(new Shoes(
                "레드 하이힐",
                EnumSet.of(Gender.FEMALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Red",
                "Shoes",
                null
        ));

        items.add(new Shoes(
                "블랙 워커",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.PARTY, Style.DATE),
                "Black",
                "Shoes",
                null
        ));

// 악세사리
        items.add(new Accessory(
                "갈색 가죽 시계",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE, Style.PARTY),
                "Brown",
                "Accessory",
                null
        ));
        items.add(new Accessory(
                "블랙 타이",
                EnumSet.of(Gender.MALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.PARTY),
                "Black",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "화이트 헤어밴드",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.SPORTS, Style.CASUAL),
                "White",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "블랙 헤어밴드",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.SPORTS, Style.CASUAL),
                "Black",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "실버 목걸이",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Silver",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "실버 귀걸이",
                EnumSet.of(Gender.FEMALE),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Silver",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "골드 목걸이",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.DATE, Style.PARTY),
                "Silver",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "블랙 벨트",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE, Style.PARTY),
                "Black",
                "Accessory",
                null
        ));
        items.add(new Accessory(
                "브라운 벨트",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.OFFICE, Style.DATE, Style.PARTY),
                "Brown",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "블랙 볼캡",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Black",
                "Accessory",
                null
        ));
        items.add(new Accessory(
                "화이트 볼캡",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "White",
                "Accessory",
                null
        ));
        items.add(new Accessory(
                "블루 볼캡",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Blue",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "블랙 베레모",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS),
                "Black",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "회색 비니",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE),
                "Gray",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "블랙 비니",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.FALL, Season.WINTER),
                EnumSet.of(Style.CASUAL, Style.SPORTS, Style.DATE),
                "Black",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "갈색 가죽 팔찌",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.DATE),
                "Brown",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "실버 체인 팔찌",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.DATE, Style.PARTY),
                "Silver",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "골드 체인 팔찌",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.DATE, Style.PARTY),
                "Gold",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "선글라스",
                EnumSet.allOf(Gender.class),
                EnumSet.of(Season.SPRING, Season.SUMMER),
                EnumSet.of(Style.CASUAL, Style.PARTY, Style.DATE),
                "Black",
                "Accessory",
                null
        ));

        items.add(new Accessory(
                "뿔테 안경",
                EnumSet.allOf(Gender.class),
                EnumSet.allOf(Season.class),
                EnumSet.of(Style.CASUAL, Style.PARTY, Style.DATE, Style.OFFICE),
                "Black",
                "Accessory",
                null
        ));

    }

}