package cl.sistema.controller;

import cl.sistema.model.Mascota;
import cl.sistema.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rodo on 21-05-17.
 */
@Controller
@RequestMapping("/mascota")
public class MascotaController {


    @Autowired
    private MascotaService mascotaService;

    // control Mascota

    @GetMapping("/nueva-mascota")
    public String nuevaMascota (@RequestParam int rut, HttpServletRequest request){
        request.setAttribute("rutCliente",rut);
        request.setAttribute("mode","MODE_AGREGARMAS");
        return "index";
    }


    @PostMapping("/salvar-mascota")
    public String salvarMascota (@ModelAttribute Mascota mascota, @RequestParam int rut, HttpServletRequest request){
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




}
