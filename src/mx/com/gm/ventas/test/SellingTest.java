package mx.com.gm.ventas.test;

import mx.com.gm.ventas.*;

/**
 *
 * @author Ignacio
 */
public class SellingTest {

    public static void main(String[] args) {
        // Siempre hay que empezar por aquellas clases que no tienen dependencias
        // Se pueden ingresar tantos valores double como int, a razón del polimorfismo por coerción

        // Creating the products in the system
        Product p1 = new Product("Shirt", 35.99);
        Product p2 = new Product("Jeans", 24.99);
        Product p3 = new Product("Black Sneakers", 16.50);

        // Creating a new order to place the products
        Order o1 = new Order();

        // Showing the empty order (no products have been added yet)
        o1.showOrder();

        // Adding products to the sample order
        o1.addProduct(p1);
        o1.addProduct(p2);
        
        // Showing the order again (this time with the products loaded)
        o1.showOrder();
        
        // Updating order
        o1.addProduct(p3);
        o1.showOrder();
    }
}
