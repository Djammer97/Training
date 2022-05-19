package day12.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<MusicBand> music = new ArrayList<>();
        music.add(new MusicBand("Nirvana", 1967));
        music.add(new MusicBand("The Cranberries", 1989));
        music.add(new MusicBand("Король и шут", 1988));
        music.add(new MusicBand("Sabaton", 1999));
        music.add(new MusicBand("Би-2", 1988));
        music.add(new MusicBand("Imagine Dragons", 2008));
        music.add(new MusicBand("Linkin Park", 2000));
        music.add(new MusicBand("Black Veil Brides", 2006));
        music.add(new MusicBand("Hollywood Undead", 2005));
        music.add(new MusicBand("Wig Wam", 2001));
        System.out.println(music);
        Collections.shuffle(music);
        System.out.println(music);
        System.out.println(groupsAfter2000(music));
    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        List<MusicBand> music = new ArrayList<>();
        for (MusicBand band : bands) {
            if (band.getYear() > 2000) {
                music.add(band);
            }
        }
        return music;
    }
}
