public class Song {
    String title;
    String singer;

    public Song(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    @Override
    public boolean equals(Object obj) {
        Song song;
        if (!(obj instanceof Song)) {
            return false;
        }
        song = (Song) obj;

        if (this.title.equals(song.title)) {
            return this.singer.equals(song.singer);
        }

        return false;
    }

    @Override
    public String toString() {
        return "----------\n제목 : " + title + "\n가수 : " + singer + "\n-------------";
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }
}
