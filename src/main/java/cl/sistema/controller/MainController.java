package cl.sistema.controller;

import cl.sistema.model.Cliente;
import cl.sistema.model.Consulta;
import cl.sistema.model.Mascota;
import cl.sistema.service.ClienteService;
import cl.sistema.service.ConsultaService;
import cl.sistema.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rodo on 07-05-17.
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String home (HttpServletRequest request){
        request.setAttribute("mode","MODE_HOME");
        return "index";
    }
}
