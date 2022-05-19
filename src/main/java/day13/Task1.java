package day13;

import static day13.MessageDatabase.showDialog;

public class Task1 {
    public static void main(String[] args) {
        User djammer = new User("Djammer");
        User black = new User("Black");
        User morty = new User("Morty");
        djammer.sendMessage(black, "Привет");
        djammer.sendMessage(black, "Как дела?");
        black.sendMessage(djammer, "Здравствуй)");
        black.sendMessage(djammer, "Не очень...");
        black.sendMessage(djammer, "Я заболел");
        morty.sendMessage(djammer, "Ку");
        morty.sendMessage(djammer, "Го дс");
        morty.sendMessage(djammer, "Нам хил нужен");
        djammer.sendMessage(morty, "Ку");
        djammer.sendMessage(morty, "10 минут");
        djammer.sendMessage(morty, "И го");
        morty.sendMessage(djammer, "Ок");
        showDialog(djammer, morty);
    }
}
