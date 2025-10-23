import java.util.LinkedList;

public class RecentPlayList {
    private static final int LIMIT = 50;
    private LinkedList<Song> playList = new LinkedList<>();

    public void addPlayList(String title, String singer) {
        Song song = new Song(title, singer);

        if (playList.contains(song)) {
            playList.remove(song);
        }

        playList.addFirst(song);

        if (removeEldestEntry()) {
            playList.removeLast();
        }
    }

    private boolean removeEldestEntry() {
        return playList.size() > LIMIT;
    }

    public void print() {
        for (int i = 1; i < playList.size() + 1; i++) {
            System.out.print(i + " |");
            System.out.println(playList.get(i - 1));
        }
    }
}