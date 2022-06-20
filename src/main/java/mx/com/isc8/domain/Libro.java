package mx.com.isc8.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "libro")
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLibro;

    //private byte[] imagen;
    @NotEmpty
    private String nombre;

    @NotEmpty
    private String autor;

    private int year;

    @NotEmpty
    private String ciudad;

    @NotEmpty
    private String editorial;

    private int volumen;

    private int paginas;

    @NotEmpty
    private String Genero;
}
