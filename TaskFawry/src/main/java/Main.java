import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new ShippingProduct("Cheese", 5.0, 10, true, LocalDate.of(2025, 4, 4),5);
        ShippingProduct tv = new ShippingProduct("TV", 300.0, 5,false, null,10);
        Product mobileCard = new Product("Mobile Scratch Card", 2.0, 50,false,null);

        Customer customer = new Customer("John Doe", 500);
        customer.addproduct(cheese, 2);
        customer.addproduct(tv, 1);
        customer.addproduct(mobileCard,1);
        customer.checkout(customer, customer.cart);
    }
}
