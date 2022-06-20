package mx.com.isc8.web;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import mx.com.isc8.domain.Libro;
import mx.com.isc8.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
/** @author 90836 */
@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private LibroService libroService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        
        Iterable libros = libroService.listarLibro();
        
        
        log.info("Ejecutando el controlador Rest");
        log.info("Usuario que hizo login"+user);
        model.addAttribute ("libros", libros);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar (Libro libro){ 
        return "modificar"; 
    }
    
    @PostMapping("/guardar")
    public String Guardar(@Valid Libro libro, Errors errores) {
        if (errores.hasErrors()){
            return "modificar";
        }
        libroService.guardar(libro);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idLibro}")
    public String Editar(Libro libro, Model model) {
        libro = libroService.encontrarLibro(libro);
        model.addAttribute("libro", libro);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(Libro libro) {
        libroService.eliminar(libro);
        return "redirect:/";
    }
}