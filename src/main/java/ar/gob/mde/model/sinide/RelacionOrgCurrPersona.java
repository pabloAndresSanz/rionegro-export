package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.Date;

public class RelacionOrgCurrPersona {

    // Relacion de inscripcion (Persona / Organizacional / Curricular)

    @CsvBindByName(column = "id_espacio_curricular")
    @JsonProperty("id_espacio_curricular")
    private Long idEspacioCurricular;

    @CsvBindByName(column = "id_seccion_curricular")
    @JsonProperty("id_seccion_curricular")
    private Long idSeccionCurricular;

    @CsvBindByName(column = "id_persona")
    @JsonProperty("id_persona")
    private Long idPersona;

    @CsvBindByName(column = "fecha_inscripcion")
    @CsvDate(value = "dd/MM/yyyy", writeFormat = "dd/MM/yyyy")
    @JsonProperty("fecha_inscripcion")
    private Date fechaInscripcion;
}
