package day13;

import java.util.ArrayList;
import java.util.List;

import static day13.MessageDatabase.addNewMessage;

public class User {
    private String username;
    List<User> subscriptions;
    List<User> friends;

    public User(String username) {
        this.username = username;
        subscriptions = new ArrayList<>();
        friends = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }

    public void subscribe(User user) {
        if (user.isSubscribed(this)) {
            friends.add(user);
            user.removeSubscription(this);
            user.addFriend(this);
        } else {
            subscriptions.add(user);
        }
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void removeSubscription(User user) {
        subscriptions.remove(user);
    }

    public void removeFriend(User user) {
        friends.remove(user);
    }

    public boolean isSubscribed(User user) {
        return subscriptions.contains(user);
    }

    public boolean isFriend(User user) {
        return friends.contains(user);
    }

    public void sendMessage(User user, String text) {
        addNewMessage(this, user, text);
    }

    public String toString() {
        return username;
    }
}
