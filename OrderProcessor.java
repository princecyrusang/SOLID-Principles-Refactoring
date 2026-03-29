public class OrderProcessor {

    private final OrderService orderService;
    private final InvoiceService invoiceService;
    private final NotificationService notificationService;

    public OrderProcessor(OrderService orderService,
                          InvoiceService invoiceService,
                          NotificationService notificationService) {
        this.orderService = orderService;
        this.invoiceService = invoiceService;
        this.notificationService = notificationService;
    }

    public void processOrder(String customerName, String address,
                             double price, int quantity,
                             String invoiceFile, String email) {

        double total = orderService.calculateTotal(price, quantity);
        System.out.println("Total: $" + total);

        orderService.placeOrder(customerName, address);
        invoiceService.generateInvoice(invoiceFile);
        notificationService.sendNotification("Order placed successfully!", email);
    }
}