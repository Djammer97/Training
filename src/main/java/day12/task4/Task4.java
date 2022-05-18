package day12.task4;

import java.util.ArrayList;
import java.util.List;

import static day12.task4.MusicBand.transferMembers;

public class Task4 {
    public static void main(String[] args) {
        List<String> members = new ArrayList<>();
        members.add("Daniel Reynolds");
        members.add("Benjamin McKee");
        MusicBand imagineDragons = new MusicBand("Imagine Dragons", 2012, members);
        System.out.println(imagineDragons);
        imagineDragons.printMembers();
        System.out.println();
        MusicBand someGroup = new MusicBand("Some Group", 2030);
        someGroup.addMember("Daniel Sermon");
        someGroup.addMember("Daniel Platzman");
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
