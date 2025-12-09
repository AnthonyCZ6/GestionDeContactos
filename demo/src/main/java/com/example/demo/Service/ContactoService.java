package com.example.demo.Service;

import com.example.demo.DTO.CreateContactosDTO;
import com.example.demo.Model.Contactos;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ContactoService {
    private Map<Long, Contactos> alamacenamiento = new LinkedHashMap<>();
    private final AtomicLong idGenerador =new AtomicLong(1);

    public ContactoService(){
        save(new CreateContactosDTO("Tony","7777777777"));
    }

    public Contactos save(CreateContactosDTO dto){
        Long id= idGenerador.getAndIncrement();
        Contactos contacto =new Contactos(id, dto.getNombre(), dto.getTelefono());
        alamacenamiento.put(id,contacto);
        return contacto;
    }

    public Optional<Contactos> findById(Long id){
        return Optional.ofNullable(alamacenamiento.get(id));
    }

    public List<Contactos> findAll(int page, int size, String busqueda){
        List<Contactos> all = new ArrayList<>(alamacenamiento.values());

        if(busqueda != null && !busqueda.isBlank()){
            String encontrado =busqueda.toLowerCase();
            all = all.stream().filter(contactos -> contactos.getNombre().toLowerCase().contains(encontrado) ||
                    contactos.getTelefono().toLowerCase().contains(encontrado))
                    .collect(Collectors.toList());
        }

        int from = page *size;
        if(from >= all.size()) return Collections.emptyList();

        int to = Math.min(from + size, all.size());
        return all.subList(from,to);
    }

    public Optional <Contactos> update(Long id, CreateContactosDTO dto) {
        Contactos existe = alamacenamiento.get(id);
        if(existe == null) return Optional.empty();
        existe.setNombre(dto.getNombre());
        existe.setTelefono(dto.getTelefono());
        return Optional.of(existe);
    }

    public boolean delete(Long id){
        return alamacenamiento.remove(id) != null;
    }
}
