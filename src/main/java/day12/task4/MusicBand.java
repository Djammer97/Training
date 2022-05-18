package day12.task4;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    ArrayList<String> members = new ArrayList<>();

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public MusicBand(String name, int year, List<String> members) {
        this.name = name;
        this.year = year;
        this.members = (ArrayList<String>) members;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void addMember(String member) {
        members.add(member);
    }

    public void deleteMember(int index) {
        members.remove(index);
    }

    public int getYear() {
        return year;
    }

    public static void transferMembers(MusicBand bandFrom, MusicBand bandTo) {
        List<String> member = bandFrom.getMembers();
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
