package com.example.gtics231lab520200643.controllers;

import com.example.gtics231lab520200643.entity.Departamento;
import com.example.gtics231lab520200643.entity.Empelado;
import com.example.gtics231lab520200643.entity.Job;
import com.example.gtics231lab520200643.repositorios.DepartamentoRepository;
import com.example.gtics231lab520200643.repositorios.EmpleadoRepository;
import com.example.gtics231lab520200643.repositorios.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public String nuevoEmpleado(@ModelAttribute ("empleado") Empelado empleado, Model model){
        List<Job> listaPuesto = jobRepository.findAll();
        List<Departamento> listadepas = departamentoRepository.findAll();
        List<Empelado> listaJefes = empleadoRepository.findAll();
        model.addAttribute("listaJefes",listaJefes);
        model.addAttribute("listaPuesto", listaPuesto);
        model.addAttribute("listaDepas", listadepas);
        return "empleados/FormNuevo";}
    @GetMapping("/editForm")
    public String editar(@ModelAttribute("empleado") Empelado empleado,Model model, @RequestParam("id") int id){
        Optional<Empelado> optEmpleado = empleadoRepository.findById(id);
        if(optEmpleado.isPresent()){
            empleado = optEmpleado.get();
            model.addAttribute("empleado", empleado);
            List<Job> listaPuesto = jobRepository.findAll();
            List<Departamento> listadepas = departamentoRepository.findAll();
            List<Empelado> listaJefes = empleadoRepository.findAll();
            model.addAttribute("listaJefes",listaJefes);
            model.addAttribute("listaPuesto", listaPuesto);
            model.addAttribute("listaDepas", listadepas);
            return "empleados/EditForm";
        }else {
            return "redirect:/empleado/listar";
        }

    }

    @PostMapping("/buscar")
    public String buscar(@RequestParam("searchField") String searchField, Model model){
      List<Empelado> lista = empleadoRepository.buscar(searchField,searchField);
        model.addAttribute("lista",lista);
        return "empleados/listar";
    }
    @PostMapping("/guardar")
    public String guardar (@ModelAttribute("empleado") Empelado empleado, RedirectAttributes attr){
        if(empleado.getEmployee_id()==0){
            attr.addFlashAttribute("msg","Empleado creado exitosamente");
        }else {
            attr.addFlashAttribute("msg","Empleado actualizado exitosamente");
        }
        empleado.setHire_date(LocalDate.now());
        empleadoRepository.save(empleado);
        return "redirect:/empleado/listar";
    }
    @GetMapping("/borrar")
    public String borrar (@RequestParam("id") int id, RedirectAttributes attr){
        Optional<Empelado> optionalEmpelado = empleadoRepository.findById(id);
        if(optionalEmpelado.isPresent()){
           attr.addFlashAttribute("msgError","Empleado borrado exitosamente");
           empleadoRepository.deleteById(id);
        }
        return "redirect:/empleado/listar";
    }
}
