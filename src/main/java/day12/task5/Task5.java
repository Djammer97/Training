package day12.task5;

import java.util.ArrayList;
import java.util.List;

import static day12.task5.MusicBand.transferMembers;

public class Task5 {
    public static void main(String[] args) {
        MusicBand imagineDragons = new MusicBand("Imagine Dragons", 2012);
        imagineDragons.addMember(new MusicArtist("Daniel Reynolds", 34));
        imagineDragons.addMember(new MusicArtist("Benjamin McKee", 37));
        System.out.println(imagineDragons);
        imagineDragons.printMembers();
        System.out.println();
        List<MusicArtist> members = new ArrayList<>();
        members.add(new MusicArtist("Daniel Sermon", 37));
        members.add(new MusicArtist("Daniel Platzman", 35));
        MusicBand someGroup = new MusicBand("Some Group", 2030, members);
        System.out.println(someGroup);
        someGroup.printMembers();
        System.out.println();
        transferMembers(someGroup, imagineDragons);
        System.out.println(imagineDragons);
        imagineDragons.printMembers();
        System.out.println();
        System.out.println(someGroup);
        someGroup.printMembers();
        System.out.println();
    }
}
