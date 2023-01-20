package pe.uni.alarreateguic.perucooking.retrofitapirest.controller;

import pe.uni.alarreateguic.perucooking.retrofitapirest.dto.PlatilloDTO;
import pe.uni.alarreateguic.perucooking.retrofitapirest.model.Platillo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/platillos")
public class PlatilloController {
    private List<Platillo> platillos = new ArrayList<>(Arrays.asList(
            new Platillo(1,"Ceviche de pescado","Pescado","Cebolla","Aji","Sal","Pimienta","Lechuga","Culantro",null,null,null,null,1,"https://comidasperuanas.net/wp-content/uploads/2015/08/Ceviche-Peruano-de-Pescado.webp"),
            new Platillo(2,"Lomo saltado","Carne de res","Cebolla","Tomate","Sal","Pimienta","Arroz","Papa","Vinagre","Aceite",null,null,1,"https://comidasperuanas.net/wp-content/uploads/2015/08/Lomo-Saltado.webp"),
            new Platillo(3,"Papa rellena","Papa","Carne de vaca","Cebolla","Tomate","Huevo","Aceituna","Ajo","Sal","Aceite",null,null,1,"https://comidasperuanas.net/wp-content/uploads/2015/08/Papa-rellena.webp"),
            new Platillo(4,"Escabeche de pescado","Pescado","Vinagre","Camote","Huevo","Aceituna","Caldo de pescado","Cebolla","Aji amarillo","Lechuga","Mostaza","Sal",1,"https://comidasperuanas.net/wp-content/uploads/2015/08/Papa-rellena.webp"),
            new Platillo(5,"Picarones","Levadura seca","Zapallo","Camote","Anis","Clavo","Canela","Agua","Harina","Sal",null,null,3,"https://comidasperuanas.net/wp-content/uploads/2015/08/Papa-rellena.webp"),
            new Platillo(6,"Arroz con mariscos","Langostino","Concha","Almeja","Choro","Calamar","Pulpo","Ajo","Arroz","Culantro","Cebolla","Limon",1,"https://comidasperuanas.net/wp-content/uploads/2015/08/Papa-rellena.webp"),
            new Platillo(7,"Carapulcra","Papa","Carne de chancho","Mani","Cebolla","Aji panca","Aceite","Ajo","Caldo de carne","Arroz","Sal",null,1,"https://comidasperuanas.net/wp-content/uploads/2015/11/Carapulcra.webp"),
            new Platillo(8,"Tallarin saltado criollo","Carne de res","Cebolla","Tomate","Cebolla china","Pimienta","Sillao","Aceite de oliva","Vinagre","Aji amarillo","Sal","Kion",1,"https://comidasperuanas.net/wp-content/uploads/2015/11/Carapulcra.webp")

    ));

    @GetMapping
    public ResponseEntity<List<Platillo>> getAll(){
        return ResponseEntity.ok(platillos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Platillo> getOne(@PathVariable("id") int id){
        Platillo platillo = findById(id);
        return ResponseEntity.ok(platillo);
    }

    @PostMapping
    public ResponseEntity<Platillo> create(@RequestBody PlatilloDTO dto){
        int index = platillos.isEmpty()? 1: getLastIndex() + 1;
        Platillo platillo = Platillo.builder().id(index).platillo(dto.getPlatillo()).ingrediente_1(dto.getIngrediente_1()).ingrediente_2(dto.getIngrediente_2()).ingrediente_3(dto.getIngrediente_3()).ingrediente_4(dto.getIngrediente_4()).ingrediente_5(dto.getIngrediente_5()).ingrediente_6(dto.getIngrediente_6()).ingrediente_7(dto.getIngrediente_7()).ingrediente_8(dto.getIngrediente_8()).ingrediente_9(dto.getIngrediente_9()).ingrediente_10(dto.getIngrediente_10()).ingrediente_11(dto.getIngrediente_11()).categoryId(dto.getCategoryId()).url_Image((dto.getUrl_Image())).build();
        platillos.add(platillo);
        return ResponseEntity.ok(platillo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Platillo> update(@PathVariable("id") int id, @RequestBody PlatilloDTO dto) {
        Platillo platillo = findById(id);
        platillo.setPlatillo(dto.getPlatillo());
        platillo.setIngrediente_1(dto.getIngrediente_1());
        platillo.setIngrediente_2(dto.getIngrediente_2());
        platillo.setIngrediente_3(dto.getIngrediente_3());
        platillo.setIngrediente_4(dto.getIngrediente_4());
        platillo.setIngrediente_5(dto.getIngrediente_5());
        platillo.setIngrediente_6(dto.getIngrediente_6());
        platillo.setIngrediente_7(dto.getIngrediente_7());
        platillo.setIngrediente_8(dto.getIngrediente_8());
        platillo.setIngrediente_9(dto.getIngrediente_9());
        platillo.setIngrediente_10(dto.getIngrediente_10());
        platillo.setIngrediente_11(dto.getIngrediente_11());
        platillo.setCategoryId(dto.getCategoryId());
        platillo.setUrl_Image(dto.getUrl_Image());
        return ResponseEntity.ok(platillo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Platillo> delete(@PathVariable("id") int id) {
        Platillo platillo = findById(id);
        platillos.remove(platillo);
        return ResponseEntity.ok(platillo);
    }

    private int getLastIndex() {
        return platillos.stream().max(Comparator.comparing(Platillo::getId)).get().getId();
    }

    private Platillo findById(int id) {
        return platillos.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }
}