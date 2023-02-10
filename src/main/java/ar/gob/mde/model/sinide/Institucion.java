package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.HashMap;

@Data
public class Institucion {
    @JsonProperty("id_institucion") Long idInstitucion;
    @JsonProperty("codigo_jurisdiccional") String codigoJurisdiccional;
    @JsonProperty("cueanexo") String cueanexo;
    @JsonProperty("nombre") String nombre;

    @JsonIgnore
    HashMap<Long, UnidadServicio> childMap = new HashMap<>(5);
    public void addOrg(OrgCompleto org) {
        UnidadServicio us = childMap.get(org.getId_unidad_servicio());
        if (us == null) {
            us = new UnidadServicio();
            us.setIdUnidadServicio(org.getId_unidad_servicio());
            us.setCEstado(org.getC_estado());
            us.setCNivelServicio(org.getC_nivel_servicio());
            childMap.put(us.getIdUnidadServicio(), us);
        }
        us.addOrg(org);
    }

    @JsonProperty("unidad_servicio")
    public Collection<UnidadServicio> getUnidadServicio() {
        return childMap.values();
    }

}
