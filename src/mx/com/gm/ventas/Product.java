package mx.com.gm.ventas;

/**
 *
 * @author Ignacio
 */
public class Product {

    private final int productId;
    private String name;
    private double price;
    private static int productIdCounter;

    private Product() {
        // Creacion del ID del producto (generamos un atributo estatico que incrementa su valor con cada nuevo objeto)
        this.productId = ++Product.productIdCounter;
    }

    public Product(String name, double price) {
        this();
        setName(name);
        setPrice(price);
    }

    public int getProductId() {
        return this.productId;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("productId=").append(productId);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    

}
