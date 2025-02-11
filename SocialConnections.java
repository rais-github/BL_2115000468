import java.util.ArrayList;
import java.util.List;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }
}

class SocialConnections {
    private Node head;

    private class Node {
        User user;
        Node next;

        Node(User user) {
            this.user = user;
            this.next = null;
        }
    }

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        Node newNode = new Node(newUser);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
        }
    }

    public List<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friendId : user1.friendIds) {
                if (user2.friendIds.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    public List<Integer> displayAllFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            return user.friendIds;
        }
        return new ArrayList<>();
    }

    public User searchUserById(int userId) {
        return findUserById(userId);
    }

    public User searchUserByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.user.name.equals(name)) {
                return current.user;
            }
            current = current.next;
        }
        return null;
    }

    public int countFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            return user.friendIds.size();
        }
        return 0;
    }

    private User findUserById(int userId) {
        Node current = head;
        while (current != null) {
            if (current.user.userId == userId) {
                return current.user;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SocialConnections sc = new SocialConnections();
        sc.addUser(1, "Alice", 25);
        sc.addUser(2, "Bob", 30);
        sc.addUser(3, "Charlie", 35);

        sc.addFriendConnection(1, 2);
        sc.addFriendConnection(1, 3);

        System.out.println("Alice's friends: " + sc.displayAllFriends(1));
        System.out.println("Bob's friends: " + sc.displayAllFriends(2));
        System.out.println("Charlie's friends: " + sc.displayAllFriends(3));

        System.out.println("Mutual friends between Alice and Bob: " + sc.findMutualFriends(1, 2));

        sc.removeFriendConnection(1, 2);
        System.out.println("Alice's friends after removing Bob: " + sc.displayAllFriends(1));

        System.out.println("Number of friends Alice has: " + sc.countFriends(1));
    }
}