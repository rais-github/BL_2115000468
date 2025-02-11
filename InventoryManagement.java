import java.util.Comparator;

public class InventoryManagement {
    class Item {
        private String name;
        private int id;
        private int quantity;
        private double price;
        private Item next;

        public Item(String name, int id, int quantity, double price) {
            this.name = name;
            this.id = id;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    private Item head;

    public InventoryManagement() {
        this.head = null;
    }

    private void addAtStart(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    private void addAtPosition(String name, int id, int quantity, double price, int position) {
        if (position == 0) {
            addAtStart(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    private void addAtLast(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    private Item searchItem(String name, int id) {
        Item temp = head;
        while (temp != null) {
            if ((name != null && temp.name.equals(name)) || temp.id == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    private void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    private void updateItem(int id) {
        Item updatableItem = searchItem(null, id);
        if (updatableItem == null) return;
        System.out.println("Enter new name, quantity and price");
        String name = System.console().readLine();
        int quantity = Integer.parseInt(System.console().readLine());
        double price = Double.parseDouble(System.console().readLine());
        updatableItem.name = name;
        updatableItem.quantity = quantity;
        updatableItem.price = price;
    }

    private void displayTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total value of inventory is: " + totalValue);
    }

    private void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + " ID: " + temp.id + " Quantity: " + temp.quantity + " Price: " + temp.price);
            temp = temp.next;
        }
    }

    private void sortInventory(String order) {
        class ItemComparator implements Comparator<Item> {
            public int compare(Item item1, Item item2) {
                int priceComparison = Double.compare(item1.price, item2.price);
                if (priceComparison != 0) return priceComparison;
                return item1.name.compareTo(item2.name);
            }
        }

        class MergeSort {
            private Item mergeSort(Item head, Comparator<Item> comparator) {
                if (head == null || head.next == null) return head;
                Item middle = getMiddle(head);
                Item nextOfMiddle = middle.next;
                middle.next = null;
                Item left = mergeSort(head, comparator);
                Item right = mergeSort(nextOfMiddle, comparator);
                return sortedMerge(left, right, comparator);
            }

            private Item getMiddle(Item head) {
                if (head == null) return head;
                Item slow = head, fast = head.next;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
                return slow;
            }

            private Item sortedMerge(Item left, Item right, Comparator<Item> comparator) {
                if (left == null) return right;
                if (right == null) return left;
                if (comparator.compare(left, right) <= 0) {
                    left.next = sortedMerge(left.next, right, comparator);
                    return left;
                } else {
                    right.next = sortedMerge(left, right.next, comparator);
                    return right;
                }
            }
        }

        Comparator<Item> comparator = new ItemComparator();
        if (order.equalsIgnoreCase("desc")) {
            comparator = comparator.reversed();
        }
        head = new MergeSort().mergeSort(head, comparator);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Inventory Management System");
        InventoryManagement inventory = new InventoryManagement();
        
        while (true) {
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Update item");
            System.out.println("4. Display total value of inventory");
            System.out.println("5. Display inventory");
            System.out.println("6. Sort inventory");
            System.out.println("7. Exit");
            System.out.println("Enter your choice");
            int choice = Integer.parseInt(System.console().readLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter name, id, quantity and price");
                    String name = System.console().readLine();
                    int id = Integer.parseInt(System.console().readLine());
                    int quantity = Integer.parseInt(System.console().readLine());
                    double price = Double.parseDouble(System.console().readLine());
                    inventory.addAtLast(name, id, quantity, price);
                    break;
                case 2:
                    System.out.println("Enter id of item to remove");
                    int removeId = Integer.parseInt(System.console().readLine());
                    inventory.removeById(removeId);
                    break;
                case 3:
                    System.out.println("Enter id of item to update");
                    int updateId = Integer.parseInt(System.console().readLine());
                    inventory.updateItem(updateId);
                    break;
                case 4:
                    inventory.displayTotalValue();
                    break;
                case 5:
                    inventory.displayInventory();
                    break;
                case 6:
                    System.out.println("Enter order of sorting (asc/desc)");
                    String order = System.console().readLine();
                    inventory.sortInventory(order);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
