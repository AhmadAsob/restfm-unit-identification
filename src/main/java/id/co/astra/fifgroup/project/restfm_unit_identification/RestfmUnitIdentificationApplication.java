package id.co.astra.fifgroup.project.restfm_unit_identification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Configuration
@EnableScheduling
@SpringBootApplication
public class RestfmUnitIdentificationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestfmUnitIdentificationApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RestfmUnitIdentificationApplication.class);
	}

}
