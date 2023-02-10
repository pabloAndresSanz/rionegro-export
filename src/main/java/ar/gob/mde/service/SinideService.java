package ar.gob.mde.service;


import ar.gob.mde.dao.sinide.SinideDao;
import ar.gob.mde.model.sinide.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class SinideService {

    @Autowired
    private SinideDao sinideDao;

    /**
     * Obtiene todas las personas limitadas por el rango [offset,limit]
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<Persona> getPersonas(Long offset, Long limit) {
        List<Persona> tList = sinideDao.queryPersonaWithOffsetAndLimit(offset, limit);
        return tList;
    }

    /**
     * Obtiene una titulacion por su ID
     *
     * @param idTitulacion
     * @return
     */
    public Collection<Titulacion> getTitulacionById(Long idTitulacion) {
        List<CurrCompleto> currCompletoList = sinideDao.queryCurrCompletoByIdTitulacion(idTitulacion);
        HashMap<Long, Titulacion> titMap = new HashMap<>(10000);

        for(CurrCompleto curr : currCompletoList) {
            Titulacion tit = getTitulacion(titMap, curr);
            tit.addGradoNivelServicio(curr);
        }

        return titMap.values();
    }

    /**
     * Obtiene todas las titulaciones completas con su estructura interna
     *
     * @param offset
     * @param limit
     * @return
     */
    public Collection<Titulacion> getTitulacionesAll(Long offset, Long limit) {
        List<CurrCompleto> currCompletoList = sinideDao.queryCurrCompletoWithOffsetAndLimit(offset,limit);
        HashMap<Long, Titulacion> titMap = new HashMap<>(10000);

        for(CurrCompleto curr : currCompletoList) {
            Titulacion tit = getTitulacion(titMap, curr);
            tit.addGradoNivelServicio(curr);
        }

        return titMap.values();
    }

    /**
     * Obtiene un establecimiento completo por su ID
     *
     * @param idEstablecimiento
     * @return
     */
    public Collection<Establecimiento> getEstablecimientoById(Long idEstablecimiento) {
        List<OrgCompleto> orgCompletoList = sinideDao.queryOrgCompletoByIdEstablecimiento(idEstablecimiento);
        HashMap<Long, Establecimiento> estMap = new HashMap<>(1);

        for(OrgCompleto org : orgCompletoList) {
            //
            // obtengo la raiz (el estableimiento) de la estructura para esta linea
            Establecimiento est = getEstablecimiento(estMap, org);
            //
            // el pojo va armando la estructura jerarquica agregando los nodos que hacen falta
            est.addOrg(org);
        }

        return estMap.values();
    }

    /**
     * Obtiene todos los establecimientos completos con su estructura interna
     *
     * @param offset
     * @param limit
     * @return
     */
    public Collection<Establecimiento> getEstablecimientosAll(Long offset, Long limit) {
        List<OrgCompleto> orgCompletoList = sinideDao.queryOrgCompletoWithOffsetAndLimit(offset,limit);
        HashMap<Long, Establecimiento> estMap = new HashMap<>(1000);

        for(OrgCompleto org : orgCompletoList) {
            Establecimiento est = getEstablecimiento(estMap, org);
            est.addOrg(org);
        }

        return estMap.values();
    }



    public List<RelacionOrgCurrPersona> getRelacionOrgCurrPersona(Long offset, Long limit) {
        List<RelacionOrgCurrPersona> tList = sinideDao.queryRelacionOrgCurrPersonaWithOffsetAndLimit("salta", offset, limit);
        return tList;
    }

    /**
     * Tranformer Helper entre CurrCompleto y estructura jerarquica de Titulacion
     *
     * @param titMap
     * @param curr
     * @return
     */
    private Titulacion getTitulacion(HashMap<Long, Titulacion> titMap, CurrCompleto curr) {
        Titulacion tit = titMap.get(curr.getId_titulacion());
        if(tit == null) {
            tit = new Titulacion();
            tit.setId_titulacion(curr.getId_titulacion());
            tit.setNombre(curr.getNombre_titulacion());
            tit.setDescripcion_adicional(curr.getDescripcion_adicional());
            tit.setC_tipo_titulo(curr.getC_tipo_titulo());
            tit.setC_orientacion(curr.getC_orientacion());
            tit.setC_dictado(curr.getC_dictado_titulacion());
            tit.setCarga_horaria(curr.getCarga_horaria());
            tit.setC_carga_horaria_en(curr.getC_carga_horaria_en_titulacion());
            tit.setC_articulacion_univ(curr.getC_articulacion_univ());
            tit.setDuracion(curr.getDuracion());
            tit.setC_duracion_en(curr.getC_duracion_en());
            tit.setId_titulacion_ciclo_basico(curr.getId_titulacion_ciclo_basico());
            titMap.put(tit.getId_titulacion(), tit);
        }
        return tit;
    }

    /**
     * Tranformer Helper entre OrgCompleto y estructura jerarquica de Establecimiento
     *
     * @param estMap
     * @param org
     * @return
     */
    private Establecimiento getEstablecimiento(HashMap<Long, Establecimiento> estMap, OrgCompleto org) {
        Establecimiento est = estMap.get(org.getId_establecimiento());
        if (est == null) {
            est = new Establecimiento();
            est.setIdEstablecimiento(org.getId_establecimiento());
            est.setCue(org.getCue());
            est.setCSector(org.getC_sector());
            est.setFechaCreacion(org.getEst_fecha_creacion());
            est.setNombre(org.getEst_nombre());
            estMap.put(est.getIdEstablecimiento(), est);
        }
        return est;
    }

}
