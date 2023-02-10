package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

@Data
public class Establecimiento {
    @JsonProperty("id_establecimiento") Long idEstablecimiento;
    @JsonProperty("cue") String cue;
    @JsonProperty("nombre") String nombre;
    @JsonProperty("c_sector") Long cSector;
    @JsonProperty("fecha_creacion") Date fechaCreacion;

    @JsonIgnore
    HashMap<Long, Institucion> childMap = new HashMap<>(1);
    public void addOrg(OrgCompleto org) {
        Institucion ins = childMap.get(org.getId_institucion());
        if (ins == null) {
            ins = new Institucion();
            ins.setIdInstitucion(org.getId_institucion());
            ins.setCueanexo(org.getCueanexo());
            ins.setNombre(org.getLoc_nombre());
            ins.setCodigoJurisdiccional(org.getCodigo_jurisdiccional());
            childMap.put(ins.getIdInstitucion(), ins);
        }
        ins.addOrg(org);
    }

    @JsonProperty("institucion")
    public Collection<Institucion> getInstitucion() {
        return childMap.values();
    }

}
