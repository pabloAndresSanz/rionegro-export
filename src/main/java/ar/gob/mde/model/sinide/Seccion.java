package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

@Data
public class Seccion {
    @JsonProperty("id_seccion") Long idSeccion;
    @JsonProperty("nombre") String nombre;
    @JsonProperty("plazas") Long plazas;

    @JsonIgnore
    HashMap<Long, SeccionCurricular> childMap = new HashMap<>(5);
    public void addOrg(OrgCompleto org) {
        SeccionCurricular sc = childMap.get(org.getId_institucion());
        if (sc == null) {
            sc = new SeccionCurricular();
            sc.setIdSeccionCurricular(org.getId_seccion_curricular());
            sc.setCTurno(org.getC_turno());
            sc.setCGradoNivelServicio(org.getC_grado_nivel_servicio());
            childMap.put(sc.getIdSeccionCurricular(), sc);
        }
    }

    @JsonProperty("seccion-curricular")
    public Collection<SeccionCurricular> getSeccionCurricular() {
        return childMap.values();
    }

}
