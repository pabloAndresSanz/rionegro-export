package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EspacioCurricular {

    @JsonIgnore Long id_titulacion;
    @JsonIgnore Long c_grado_nivel_servicio;
    @JsonProperty("id_espacio_curricular") Long id_espacio_curricular;
    @JsonProperty("nombre") String nombre;
    @JsonProperty("c_trayecto_formativo") Long c_trayecto_formativo;
    @JsonProperty("c_dictado") Long c_dictado;
    @JsonProperty("c_obligatoriedad") Long c_obligatoriedad;
    @JsonProperty("c_carga_horaria_en") Long c_carga_horaria_en;
    @JsonProperty("carga_horaria_semanal") Long carga_horaria_semanal;
    @JsonProperty("c_escala_numerica") Long c_escala_numerica;
    @JsonProperty("nota_minima") Long nota_minima;
    @JsonProperty("c_formato_espacio_curricular") Long c_formato_espacio_curricular;
    @JsonProperty("c_espacio_curricular_duracion_en") Long c_espacio_curricular_duracion_en;
    @JsonProperty("c_dicta_cuatrimestre") Long c_dicta_cuatrimestre;
    @JsonProperty("c_promocionable") Long c_promocionable;
    @JsonProperty("nota_promocion") Long nota_promocion;
    @JsonProperty("nota_cursada") Long nota_cursada;

}
