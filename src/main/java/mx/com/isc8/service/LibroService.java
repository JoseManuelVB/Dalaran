package mx.com.isc8.service;

import java.util.List;
import mx.com.isc8.domain.Libro;

/** @author 90836 */

public interface LibroService {
    
    public List<Libro> listarLibro();
    
    public void guardar(Libro libro);
    
    public void eliminar(Libro libro);
    
    public Libro encontrarLibro(Libro libro);
}
