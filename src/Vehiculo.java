public abstract class Vehiculo {
    //abstract se utiliza para decir que no se puede crear objetos directamente de esta clase, solo sirve para heredar

    // ----------Encapsulamiento---------------//

    // Atributos privados
    // Private: Solo accesibles DENTRO de esta clase. Necesitan Getters/Setters.
    private final String modelo;
    private final int anio;
    private String color;
    // Protected: Accesible por esta clase y por CUALQUIER CLASE HIJA (Coche, Motocicleta).
    protected int velocidadActual = 0;
    protected boolean encendido = false;


    // Constructor (inicialización de estados)
    // Se usa para garantizar que los atributos se inicialicen al crear el objeto.
    public Vehiculo (String modelo, int anio, String color){
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
    }

    // Métodos
    public void encender(){
        System.out.println(this.modelo + ", Año " + this.anio + ", Color " + this.color + " encendido.");
    }

    public void apagar(){
        this.velocidadActual = 0;
        System.out.println(this.modelo + ", Año " + this.anio + ", Color " + this.color + " se ha apagado.");
    }

    // Polimorfismo: Obligatorio para las clases hijas.
    // Cada subclase (Coche, Motocicleta) definirá su propia lógica de aceleración.
    //public abstract void acelerar(int incremento);

    // El método ahora recibe el tiempo de aceleración en segundos
    public abstract void acelerar(int segundos);
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
        return this.encendido=true;
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

