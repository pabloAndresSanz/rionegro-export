package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

@Data
public class UnidadServicio {
    @JsonProperty("id_unidad_servicio") Long idUnidadServicio;
    @JsonProperty("c_nivel_servicio") Long cNivelServicio;
    @JsonProperty("c_estado") Long cEstado;

    @JsonIgnore
    HashMap<Long, Seccion> childMap = new HashMap<>(5);
    public void addOrg(OrgCompleto org) {
        Seccion seccion = childMap.get(org.getId_seccion());
        if (seccion == null) {
            seccion = new Seccion();
            seccion.setIdSeccion(org.getId_seccion());
            seccion.setNombre(org.getSec_nombre());
            seccion.setPlazas(org.getPlazas());
            childMap.put(seccion.getIdSeccion(), seccion);
        }
        seccion.addOrg(org);
    }

    @JsonProperty("seccion")
    public Collection<Seccion> getSeccion() {
        return childMap.values();
    }

}
