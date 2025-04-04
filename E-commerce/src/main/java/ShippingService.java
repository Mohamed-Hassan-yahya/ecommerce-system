import java.util.List;

public class ShippingService {
    public void shipItems(List<shippable> items) {
        System.out.println("Shipping the following items:");
        for (shippable item : items) {
            System.out.println(item.gettName() + " (" + item.getWeight()/1000 + "kg)");
        }
    }
}
