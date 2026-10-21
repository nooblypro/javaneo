import java.util.*;

interface Playable {
    String play();
    String pause();
}

class AudioTrack implements Playable {
    private String title;
    public AudioTrack(String title) { this.title = title; }
    public String play() { return "Playing audio track: " + title; }
    public String pause() { return "Paused audio track: " + title; }
}

class VideoClip implements Playable {
    private String title;
    public VideoClip(String title) { this.title = title; }
    public String play() { return "Playing video clip: " + title; }
    public String pause() { return "Paused video clip: " + title; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        String title = sc.next();
        String action = sc.next();
        Playable p = type.equals("AUDIO") ? new AudioTrack(title) : new VideoClip(title);
        if (action.equals("PLAY")) {
            System.out.println(p.play());
        } else {
            System.out.println(p.pause());
        }
    }
}
