package pe.uni.alarreateguic.perucooking.retrofitapirest.controller;

import pe.uni.alarreateguic.perucooking.retrofitapirest.dto.CategoriasDTO;
import pe.uni.alarreateguic.perucooking.retrofitapirest.model.Categorias;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriasController {
    private List<Categorias> categorias = new ArrayList<>(Arrays.asList(
            new Categorias(1,"Segundos","Segundos maritimos, segundos no maritimos"),
            new Categorias(2,"Sopas","Sopas maritimas, sopas no maritimas"),
            new Categorias(3,"Postres","Dulce, salado, etc"),
            new Categorias(4,"Refrescos","Con alcohol, sin alcohol, etc")
    ));

    @GetMapping
    public ResponseEntity<List<Categorias>> getAll(){
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categorias> getOne(@PathVariable("id") int id){
        Categorias categorias1 = findById(id);
        return ResponseEntity.ok(categorias1);
    }

    @PostMapping
    public ResponseEntity<Categorias> create(@RequestBody CategoriasDTO dto){
        int index = categorias.isEmpty()? 1: getLastIndex() + 1;
        Categorias categorias1 = Categorias.builder().id(index).nombre(dto.getNombre())
                .descripcion(dto.getDescripcion()).build();
        categorias.add(categorias1);
        return ResponseEntity.ok(categorias1);
    }

    @PutMapping("{id}")
    public ResponseEntity<Categorias> update(@PathVariable("id") int id, @RequestBody CategoriasDTO dto) {
        Categorias categoria1 = findById(id);
        categoria1.setNombre(dto.getNombre());
        categoria1.setDescripcion(dto.getDescripcion());
        return ResponseEntity.ok(categoria1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Categorias> delete(@PathVariable("id") int id) {
        Categorias categoria1 = findById(id);
        categorias.remove(categoria1);
        return ResponseEntity.ok(categoria1);
    }

    private int getLastIndex() {
        return categorias.stream().max(Comparator.comparing(Categorias::getId)).get().getId();
    }

    private Categorias findById(int id) {
        return categorias.stream().filter(c -> c.getId() == id).findAny().orElse(null);
    }
}
