package ar.gob.mde.model.sinide;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.Date;

public class Persona {

    // Persona

    @CsvBindByName(column = "id_persona")
    @JsonProperty("id_persona")
    private Long idPersona;

    @CsvBindByName(column = "apellidos")
    @JsonProperty("apellidos")
    private String apellidos;

    @CsvBindByName(column = "nombres")
    @JsonProperty("nombres")
    private String nombres;

    @CsvBindByName(column = "c_tipo_documento")
    @JsonProperty("c_tipo_documento")
    private Integer	cTipoDocumento;

    @CsvBindByName(column = "nro_documento")
    @JsonProperty("nro_documento")
    private String numeroDocumento;

    @CsvBindByName(column = "cuit_cuil")
    @JsonProperty("cuit_cuil")
    private String cuitCuil;

    @CsvBindByName(column = "fecha_nacimiento")
    @CsvDate(value = "dd/MM/yyyy")
    @JsonProperty("fecha_nacimiento")
    private Date fechaNacimiento;

    @CsvBindByName(column = "c_localidad_nacimiento")
    @JsonProperty("c_localidad_nacimiento")
    private Integer	cLocalidadNacimiento;

    @CsvBindByName(column = "lugar_nacimiento")
    @JsonProperty("lugar_nacimiento")
    private String	lugarNacimiento;

    @CsvBindByName(column = "c_pais_nacimiento")
    @JsonProperty("c_pais_nacimiento")
    private Integer	cPaisNacimiento;

    @CsvBindByName(column = "c_nacionalidad")
    @JsonProperty("c_nacionalidad")
    private Integer	cNacionalidad;

    @CsvBindByName(column = "c_sexo")
    @JsonProperty("c_sexo")
    private Integer	cSexo;

    @CsvBindByName(column = "email")
    @JsonProperty("email")
    private String	email;

    @CsvBindByName(column = "cod_area_telefono")
    @JsonProperty("cod_area_telefono")
    private String	codAreaTelefono;

    @CsvBindByName(column = "nro_telefono")
    @JsonProperty("nro_telefono")
    private String	nroTelefono;

    @CsvBindByName(column = "c_estado_civil")
    @JsonProperty("c_estado_civil")
    private Integer	cEstadoCivil;

    @CsvBindByName(column = "calle")
    @JsonProperty("calle")
    private String	calle;

    @CsvBindByName(column = "nro")
    @JsonProperty("nro")
    private String	nro;

    @CsvBindByName(column = "barrio")
    @JsonProperty("barrio")
    private String	barrio;

    @CsvBindByName(column = "c_localidad")
    @JsonProperty("c_localidad")
    private Integer	cLocalidad;

    @CsvBindByName(column = "referencia")
    @JsonProperty("referencia")
    private String	referencia;

    @CsvBindByName(column = "cod_postal")
    @JsonProperty("cod_postal")
    private String	codPostal;

    @CsvBindByName(column = "c_pais_domicilio")
    @JsonProperty("c_pais_domicilio")
    private Integer	cPaisDomicilio;

    @CsvBindByName(column = "c_provincia_nacimiento")
    @JsonProperty("c_provincia_nacimiento")
    private Integer	cProvinciaNacimiento;

    // Alumno

    @CsvBindByName(column = "id_alumno")
    @JsonProperty("id_alumno")
    private String	idAlumno;

    @CsvBindByName(column = "c_indigena")
    @JsonProperty("c_indigena")
    private Integer	cIndigena;

    @CsvBindByName(column = "centro_encierro")
    @JsonProperty("centro_encierro")
    private String	centroEncierro;

    @CsvBindByName(column = "c_nivel_alcanzado_madre")
    @JsonProperty("c_nivel_alcanzado_madre")
    private Integer	cNivelAlcanzadoMadre;

    @CsvBindByName(column = "c_nivel_alcanzado_padre")
    @JsonProperty("c_nivel_alcanzado_padre")
    private Integer	cNivelAlcanzadoPadre;

    @CsvBindByName(column = "id_unidad_servicio")
    @JsonProperty("id_unidad_servicio")
    private Long	idUnidadServicio;

    @CsvBindByName(column = "c_beneficio_alimentario")
    @JsonProperty("c_beneficio_alimentario")
    private Integer	cBeneficioAlimentario;

    @CsvBindByName(column = "c_beneficio_plan")
    @JsonProperty("c_beneficio_plan")
    private Integer	cBeneficioPlan;

    @CsvBindByName(column = "c_transporte")
    @JsonProperty("c_transporte")
    private Integer	cTransporte;

    @CsvBindByName(column = "c_tipo_beneficio_plan")
    @JsonProperty("c_tipo_beneficio_plan")
    private Integer	cTipoBeneficioPlan;

    @CsvBindByName(column = "c_tipo_beneficio_alimentario")
    @JsonProperty("c_tipo_beneficio_alimentario")
    private Integer	cTipoBeneficioAlimentario;

    @CsvBindByName(column = "c_discapacidad")
    @JsonProperty("c_discapacidad")
    private Integer cDiscapacidad;

    /*
    private String	codigoDomicilio;
    private String  domicilioPorDefecto;
    private String  porDefecto;
    private String  codigoDiscapacidad;
    private String  codigoCertificadoDiscapacidad;
    private String  fechaHasta;
    private String  codigoLenguaIndigena;
    private String  fechaMedida;
    private String  codigoMedida;
    private String  valor;
    private String  codigoVacuna;
    private String  fechaVacuna;
    private String  codAreaTelefono;
    private String  nroTelefono;
    private String  codigoTelefono;
    private String  personaVinculada;
    private String  codigoVinculo;
    private String  codigoNivelAlcanzado;
    private String  codigoCentroDetencion;
    private String  codigoIndigena;
    private String  mail;

    private String  calleLateral1;
    private String  radio;
    private String  fraccion;
    private String  depto;
    private String  calleFondo;
    private String  calleLateral2;

    private String  departamentoNacimiento;
    private String  fallecido;
    private String  tieneAltaCapacidad;
    private String  XLongitud;
    private String  XLatitud;
    private String  codigoMail;*/
}
