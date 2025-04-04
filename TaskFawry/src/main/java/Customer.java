import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    String name;
    double balance;
    Map<Product, Integer> cart;
    public Customer(String name, double balance){
        this.name=name;
        this.balance=balance;
        this.cart=new HashMap<>();
    }
    public void addproduct(Product product, int quantity){
        if(quantity<=0){
            System.out.println("Quantity must be greater than 0");
            return;
        }
        if(product.getQuantity()<=quantity){
            System.out.println("Not enough stock for "+product.getName());
            return;
        }
        if(product.mayExpire()){
            if(product.expirationDate.isAfter(LocalDate.now())){
                System.out.println("Can't add "+product.getName()+", it is expired");
                return;
            }
        }
        cart.put(product, quantity);
        System.out.println(quantity+ " of product "+product.getName()+" added successfully");
    }
    public void checkout(Customer customer, Map<Product, Integer> cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        List<shippable> itemsToShip = new ArrayList<>();
        double subtotal = 0;
        double shippingfees = 0;
        Product product;
        for (Map.Entry<Product, Integer> i : cart.entrySet()) {
            product = i.getKey();
            int quantity = i.getValue();
            subtotal += quantity * product.getPrice();
            if (product instanceof ShippingProduct) {
                shippingfees += (((ShippingProduct) product).getWeight()/1000)*100;
                shippable item = (shippable) product;
                itemsToShip.add(item);
            }
        }
        // assume shippingfees =15;
        double totalamount = subtotal + shippingfees;
        if (customer.balance < totalamount) {
            System.out.println("Customer balance is insufficient");
            return;
        }
        customer.balance -= totalamount;
        for (Map.Entry<Product, Integer> i : cart.entrySet()) {
            i.getKey().setQuantity(i.getKey().getQuantity() - i.getValue());
        }
        System.out.println("shipment notice: ");
        double totalweight=0;
        for (Map.Entry<Product, Integer> i : cart.entrySet()) {
            if (i.getKey() instanceof ShippingProduct) {
                totalweight+=((ShippingProduct) i.getKey()).getWeight()*i.getValue();
                System.out.println(i.getValue()+"x "+i.getKey().getName()+"      "+((ShippingProduct) i.getKey()).getWeight()*i.getValue()+" g");
            }
        }
        System.out.println("Total package weight "+ totalweight/1000+" kg");
        System.out.println("-----------------------------------------------");
        System.out.println("Checkout receipt: ");
        for (Map.Entry<Product, Integer> i : cart.entrySet()) {
            System.out.println(i.getValue() +"x "+i.getKey().getName()+"       " +i.getKey().getPrice()*i.getValue());
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Shipping: $" + shippingfees);
        System.out.println("Amount: $" + totalamount);
        System.out.println("-----------------------------------------------");
        if(!itemsToShip.isEmpty()){
            ShippingService shippingService=new ShippingService();
            shippingService.shipItems(itemsToShip);
        }
        cart.clear();
    }
}
