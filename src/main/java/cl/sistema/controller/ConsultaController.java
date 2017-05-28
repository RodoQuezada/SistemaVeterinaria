package cl.sistema.controller;

import cl.sistema.model.Consulta;
import cl.sistema.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rodo on 21-05-17.
 */
@Controller
@RequestMapping("/consulta")
public class ConsultaController {


    @Autowired
    private ConsultaService consultaService;

    // Control Consulta

    @GetMapping("/nueva-consulta")
    public String nuevaConsulta (@RequestParam int rut,@RequestParam int id, HttpServletRequest request){
        request.setAttribute("rut", rut);
        request.setAttribute("id", id);
        request.setAttribute("mode","MODE_AGREGARCONS");
        return "index";
    }

    @PostMapping("/salvar-consulta")
    public String salvarConsulta (@ModelAttribute Consulta consulta, @RequestParam int rut, HttpServletRequest request){
        consulta.setRut_cliente(rut);
        consultaService.save(consulta);
        request.setAttribute("rut", rut);
        request.setAttribute("listaConsultas", consultaService.findAll());
        request.setAttribute("mode","MODE_LISTACONS");
        return "index";
    }

    @GetMapping("/lista-consulta")
    public String listaConsultas (HttpServletRequest request){
        request.setAttribute("listaConsultas", consultaService.findAll());
        request.setAttribute("mode","MODE_LISTACONS");
        return "index";
    }



}
