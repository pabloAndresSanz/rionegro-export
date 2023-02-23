package ar.gob.mde.dao.sinide;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ar.gob.mde.model.sinide.CurrCompleto;
import ar.gob.mde.model.sinide.OrgCompleto;
import ar.gob.mde.model.sinide.Persona;
import ar.gob.mde.model.sinide.RelacionOrgCurrPersona;

@Mapper
public interface SinideDao {
    List<Persona> queryPersonaWithOffsetAndLimit(@Param("esquema") String esquema,@Param("offset") Long offset, @Param("limit") Long limit);
    List<CurrCompleto> queryCurrCompletoByIdTitulacion(@Param("esquema") String esquema,@Param("id_titulacion") Long idTitulacion);
    List<CurrCompleto> queryCurrCompletoWithOffsetAndLimit(@Param("esquema") String esquema,@Param("offset") Long offset, @Param("limit") Long limit);
    List<OrgCompleto> queryOrgCompletoByIdEstablecimiento(@Param("esquema") String esquema,@Param("id_establecimiento") Long idEstablecimiento);
    List<OrgCompleto> queryOrgCompletoWithOffsetAndLimit(@Param("esquema") String esquema,@Param("offset") Long offset, @Param("limit") Long limit);
    List<RelacionOrgCurrPersona> queryRelacionOrgCurrPersonaWithOffsetAndLimit(@Param("esquema") String esquema, @Param("offset") Long offset, @Param("limit") Long limit);
}
