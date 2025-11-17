package models;

public abstract class Vehiculo {
    //abstract se utiliza para decir que no se puede crear objetos directamente de esta clase, solo sirve para heredar

    // ----------Encapsulamiento---------------//

    // Atributos privados
    // Private: Solo accesibles DENTRO de esta clase. Necesitan Getters/Setters.
    private final String modelo;
    private final int anio;
    private String color;
    // Protected: Accesible por esta clase y por CUALQUIER CLASE HIJA (Models. Coche, Models.Motocicleta).
    protected int velocidadActual = 0;
    protected boolean encendido = false;
    private final double precioMagna = 24;
    private final double precioPremium = 26;



    // Constructor (inicialización de estados) recibe parámetros para inicializar los atributos.
    // Se usa para garantizar que los atributos se inicialicen al crear el objeto.

    public Vehiculo(String modelo, int anio, String color) {
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
    }

    // Métodos
    public void encender() {
        System.out.println(this.modelo + ", Año " + this.anio + ", Color " + this.color + " encendido.");
    }

    public void apagar() {
        this.velocidadActual = 0;
        this.encendido = false;
        System.out.println(this.modelo + ", Año " + this.anio + ", Color " + this.color + " se ha apagado.");
    }


    // Polimorfismo: Obligatorio para las clases hijas.
    // Cada subclase (Models. Coche, Models. Motocicleta) definirá su propia lógica de aceleración.
    // El método ahora recibe el tiempo de aceleración en segundos
    // Se pone abstracto para que las subclases lo implementen.
    public abstract void acelerar(int segundos);


    // Sobrecarga:
    public void echarGasolina(double litros, boolean esPremium) {

        // Restricción
        if (this.encendido) {
            System.out.println("¡PELIGRO! " + this.modelo + " está encendido. Apágalo antes de echar gasolina.");
            return; // Aquí se mata la función si no cumple la regla. No sigue leyendo abajo.
        }

        // Si es Premium es true, usa precioPremium, si no, precioMagna
        double precio = esPremium ? precioPremium : precioMagna;
        String tipo = esPremium ? "PREMIUM" : "MAGNA";

        // Calculamos el costo total por litros cargados
        double totalPagar = litros * precio;
        System.out.println(this.modelo + " está cargando " + litros + " litros." + " Tipo " + tipo + ". Precio $" + precio + ". Total a pagar. $" + totalPagar);
    }

    public void echarGasolina(int pesos, boolean esPremium) {

        if (this.encendido) {
            System.out.println("¡PELIGRO! " + this.modelo + " está encendido. Apágalo antes de echar gasolina.");
            return; // Aquí se mata la función si no cumple la regla. No sigue leyendo abajo.
        }

        double precio = esPremium ? precioPremium : precioMagna;
        String tipo = esPremium ? "PREMIUM" : "MAGNA";

        // Calculamos cuántos litros tocan por el dinero cargado
        double litros = pesos / precio;

        System.out.println(this.modelo + " pidió " + pesos + " pesos." + " Tipo " + tipo + ". Precio $" + precio + ". Total de litros " + String.format("%.2f", litros) + " L.");
    }



    // GETTERS Y SETTERS (acceso Controlado)
    // Getters: Permiten LEER los atributos privados.
    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public String getColor() {
        return color;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    // Getter público para saber el estado (convención 'is' para booleanos)
    public boolean isEncendido() {
        return this.encendido = true;
    }

    // Setter: Permite MODIFICAR un atributo privado (con lógica de validación).
    public void setColor(String nuevoColor) {
        // Validación de ejemplo (Encapsulamiento en acción)
        if (nuevoColor != null && !nuevoColor.trim().isEmpty()) {
            this.color = nuevoColor;
            System.out.println("Color de " + this.modelo + " cambiado a " + nuevoColor);
        } else {
            System.out.println("ERROR: El color no es válido.");
        }
    }

}

