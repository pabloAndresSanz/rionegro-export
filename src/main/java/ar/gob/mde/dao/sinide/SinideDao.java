package ar.gob.mde.dao.sinide;


import ar.gob.mde.model.sinide.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SinideDao {
    List<Persona> queryPersonaWithOffsetAndLimit(@Param("offset") Long offset, @Param("limit") Long limit);
    List<CurrCompleto> queryCurrCompletoByIdTitulacion(@Param("id_titulacion") Long idTitulacion);
    List<CurrCompleto> queryCurrCompletoWithOffsetAndLimit(@Param("offset") Long offset, @Param("limit") Long limit);
    List<OrgCompleto> queryOrgCompletoByIdEstablecimiento(@Param("id_establecimiento") Long idEstablecimiento);
    List<OrgCompleto> queryOrgCompletoWithOffsetAndLimit(@Param("offset") Long offset, @Param("limit") Long limit);
    List<RelacionOrgCurrPersona> queryRelacionOrgCurrPersonaWithOffsetAndLimit(@Param("schema") String schema, @Param("offset") Long offset, @Param("limit") Long limit);
}
