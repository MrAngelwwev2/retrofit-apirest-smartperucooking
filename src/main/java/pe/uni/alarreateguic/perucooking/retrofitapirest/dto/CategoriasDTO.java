package pe.uni.alarreateguic.perucooking.retrofitapirest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CategoriasDTO {
    private String nombre;
    private String descripcion;
}