package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

public class CreateContactosDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 10, message = "El nombre debe 2 a 10 caracteres")
    private String nombre;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(min = 2, max = 10, message = "Ingrese su numero de 10 digitos")
    private String telefono;

    public CreateContactosDTO() {
    }

    public CreateContactosDTO(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
