package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class SeccionCurricular {
    @JsonProperty("id_seccion_curricular") Long idSeccionCurricular;
    @JsonProperty("c_grado_nivel_servicio") Long cGradoNivelServicio;
    @JsonProperty("c_turno") Long cTurno;
}
