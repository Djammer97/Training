package day12.task5;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    ArrayList<MusicArtist> members = new ArrayList<>();

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public MusicBand(String name, int year, List<MusicArtist> members) {
        this.name = name;
        this.year = year;
        this.members = (ArrayList<MusicArtist>) members;
    }

    public ArrayList<MusicArtist> getMembers() {
        return members;
    }

    public void addMember(MusicArtist member) {
        members.add(member);
    }

    public void deleteMember(int index) {
        members.remove(index);
    }

    public int getYear() {
        return year;
    }

    public static void transferMembers(MusicBand bandFrom, MusicBand bandTo) {
        List<MusicArtist> member = bandFrom.getMembers();
        for (int i = member.size() - 1; i >= 0; i--) {
            bandTo.addMember(member.get(i));
            bandFrom.deleteMember(i);
        }
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
