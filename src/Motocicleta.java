public class Motocicleta extends Vehiculo {

    // Atributo propio de la moto, solo las motos tienen este atributo.
    private final int cilindradaCC;
    private final int velocidadMaxima;

    // CONSTRUCTOR (Llamada al Padre, inicializamos el objeto)
    // Una Moto necesita todos los datos de un Véhiculo MÁS su propio dato (cilindrada).
    public Motocicleta(String modelo, int anio, String color, int cilindradaCC) {

        // El constructor de la clase hija DEBE llamar primero al constructor del Padre.
        // La palabra clave 'super()' invoca el constructor de Véhiculo.
        super(modelo, anio, color);

        // Inicialización de atributos propios de la Moto
        this.cilindradaCC = cilindradaCC;

        // Inicializamos la velocidad máxima de la moto
        this.velocidadMaxima = calcularVelocidadMaxima(cilindradaCC);
    }

    // Método privado para calcular el límite (lógica de negocio)
    private int calcularVelocidadMaxima(int cc) {
        if (cc <= 100) return 80;
        if (cc <= 250) return 140;
        if (cc <= 500) return 180;
        if (cc <= 1000) return 250;
        return 300; // Para cilindradas mayores a 1000cc
    }
    // Este método calcula el tiempo estimado para alcanzar 100 km/h basado en la cilindrada.:

    public double calcularTiempoCienKmH() {

        int cilindrada = this.cilindradaCC;
        double tiempoBase = 15.0; // Base: 100cc = 15.0 segundos

        if (cilindrada <= 100) {
            return tiempoBase; // Si es 100cc o menos, tarda 15s.
        }
        // Lógica de reducción:
        // Por cada 100cc por encima de la base, reducimos el tiempo.
        // Usamos Math.log para una reducción que se desacelera (más realista).
        // Math.log es el logaritmo natural que da una reducción progresiva.
        double factorReduccion = Math.log(cilindrada / 100.0) * 5.0;
        // Al ponerle 5.0 se dice que reduce 5 segundos por cada incremento logarítmico.
        // Esto significa que a medida que la cilindrada aumenta, el beneficio en tiempo disminuye.
        double tiempoCalculado = tiempoBase - factorReduccion;
        // El resultado de una cilindrada de 100cc seria 15 - log(1)*5 = 15 - 0 = 15 segundos
        // El resultado de una cilindrada de 200cc seria 15 - log(2)*5 = 15 - 3.465 = 11.535 segundos
        // El resultado de una cilindrada de 500cc seria 15 - log(5)*5 = 15 - 8.047 = 6.953 segundos
        // El resultado de una cilindrada de 1000cc seria 15 - log(10)*5 = 15 - 11.512 = 3.488 segundos




        // Garantizamos que el tiempo no sea negativo o demasiado bajo
        // Mínimo 2.5 segundos para motos muy potentes.
        return Math.max(2.5, tiempoCalculado);
    }
    // POLIMORFISMO (Implementación obligatoria)
    // Sobrescritura (@Override): Implementamos el método abstracto de Moto.
    // Esta es la lógica única de cómo acelera un Moto.
    @Override
    public void acelerar(int segundos) {

        //Obtenemos el tiempo que tarda la moto en alcanzar 100 km/h.
        double tiempo100 = this.calcularTiempoCienKmH();

        //Calculamos la Tasa de Aceleración (por ejemplo: 100 km/h en 5 segundos -> 20 km/h por segundo)
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
            System.out.println("La Moto " + getModelo() + ", año " + getAnio() + ", color " + getColor() + " " + this.cilindradaCC + " cc " + " acelero y ahora va a " + this.velocidadActual + " km/h.");

        } else {
            // Aplicamos la ganancia normal
            this.velocidadActual = velocidadPotencial;
            System.out.println("La Moto " + getModelo() + ", año " + getAnio() + ", color " + getColor() + " " + this.cilindradaCC + " cc " + " acelero y ahora va a " + this.velocidadActual + " km/h.");
        }


    }
    @Override
    public void apagar(){
        super.apagar();
        System.out.println("La motocicleta se ha detenido completamente.");
    }


    // Métodos propios de la Motocicleta

    // Getter para el atributo propio del Moto
    public void hacerCaballito() {
        System.out.println("La moto " + getModelo() + " esta haciendo un caballito");
    }

}
