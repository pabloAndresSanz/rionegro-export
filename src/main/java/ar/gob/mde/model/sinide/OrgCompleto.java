package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class OrgCompleto {
    // establecimiento
    @JsonProperty("id_establecimiento") Long id_establecimiento;
    @JsonProperty("cue") String cue;
    @JsonProperty("est_nombre") String est_nombre;
    @JsonProperty("c_sector") Long c_sector;
    @JsonProperty("est_fecha_creacion") Date est_fecha_creacion;
    //localizacion
    @JsonProperty("id_institucion") Long id_institucion;
    @JsonProperty("codigo_jurisdiccional") String codigo_jurisdiccional;
    @JsonProperty("cueanexo") String cueanexo;
    @JsonProperty("loc_nombre") String loc_nombre;
    // unidad de servicio
    @JsonProperty("id_unidad_servicio") Long id_unidad_servicio;
    @JsonProperty("c_nivel_servicio") Long c_nivel_servicio;
    @JsonProperty("c_estado") Long c_estado;
    // seccion
    @JsonProperty("id_seccion") Long id_seccion;
    @JsonProperty("sec_nombre") String sec_nombre;
    @JsonProperty("plazas") Long plazas;
    //seccion curricular
    @JsonProperty("id_seccion_curricular") Long id_seccion_curricular;
    @JsonProperty("c_grado_nivel_servicio") Long c_grado_nivel_servicio;
    @JsonProperty("c_turno") Long c_turno;
}
