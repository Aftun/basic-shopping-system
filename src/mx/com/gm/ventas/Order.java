package mx.com.gm.ventas;

/**
 *
 * @author Ignacio
 */
public class Order {
    // For best practices all the constants must be declared before the rest of properties
    private final static int MAX_PRODUCTS_PER_ORDER = 10;
    private final int orderId;
    /*
        Tanto los arrays como los ArrayList pueden establecerse como final, ya que como máximo podemos vaciar la estructura,
        pero no deja de existir la referencia a la misma.
     */
    private final Product[] products;
    private static int ordersCounter;
    private int currentProducts;

    public Order() {
        this.orderId = ++Order.ordersCounter;
        // Al igual que con los ArrayList, primero se declara el array como atributo y luego se instancia en el constructor.
        // Para evitar el uso de 'numeros magicos', usamos constantes para definir la extension del array
        this.products = new Product[Order.MAX_PRODUCTS_PER_ORDER];
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void addProduct(Product producto) {
        // Primera validacion - Chequear si estoy recibiendo una instacia o null
        if (producto != null) {
            // Segunda validacion - ¿hay espacio suficiente para almacenar el Producto?
            if (this.currentProducts < Order.MAX_PRODUCTS_PER_ORDER) {
                // Agregando el producto post-validacion en la posicion de memoria correspondiente, usando el atributo como indice
                this.products[currentProducts++] = producto;
            } else {
                // Se podrian lanzar una excepciones en lugar de imprimir un mensajes; ampliaremos más adelante
                System.out.println("El producto no ha sido agregado, ya que se alcanzo el limite de productos de la Orden");
            }
        } else {
            System.out.println("Debe existir un producto para ser agregado a la lista");
        }
    }

    // Podemos iterar los arrays con for-loops o con forEach, pero este último es menos eficiente y portable.
    public double calculateTotal() {
        double total = 0;

        /*
         No iteramos sobre el length del array, ya que sólo nos interesa recorrer los elementos que se han agregado; no
         todos los elementos que pueden ser almacenados.
         */
        for (int i = 0; i < this.currentProducts; i++) {
            // Podría colocarse un if statement y preguntar si el elemento es null y no sumarlo, en caso de usar el length.
            total += this.products[i].getPrice();
        }

        return total;
    }

    public void showOrder() {
        System.out.println("**************************");
        System.out.println("Operation ID: " + this.orderId);
        System.out.println("Total order amount: $" + this.calculateTotal());
        System.out.println("Products added to the order: ");
        for (int i = 0; i < this.currentProducts; i++) {
            System.out.println("- " + this.products[i]);
        }
        System.out.println("**************************");
    }

}
