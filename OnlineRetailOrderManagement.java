import java.util.Date;

enum OrderStatus {
    PLACED, SHIPPED, DELIVERED
}

class Order {
    private String orderId;
    private Date orderDate;
    private OrderStatus status;

    public Order(String orderId, Date orderDate, OrderStatus status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }
}

class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, Date orderDate, String trackingNumber) {
        super(orderId, orderDate, OrderStatus.SHIPPED);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private Date deliveryDate;

    public DeliveredOrder(String orderId, Date orderDate, String trackingNumber, Date deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public OrderStatus getOrderStatus() {
        return OrderStatus.DELIVERED;
    }
}

public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        Order order = new Order("ORD123", new Date(), OrderStatus.PLACED);
        System.out.println(order.getOrderStatus());

        ShippedOrder shippedOrder = new ShippedOrder("ORD124", new Date(), "TRACK123");
        System.out.println(shippedOrder.getOrderStatus());

        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD125", new Date(), "TRACK124", new Date());
        System.out.println(deliveredOrder.getOrderStatus());
    }
}
