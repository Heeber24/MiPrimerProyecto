package services;

// ¡OJO AQUÍ! Debe decir 'interface', NO 'class'
public interface Servicio {

    // Métodos del contrato (en una interfaz, no llevan cuerpo {})

    // 1. Método para hacer el servicio
    void realizarMantenimiento();

    // 2. Método para avisar si le toca servicio
    boolean hacerRevision();
}