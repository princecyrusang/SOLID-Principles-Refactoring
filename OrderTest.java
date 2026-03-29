public class OrderTest {

    public static void main(String[] args) {

        OrderService orderService = new BasicOrderService();
        InvoiceService invoiceService = new FileInvoiceService();
        NotificationService notificationService = new EmailNotificationService();

        OrderProcessor processor = new OrderProcessor(
                orderService,
                invoiceService,
                notificationService
        );

        processor.processOrder(
                "John Doe",
                "123 Main St",
                10.0,
                2,
                "order_123.pdf",
                "johndoe@example.com"
        );
    }
}