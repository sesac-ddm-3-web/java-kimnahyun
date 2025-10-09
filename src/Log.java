import java.util.LinkedHashMap;
import java.util.Map;

public class Log {

    private Map<Integer, String> savedLog = new LinkedHashMap<>();

    public void saveLog(String result) {
        savedLog.put(savedLog.size(), result);
    }

    public void viewLog() {
        for (int i = 0; i < savedLog.size(); i++) {
            System.out.println(savedLog.get(i));
        }
    }
}
