package com.example.gtics231lab520200643.controllers;

import com.example.gtics231lab520200643.entity.Departamento;
import com.example.gtics231lab520200643.entity.Empelado;
import com.example.gtics231lab520200643.entity.Job;
import com.example.gtics231lab520200643.repositorios.DepartamentoRepository;
import com.example.gtics231lab520200643.repositorios.EmpleadoRepository;
import com.example.gtics231lab520200643.repositorios.JobRepository;
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
    final JobRepository jobRepository;
    final DepartamentoRepository departamentoRepository;
    public EmpleadoController(EmpleadoRepository empleadoRepository, JobRepository jobRepository, DepartamentoRepository departamentoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.jobRepository = jobRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @GetMapping("/listar")
    public String listar (Model model){
        List<Empelado> listaEmpleados = empleadoRepository.findAll();
        model.addAttribute("lista",listaEmpleados);
        return "empleados/listar";
    }
    @GetMapping("/nuevoForm")
    public String nuevoEmpleado(Model model){
        List<Job> listaPuesto = jobRepository.findAll();
        List<Departamento> listadepas = departamentoRepository.findAll();
        model.addAttribute("listaPuesto", listaPuesto);
        model.addAttribute("listaDepas", listadepas);
        return "empleados/FormNuevo";}

    @PostMapping("/buscar")
    public String buscar(@RequestParam("searchField") String searchField, Model model){
      List<Empelado> lista = empleadoRepository.buscar(searchField,searchField);
        model.addAttribute("lista",lista);
        return "empleados/listar";
    }
    @PostMapping("/guardar")
    public String guardar (Empelado empleado){
        empleadoRepository.save(empleado);
        return "redirect:/empleado/listar";
    }

}
