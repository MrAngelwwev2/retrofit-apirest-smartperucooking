package pe.uni.alarreateguic.perucooking.retrofitapirest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Categorias {
    private int id;
    private String nombre;
    private String descripcion;
}
