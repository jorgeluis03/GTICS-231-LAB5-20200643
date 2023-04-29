package com.example.gtics231lab520200643.controllers;

import com.example.gtics231lab520200643.dto.ReporteDto;
import com.example.gtics231lab520200643.repositorios.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    final JobRepository jobRepository;

    public HomeController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("/")
    public String inicio (){
        return "vistaInicial";
    }

    @GetMapping("/reportes")
    public String reportes(){
        return "reportes/reportesHome";
    }
    @GetMapping("/reportes/salario")
    public String salario(Model model){
        List<ReporteDto> listaSalario = jobRepository.reporteSalario();
        model.addAttribute("listaSalario",listaSalario);
        return "reportes/salario";
    }
    @GetMapping("/reportes/aumento")
    public String aumento(){
        return "reportes/aumento";
    }
}
