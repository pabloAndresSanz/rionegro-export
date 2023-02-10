package ar.gob.mde;

import ar.gob.mde.service.SinideService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellMethod;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Bootstrap.main(args);

		/*ObjectMapper jsonMapper = new ObjectMapper();
		String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sinideService.getTitulaciones());
		System.out.println(json);*/
	}


}
