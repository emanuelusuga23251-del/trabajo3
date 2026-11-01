package com.trabajo3.controlador;

import com.trabajo3.modelo.EnumJuego;
import com.trabajo3.repositories.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JuegoController {

    @Autowired
    private JuegoRepository repo;

    @GetMapping("/vista1")
    public String punto2(Model model) {
        model.addAttribute("pila", repo.recorrerPila());
        model.addAttribute("serie", repo.recorrerSerie());
        return "vista1";
    }
    @GetMapping("/vista2")
    public String punto3(Model model) {
        model.addAttribute("filtrados", repo.filtrarPorTipo(EnumJuego.ACCION));
        model.addAttribute("tipo", EnumJuego.ACCION);
        return "vista2";
    }
    @GetMapping("/vista3")
    public String punto4(Model model) {
        model.addAttribute("totales", repo.totalesPorJuego());
        return "vista3";
    }
    @GetMapping("/vista4")
    public String punto5(Model model) {
        model.addAttribute("resultado", repo.totalDeUnJuego());
        return "vista4";
    }
}
