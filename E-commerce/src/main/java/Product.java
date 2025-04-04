import java.time.LocalDate;

public class Product {
    String name;
    private double price;
    private int quantity;
    private boolean mayexpire;
    LocalDate expirationDate;

    public Product(String name, double price, int quantity , boolean mayexpire, LocalDate expirationDate){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.mayexpire=mayexpire;
        this.expirationDate=expirationDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public boolean mayExpire() {
        return mayexpire;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpire(boolean expire) {
        this.mayexpire = expire;
    }


}
