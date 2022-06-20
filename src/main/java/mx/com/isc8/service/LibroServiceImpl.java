package mx.com.isc8.service;

import java.util.List;
import mx.com.isc8.dao.ILibroDao;
import mx.com.isc8.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** @author 90836 */
@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private ILibroDao libroDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> listarLibro() {
        return (List<Libro>) libroDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Libro libro) {
        libroDao.save(libro);
    }

    @Override
    @Transactional
    public void eliminar(Libro libro) {
        libroDao.delete(libro);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro encontrarLibro(Libro libro) {
        return libroDao.findById(libro.getIdLibro()).orElse(null);
    }
}