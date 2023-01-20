package pe.uni.alarreateguic.perucooking.retrofitapirest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Platillo {
    private int id;
    private String platillo;
    private String ingrediente_1;
    private String ingrediente_2;
    private String ingrediente_3;
    private String ingrediente_4;
    private String ingrediente_5;
    private String ingrediente_6;
    private String ingrediente_7;
    private String ingrediente_8;
    private String ingrediente_9;
    private String ingrediente_10;
    private String ingrediente_11;
    private int categoryId;
    private String url_Image;
}
