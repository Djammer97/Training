package day12.task5;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<MusicArtist> members = new ArrayList<>();

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public MusicBand(String name, int year, List<MusicArtist> members) {
        this.name = name;
        this.year = year;
        this.members = members;
    }

    public List<MusicArtist> getMembers() {
        return members;
    }

    public void addMember(MusicArtist member) {
        members.add(member);
    }

    public void addMember(List<MusicArtist> member) {
        members.addAll(member);
    }

    public void deleteMember(int index) {
        members.remove(index);
    }

    public void deleteAllMembers() {
        members.clear();
    }

    public int getYear() {
        return year;
    }

    public static void transferMembers(MusicBand bandFrom, MusicBand bandTo) {
        bandTo.addMember(bandFrom.getMembers());
        bandFrom.deleteAllMembers();
    }

    public void printMembers() {
        System.out.println("Участники группы:\n" + members);
    }

    @Override
    public String toString() {
        return "Группа " + name +
                " основана в " + year;
    }
}
