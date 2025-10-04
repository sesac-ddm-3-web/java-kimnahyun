package part15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MarathonRunner {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> mapP = new HashMap<>();

        for (String str : participant) {
            if (!mapP.containsKey(str)) {
                mapP.put(str, 1);
            } else {
                mapP.put(str, 2);
            }
        }

        for (String str : completion) {
            if (mapP.containsKey(str)) {
                if (mapP.get(str) == 1) {
                    mapP.remove(str);
                } else {
                    mapP.put(str, mapP.get(str) - 1);
                }
            }
        }

        if (!mapP.isEmpty()) {
            Set<String> keys = mapP.keySet();
            String result = "";
            for (String key : keys) {
                result += key;
            }
            return result;
        }

        return "all finish";
    }

    public static void main(String[] args) {
        MarathonRunner solver = new MarathonRunner();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String result = solver.solution(participant, completion);
        System.out.println("Did not finish: " + result); // 예상 출력: "mislav"
    }
}