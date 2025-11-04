public class Coche extends Vehiculo {

    // Atributo propio del coche, solo los coches tienen este atributo.
    private final double motorLitros; // Ejemplo: 2.0 litros
    private final int velocidadMaxima;
    private final int numPuertas;

    private boolean puertasAbiertas;
    // CONSTRUCTOR (Llamada al Padre, inicializamos el objeto)
    // Un Coche necesita todos los datos de un Véhiculo más su propio dato (numPuertas).
    public Coche(String modelo, int anio, String color, int numPuertas, double motorLitros) {

        // El constructor de la clase hija DEBE llamar primero al constructor del Padre.
        // La palabra clave 'super()' invoca el constructor de Véhiculo.
        super(modelo, anio, color);

        // Inicialización de atributos propios del Coche
        this.numPuertas = numPuertas;
        this.motorLitros = motorLitros;
        // Inicializamos la velocidad máxima del coche
        this.velocidadMaxima = calcularVelocidadMaxima(motorLitros);
        // Inicializamos el estado de las puertas
        this.puertasAbiertas = false;
    }

    // Lógica para calcular la velocidad máxima de un coche basado en el tamaño del motor.
    private int calcularVelocidadMaxima(double litros) {
        if (litros <= 1.0) return 150;
        if (litros <= 1.5) return 180;
        if (litros <= 2.0) return 210;
        if (litros <= 2.5) return 240;
        return 280; // Para motores más grandes (3.0+ litros)
    }

    // Este método calcula el tiempo estimado para alcanzar 100 km/h basado en el tamaño del motor.:
    public double calcularTiempoCienKmH() {

        double litros = this.motorLitros;

        // Asignamos tiempos lógicos: más lento que una moto
        if (litros <= 1.0) return 14.0; // 1.0L tarda 14 segundos
        if (litros <= 1.5) return 11.5;
        if (litros <= 2.0) return 9.0;
        if (litros <= 2.5) return 7.5;
        return 5.0; // Motores de alto rendimiento
    }

    // POLIMORFISMO (Implementación obligatoria)
    // Sobrescritura (@Override): Implementamos el método abstracto de Moto.
    // Esta es la lógica única de cómo acelera un Moto.
    @Override
    public void acelerar(int segundos) {

        //Obtenemos el tiempo que tarda la moto en alcanzar 100 km/h.
        double tiempo100 = this.calcularTiempoCienKmH();

        //Calculamos la Tasa de Aceleración
        double tasaAceleracion = 100.0 / tiempo100;

        //Calculamos la velocidad ganada en los segundos indicados
        int velocidadGanada = (int) (tasaAceleracion * segundos);

        //Aplicamos la ganancia a la velocidad actual
        int velocidadPotencial = this.velocidadActual + velocidadGanada;


        //Nos aseguramos de no exceder la velocidad máxima permitida y que la moto no pase de su límite.
        //Calculamos la velocidad en los segundos indicados
        if (velocidadPotencial > this.velocidadMaxima) {
            // Si la velocidad se pasa del límite, la forzamos al límite MÁXIMO
            this.velocidadActual = this.velocidadMaxima - this.velocidadActual;

            System.out.println("La Moto " + getModelo() + ", año " + getAnio() + ", color " + getColor() + " " + this.motorLitros + ", cc " + " acelero y ahora va a " + this.velocidadActual + " km/h.");

        } else {
            // Aplicamos la ganancia normal
            this.velocidadActual = velocidadPotencial;
            System.out.println("La Moto " + getModelo() + ", año " + getAnio() + ", color " + getColor() + " " + this.motorLitros + ", cc " + " acelero y ahora va a " + this.velocidadActual + " km/h.");
        }


    }

    @Override
    public void apagar(){
        super.apagar();
        System.out.println("El coche se ha detenido completamente.");
    }

    // --- MÉTODOS PROPIOS Y GETTERS/SETTERS ---

    // Getter para el estado de las puertas
    // Comportamiento: Abrir puerta (cambia el estado)
    public void abrirPuerta() {
        if (!this.puertasAbiertas && this.velocidadActual == 0) { // Solo si está detenido
            this.puertasAbiertas = true;
            System.out.println("El coche " + getModelo() + " abrió sus " + this.numPuertas + " puertas.");
        } else if (this.velocidadActual > 0) {
            System.out.println(" Peligro: El coche está en movimiento (" + this.velocidadActual + " km/h). No se puede abrir la puerta.");
        } else {
            System.out.println("Las puertas del coche " + getModelo() + " ya están abiertas.");
        }
    }

    // Comportamiento: Cerrar puerta (cambia el estado)
    public void cerrarPuerta() {
        if (this.puertasAbiertas) {
            this.puertasAbiertas = false;
            System.out.println("El coche " + getModelo() + " cerró sus " + numPuertas +" puertas.");
        } else {
            System.out.println("Las puertas del coche " + getModelo() + " ya están cerradas.");
        }
    }

    // LÓGICA CONDICIONAL: Prender clima
    public void prendeClima(){
        // Restricción: Solo se prende si el coche está encendido Y las puertas están cerradas
        if (super.isEncendido() && !this.puertasAbiertas) {
            System.out.println("El coche " + getModelo() + " prendió el clima con éxito.");
        } else if (!super.isEncendido()) {
            System.out.println("No se puede prender el clima. El coche debe estar encendido.");
        } else { // Puertas abiertas
            System.out.println("No se puede prender el clima. Cierre las puertas para ahorrar energía.");
        }
    }

    // Getter simple
    public void getNumPuertas() {
    }
}
