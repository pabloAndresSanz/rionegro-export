package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CurrCompleto {

    // titulacion
    Long id_titulacion;
    String nombre_titulacion;
    String descripcion_adicional;
    Long c_tipo_titulo;
    Long c_orientacion;
    Long c_dictado_titulacion;
    Long carga_horaria;
    Long c_carga_horaria_en_titulacion;
    Long c_articulacion_univ;
    Long duracion;
    Long c_duracion_en;
    Long id_titulacion_ciclo_basico;
    // grado-nivel-servicio
    Long c_grado_nivel_servicio;
    Long c_grado;
    Long c_nivel_servicio;
    // espacio_curricular
    Long id_espacio_curricular;
    String nombre_espacio_curricular;
    Long c_trayecto_formativo;
    Long c_dictado_espacio_curricular;
    Long c_obligatoriedad;
    Long c_carga_horaria_en_espacio_curricular;
    Long carga_horaria_semanal;
    Long c_escala_numerica;
    Long nota_minima;
    Long c_formato_espacio_curricular;
    Long c_espacio_curricular_duracion_en;
    Long c_dicta_cuatrimestre;
    Long c_promocionable;
    Long nota_promocion;
    Long nota_cursada;

}
