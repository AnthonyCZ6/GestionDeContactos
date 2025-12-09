package com.example.demo.Controller;


import com.example.demo.DTO.CreateContactosDTO;
import com.example.demo.Model.Contactos;
import com.example.demo.Service.ContactoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contactos")
public class ContactosController {

    private final ContactoService service;

    public ContactosController(ContactoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
        return service.findById(id).map(contactos -> ResponseEntity.ok((Object) contactos)).orElse(
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error","Contacto no encontrado"))
        );
    }

    @GetMapping
    public List<Contactos> list(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String busqueda

    ){
        return service.findAll(page,size,busqueda);
    }

    @PostMapping
    public ResponseEntity<Contactos> create(@RequestBody @Valid CreateContactosDTO dto){
        Contactos creado = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Object> update(@PathVariable Long id, @RequestBody @Valid CreateContactosDTO dto){
        return  service.update(id, dto).map(contactos -> ResponseEntity.ok((Object) contactos))
                .orElse(
                        ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error","Contacto no encontrado"))
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Object> delete(@PathVariable Long id){
        if (service.delete(id)){
            return ResponseEntity.ok(Map.of("message","Contacto eliminado"));
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error","Contacto no encontrado"));
        }
    }
}
