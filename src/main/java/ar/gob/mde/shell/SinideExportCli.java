package ar.gob.mde.shell;

import ar.gob.mde.model.sinide.Establecimiento;
import ar.gob.mde.model.sinide.Persona;
import ar.gob.mde.model.sinide.RelacionOrgCurrPersona;
import ar.gob.mde.model.sinide.Titulacion;
import ar.gob.mde.service.SinideService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;


@ShellComponent(value = "SinideExportCLI")
public class SinideExportCli {

    @Autowired
    SinideService sinideService;

    @ShellMethod(key = "persona", value = "Export de personas en formato CSV limitada por un offset y un limite")
    public String personasWithOffsetAndLimit(
            @ShellOption(help = "Offset o punto inicial desde donde se comienza el export") Long offset,
            @ShellOption(help = "Limite de cantidad de registros maximos a exportar") Long limite,
            @ShellOption(help = "Nombre de archivo donde se dejará el export") String file) throws IOException {

        List<Persona> result = sinideService.getPersonas(offset, limite);
        serializeToCsv(Persona.class, result, file);
        return "Done.";
    }

    @ShellMethod(key = "curr-all", value = "Export de toda la estructura curricular")
    public String currWithOffsetAndLimit(
            /*@ShellOption(help = "Offset o punto inicial desde donde se comienza el export") Long offset,
            @ShellOption(help = "Limite de cantidad de registros maximos a exportar") Long limite,*/
            @ShellOption(help = "Nombre de archivo donde se dejará el export") String file) throws IOException {

        //Collection<Titulacion> result = sinideService.getTitulaciones(0l, 10000000l);
        Collection<Titulacion> result = sinideService.getTitulacionesAll(0l,1000000000l);
        serializeToJson(result, file);
        return "Done.";
    }

    @ShellMethod(key = "curr-by-id", value = "Export de estructura curricular para la titulacion determinada por el ID dado")
    public String currById(
            @ShellOption(help = "Id de titulacion") Long id,
            @ShellOption(help = "Nombre de archivo donde se dejará el export") String file) throws IOException {

        Collection<Titulacion>  result = sinideService.getTitulacionById(id);
        serializeToJson(result, file);
        return "Done.";
    }

    @ShellMethod(key = "org-all", value = "Export de todas las estructuras organizacionales")
    public String orgAll(
            /*@ShellOption(help = "Offset o punto inicial desde donde se comienza el export") Long offset,
            @ShellOption(help = "Limite de cantidad de registros maximos a exportar") Long limite,*/
            @ShellOption(help = "Nombre de archivo donde se dejará el export") String file) throws IOException {

        Collection<Establecimiento> result = sinideService.getEstablecimientosAll(0l,1000000l);
        serializeToJson(result, file);
        return "Done.";
    }

    @ShellMethod(key = "org-by-id", value = "Export de estructura organizacional para el establecimiento determinado por el ID dado")
    public String orgById(
            @ShellOption(help = "Id de establecimiento") Long id,
            @ShellOption(help = "Nombre de archivo donde se dejará el export") String file) throws IOException {

        Collection<Establecimiento> result = sinideService.getEstablecimientoById(id);
        serializeToJson(result, file);
        return "Done.";
    }

    @ShellMethod(key = "rel-org-curr-persona", value = "Export de las relaciones organizacional/curricular/persona")
    public String relOrgCurrWithOffsetAndLimit(
            @ShellOption(help = "Offset o punto inicial desde donde se comienza el export") Long offset,
            @ShellOption(help = "Limite de cantidad de registros maximos a exportar") Long limite,
            @ShellOption(help = "Nombre de archivo donde se dejará el export") String file) throws IOException {

        List<RelacionOrgCurrPersona> result = sinideService.getRelacionOrgCurrPersona(offset, limite);
        serializeToCsv(RelacionOrgCurrPersona.class, result, file);
        return "Done.";
    }



    protected void serializeToCsv(Class clazz, List result, String file) throws IOException {
        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)) {
            StatefulBeanToCsvBuilder sbcBuilder = null;
            if(Persona.class.getName().equals(clazz.getName()))
                sbcBuilder = new StatefulBeanToCsvBuilder<Persona>(out);
            else if(RelacionOrgCurrPersona.class.getName().equals(clazz.getName()))
                sbcBuilder = new StatefulBeanToCsvBuilder<RelacionOrgCurrPersona>(out);

            StatefulBeanToCsv sbc = sbcBuilder
                    .withQuotechar('\"')
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            sbc.write(result);
        } catch (FileNotFoundException ex) {
            // Ignore
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

    protected void serializeToJson(Collection result, String file) throws IOException {
        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)) {
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            final String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            out.write(json);
        } catch (FileNotFoundException ex) {
            // Ignore
        }
    }


}
