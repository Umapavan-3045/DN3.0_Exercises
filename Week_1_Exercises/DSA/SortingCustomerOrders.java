import java.util.ArrayList;
import java.util.List;

class Order {
    private int orderId;
    private String customerName;
    private int totalPrice;

    Order(int orderId, String customerName, int totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}

public class SortingCustomerOrders {
    private static List<Order> orderList = new ArrayList<>();

    public static void addOrder(Order order) {
        orderList.add(order);
    }

    public static void bubbleSort() {
        int n = orderList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orderList.get(j).getTotalPrice() > orderList.get(j + 1).getTotalPrice()) {
                    Order temp = orderList.get(j);
                    orderList.set(j, orderList.get(j + 1));
                    orderList.set(j + 1, temp);
                }
            }
        }
    }

    public static void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private static int partition(int low, int high) {
        Order pivot = orderList.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orderList.get(j).getTotalPrice() <= pivot.getTotalPrice()) {
                i++;

                Order temp = orderList.get(i);
                orderList.set(i, orderList.get(j));
                orderList.set(j, temp);
            }
        }
        Order temp = orderList.get(i + 1);
        orderList.set(i + 1, orderList.get(high));
        orderList.set(high, temp);

        return i + 1;
    }

    public static void main(String[] args) {
        Order order1 = new Order(1, "Uma", 500);
        Order order2 = new Order(3, "Pavan", 300);
        Order order3 = new Order(2, "Deepak", 400);

        addOrder(order1);
        addOrder(order2);
        addOrder(order3);

        System.out.println("Before Sorting:");
        for (Order order : orderList) {
            System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + order.getTotalPrice());
        }

        bubbleSort();
        System.out.println("\nAfter Bubble Sort:");
        for (Order order : orderList) {
            System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + order.getTotalPrice());
        }

        quickSort(0, orderList.size() - 1);
        System.out.println("\nAfter Quick Sort:");
        for (Order order : orderList) {
            System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + order.getTotalPrice());
        }
    }
}