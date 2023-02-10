package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Data
public class GradoNivelServicio {

    @JsonProperty("id") String id;
    @JsonProperty("c_grado_nivel_servicio") Long c_grado_nivel_servicio;
    @JsonProperty("c_grado") Long c_grado;
    @JsonProperty("c_nivel_servicio") Long c_nivel_servicio;

    @JsonIgnore
    HashMap<Long, EspacioCurricular> childMap = new HashMap<>(1);
    public void addEspacioCurricular(CurrCompleto curr) {
        EspacioCurricular ec = childMap.get(curr.getId_espacio_curricular());
        if (ec == null) {
            ec = new EspacioCurricular();
            ec.setId_espacio_curricular(curr.getId_espacio_curricular());
            ec.setNombre(curr.getNombre_espacio_curricular());
            ec.setC_trayecto_formativo(curr.getC_trayecto_formativo());
            ec.setC_dictado(curr.getC_dictado_espacio_curricular());
            ec.setC_obligatoriedad(curr.getC_obligatoriedad());
            ec.setC_carga_horaria_en(curr.getC_carga_horaria_en_espacio_curricular());
            ec.setCarga_horaria_semanal(curr.getCarga_horaria_semanal());
            ec.setC_escala_numerica(curr.getC_escala_numerica());
            ec.setNota_minima(curr.getNota_minima());
            ec.setC_formato_espacio_curricular(curr.getC_formato_espacio_curricular());
            ec.setC_espacio_curricular_duracion_en(curr.getC_espacio_curricular_duracion_en());
            ec.setC_dicta_cuatrimestre(curr.getC_dicta_cuatrimestre());
            ec.setC_promocionable(curr.getC_promocionable());
            ec.setNota_promocion(curr.getNota_promocion());
            ec.setNota_cursada(curr.getNota_cursada());
            childMap.put(ec.getId_espacio_curricular(), ec);
        }
    }

    @JsonProperty("espacio_curricular")
    Collection<EspacioCurricular> getEspacioCurricular() {
        return childMap.values();
    };

}
