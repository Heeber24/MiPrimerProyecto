//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.

//TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.

import java.util.ArrayList;
import java.util.List;



// public class Main es la definición de la clase principal del programa.
public class Main {

    //public es el modificador de acceso que permite ejecutar el método desde cualquier lugar.
    //static indica que el método pertenece a la clase Main y no a una instancia específica.
    //void significa que el método no devuelve ningún valor.
    // main es el nombre del método principal que se ejecuta al iniciar el programa.
    // String[] args es un parámetro que permite recibir argumentos desde la línea de comandos al ejecutar el programa.
    public static void main(String[] args) {

        // CREACIÓN DE OBJETOS: Instancia de las clases hijas

        // Coche usa el constructor de Coche
        Coche miCoche = new Coche("Tesla Model 3", 2024, "Rojo", 4, 2.0);
        Coche otroCoche = new Coche("Ford Fiesta", 2018, "Blanco", 4, 1.5);



        // Motocicleta usa el constructor de Motocicleta
        Motocicleta miMoto = new Motocicleta("Yamaha YZF-R6", 2023, "Azul", 100);
        Motocicleta otraMoto = new Motocicleta("Honda CBR500R", 2020, "Negra", 500);



        System.out.println("\nPrueba de Clases Individuales \n");

        // Prueba de Encapsulamiento y Métodos propios
        System.out.println("Información del coche: " + miCoche.getModelo() + " " + miCoche.getAnio() + " " + miCoche.getColor()); // Uso del Getter (Encapsulamiento)
        System.out.println("Modelo de la moto: " + miMoto.getModelo() + " " + miMoto.getAnio() + " " + miMoto.getColor()); // Uso del Getter (Encapsulamiento)
        miCoche.setColor("Negro Mate"); // Uso del Setter
        miMoto.setColor("Verde"); // Uso del Setter
        miCoche.abrirPuerta();
        miMoto.hacerCaballito(); // Método único de Motocicleta
        miCoche.cerrarPuerta();
        miCoche.isEncendido();
        miCoche.prendeClima();
        miCoche.getNumPuertas();



        System.out.println("------------------------------------");

        // POLIMORFISMO: Crear una lista de tipo Padre (Véhiculo)
        // La lista puede contener cualquier clase que herede de Véhiculo.
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(miCoche); // Un Coche es un Vehiculo
        listaVehiculos.add(otroCoche);
        listaVehiculos.add(miMoto);  // Una Motocicleta es un Vehiculo
        listaVehiculos.add(otraMoto);

        System.out.println("Demostración de Polimorfismo \n");

        // ITERACIÓN: Ejecutando el mismo método en diferentes objetos
        for (Vehiculo vehiculo : listaVehiculos) {

            // Java llama automáticamente al método 'encender()' definido en Véhiculo (Herencia)
            vehiculo.encender();
            System.out.println("Velocidad inicial: " + vehiculo.getVelocidadActual() + " km/h");


            // Java llama automáticamente al método 'acelerar()' específico de cada objeto:
            // Si es Coche o Moto, usa la lógica de aceleración de Coche.
            vehiculo.acelerar(10);



            System.out.println("------------------------------------");
        }

        for (Vehiculo vehiculo : listaVehiculos) {
            vehiculo.apagar();
            System.out.println("------------------------------------");
        }

        System.out.println("Prueba adicional de Polimorfismo para objetos en especifico\n");
        // PRUEBA ADICIONAL: Ejecución de la lógica de negocio
        // Aquí probamos la lógica específica de aceleración de cada clase.
        // Aunque ambos son Vehículos, cada uno tiene su propia implementación de acelerar().


        miCoche.acelerar(5); // Muestra la aceleración del coche (con su propia lógica)
        // Aquí el resultado seria 55 km/h si no supera el límite.

        miMoto.acelerar(20); // Muestra la aceleración de la moto (con el factor de cilindrada)
        // Aquí el resultado seria 100 km/h si no supera el límite, sino seria 80 km/h. por ser el máximo.

        otroCoche.acelerar(15); // Muestra la aceleración de la moto (con el factor de cilindrada)
        // Aquí el resultado seria 130 km/h si no supera el límite.

        otraMoto.acelerar(8); // Muestra la aceleración del coche (con su propia lógica)
        // Aquí el resultado seria 115 km/h si no supera el límite.

    }
}
