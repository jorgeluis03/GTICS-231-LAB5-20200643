package com.example.gtics231lab520200643.controllers;

import com.example.gtics231lab520200643.dto.EmpleadosDto;
import com.example.gtics231lab520200643.repositorios.EmpleadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    final EmpleadoRepository empleadoRepository;
    public EmpleadoController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @GetMapping("/listar")
    public String listar (Model model){
        List<EmpleadosDto> listaEmpleadosDto = empleadoRepository.listaEmpelados();
        model.addAttribute("lista",listaEmpleadosDto);
        return "empleados/listar";
    }
    @GetMapping("/nuevoForm")
    public String nuevoEmpleado(){return "empleados/FormNuevo";}



}
