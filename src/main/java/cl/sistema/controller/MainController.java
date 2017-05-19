package cl.sistema.controller;

import cl.sistema.model.Cliente;
import cl.sistema.model.Consulta;
import cl.sistema.model.Mascota;
import cl.sistema.service.ClienteService;
import cl.sistema.service.ConsultaService;
import cl.sistema.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rodo on 07-05-17.
 */
@Controller
public class MainController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private ConsultaService consultaService;


    @GetMapping("/")
    public String home (HttpServletRequest request){
        request.setAttribute("mode","MODE_HOME");
        return "index";
    }

   // Controll cliente

    @GetMapping("/lista-clientes")
    public String listaClientes (HttpServletRequest request){
        request.setAttribute("listaCliente", clienteService.findAll());
        request.setAttribute("mode","MODE_LISTA");
        return "index";
    }

    @GetMapping("/nuevo-clientes")
    public String nuevoCliente (HttpServletRequest request){
        request.setAttribute("mode","MODE_NUEVO");
        return "index";
    }

    @PostMapping("/salvar-clientes")
    public String salvarCliente (@ModelAttribute Cliente cliente, HttpServletRequest request){
        clienteService.save(cliente);
        request.setAttribute("listaCliente", clienteService.findAll());
        request.setAttribute("mode","MODE_LISTA");
        return "index";
    }


    @GetMapping("/actualizar-cliente")
    public String actualizarCliente (@RequestParam int rut, HttpServletRequest request){
        request.setAttribute("cliente", clienteService.buscarCliente(rut));
        request.setAttribute("mode","MODE_ACTUALIZAR");
        return "index";
    }

    @GetMapping("/borrar-cliente")
    public String borrarCliente (@RequestParam int rut, HttpServletRequest request){
        clienteService.delete(rut);
        request.setAttribute("listaCliente", clienteService.findAll());
        request.setAttribute("mode","MODE_LISTA");
        return "index";
    }

   // control Mascota

    @GetMapping("/nueva-mascota")
    public String nuevaMascota (@RequestParam int rut,HttpServletRequest request){
        request.setAttribute("rutCliente",rut);
        request.setAttribute("mode","MODE_AGREGARMAS");
        return "index";
    }


    @PostMapping("/salvar-mascota")
    public String salvarMascota (@ModelAttribute Mascota mascota,@RequestParam int rut, HttpServletRequest request){
        mascota.setRut(rut);
        mascotaService.save(mascota);
        request.setAttribute("listaMascota", mascotaService.findAll());
        request.setAttribute("mode","MODE_LISTAMAS");
        return "index";
    }

    @GetMapping("/lista-mascotas")
    public String listaMascotas (HttpServletRequest request){
        request.setAttribute("listaMascota", mascotaService.findAll());
        request.setAttribute("mode","MODE_LISTAMAS");
        return "index";
    }

    @GetMapping("/borrar-mascota")
    public String borrarMascota (@RequestParam int id, HttpServletRequest request){
        mascotaService.delete(id);
        request.setAttribute("listaMascota", mascotaService.findAll());
        request.setAttribute("mode","MODE_LISTAMAS");
        return "index";
    }

    // Control Consulta

    @GetMapping("/nueva-consulta")
    public String nuevaConsulta (@RequestParam int rut,HttpServletRequest request){
        request.setAttribute("rut", rut);
        request.setAttribute("mode","MODE_AGREGARCONS");
        return "index";
    }

    @PostMapping("/salvar-consulta")
    public String salvarConsulta (@ModelAttribute Consulta consulta, @RequestParam (value = "rut")int rut, HttpServletRequest request){
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
