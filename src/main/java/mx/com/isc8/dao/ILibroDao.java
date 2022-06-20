package mx.com.isc8.dao;

import mx.com.isc8.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibroDao extends JpaRepository<Libro, Long> {
    
}