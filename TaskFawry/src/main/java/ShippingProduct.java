import java.time.LocalDate;
interface shippable{
    double getWeight();
    String gettName();
}

public class ShippingProduct extends Product implements shippable {
    private double weight;

    public ShippingProduct(String name, double price, int quantity, boolean mayexpire, LocalDate expirationDate , double weight) {
        super(name, price, quantity, mayexpire, expirationDate);
        this.weight=weight;
    }

    public double getWeight() {
        return weight;
    }

    public String gettName(){
        return name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
