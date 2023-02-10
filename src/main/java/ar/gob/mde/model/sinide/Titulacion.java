package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Data
public class Titulacion {

    @JsonProperty("id_titulacion") Long id_titulacion;
    @JsonProperty("nombre") String nombre;
    @JsonProperty("descripcion_adicional") String descripcion_adicional;
    @JsonProperty("c_tipo_titulo") Long c_tipo_titulo;
    @JsonProperty("c_orientacion") Long c_orientacion;
    @JsonProperty("c_dictado") Long c_dictado;
    @JsonProperty("carga_horaria") Long carga_horaria;
    @JsonProperty("c_carga_horaria_en") Long c_carga_horaria_en;
    @JsonProperty("c_articulacion_univ") Long c_articulacion_univ;
    @JsonProperty("duracion") Long duracion;
    @JsonProperty("c_duracion_en") Long c_duracion_en;
    @JsonProperty("id_titulacion_ciclo_basico") Long id_titulacion_ciclo_basico;

    @JsonIgnore
    HashMap<String, GradoNivelServicio> childMap = new HashMap<>(1);
    public void addGradoNivelServicio(CurrCompleto curr) {
        String currGnsId = curr.getC_grado_nivel_servicio() + "_" + curr.getId_titulacion();
        GradoNivelServicio gns = childMap.get(currGnsId);
        if (gns == null) {
            gns = new GradoNivelServicio();
            gns.setId(currGnsId);
            gns.setC_grado_nivel_servicio(curr.getC_grado_nivel_servicio());
            gns.setC_nivel_servicio(curr.getC_nivel_servicio());
            gns.setC_grado(curr.getC_grado());
            childMap.put(gns.getId(), gns);
        }
        gns.addEspacioCurricular(curr);
    }

    @JsonProperty("grado_nivel_servicio")
    Collection<GradoNivelServicio> getGradoNivelServicio() {
        return childMap.values();
    };

}
