package day13;

import java.util.ArrayList;
import java.util.List;

public class MessageDatabase {
    private static List<Message> messages = new ArrayList<>();

    public static void addNewMessage(User u1, User u2, String text) {
        messages.add(new Message(u1, u2, text));
    }

    public static List<Message> getMessages() {
        return messages;
    }

    public static void showDialog(User u1, User u2) {
        for (Message message : messages) {
            if ((u1.equals(message.getSender()) && u2.equals(message.getReceiver())) ||
                    (u2.equals(message.getSender()) && u1.equals(message.getReceiver()))) {
                System.out.println(message.getSender() + ": " + message.getText());
            }
        }
    }
}
