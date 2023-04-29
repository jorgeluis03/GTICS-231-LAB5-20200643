package com.example.gtics231lab520200643.dto;

import lombok.Getter;
import lombok.Setter;


public interface ReporteDto {
    String getPuesto();
    int getNumempleados();
    double getSalariomaximo();
    double getSalariominimo();
    double getSalariototales();
    double getSalariopromedio();
}
