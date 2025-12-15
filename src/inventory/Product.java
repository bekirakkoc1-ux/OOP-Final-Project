package inventory;

// Interface'i implemente ettim (Storable)
public class Product implements Storable {
    
    // Encapsulation için değişkenleri private yaptım
    private String productId;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        setPrice(price); // Setter metodunu kullanarak kontrolü sağladım
        this.quantity = quantity;
    }

    // Price için setter (Negatif değer kontrolü)
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    
    public String getProductId() {
        return productId;
    }

    // Interface metodlarını override ettim
    @Override
    public void addStock(int amount) {
        if(amount > 0) {
            this.quantity += amount;
        }
    }

    @Override
    public void removeStock(int amount) {
        // Stok yeterli mi diye kontrol ediyorum - yoksa müşteri kızar 
        if(amount > 0 && this.quantity >= amount) {
            this.quantity -= amount;
        } else {
            System.out.println("Invalid operation: Not enough stock.");
        }
    }

    @Override
    public int getStockLevel() {
        return this.quantity;
    }
    
    @Override
    public String toString() {
        return name + " (" + productId + ") - Price: " + price + " - Stock: " + quantity;
    }
}