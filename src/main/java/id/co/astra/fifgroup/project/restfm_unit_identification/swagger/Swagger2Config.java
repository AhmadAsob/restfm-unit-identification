package id.co.astra.fifgroup.project.restfm_unit_identification.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

	static final String description = "RestFM-Unit Identification is Restful API for FIFGROUP and External colaboration";
	@Value("${keycloak.auth-server-url}")
	private String AUTH_SERVER;
	@Value("${keycloak.realm}")
	private String REALM;
//	@Value("${credentials.client.id}")
	private String CLIENT_ID;
//	@Value("${credentials.client.secret}")
	private String CLIENT_SECRET;

	private static final String OAUTH_NAME = "fifgroup_oauth";
	private static final String GROUP_NAME = "public-api";

//	public Docket api(){
//		return new Docket(DocumentationType.SWAGGER_2).select().build();
//	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("id.co.astra.fifgroup.project.restfm_unit_identification.controller"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo())
				.securitySchemes(Arrays.asList(securityScheme())).securityContexts(Arrays.asList(securityContext()));
	}

	@Bean
	public SecurityConfiguration security() {

		return SecurityConfigurationBuilder.builder().realm(REALM).clientId(CLIENT_ID).clientSecret(CLIENT_SECRET)
				.appName(GROUP_NAME).build();
	}

	private SecurityScheme securityScheme() {
		return new OAuthBuilder().name(OAUTH_NAME).scopes(defaultScope()).grantTypes(grantTypes()).build();
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
	}

	private List<GrantType> grantTypes() {
		List<GrantType> grantTypes = new ArrayList<>();
		grantTypes.add(new ClientCredentialsGrant(AUTH_SERVER + "/realms/" + REALM + "/protocol/openid-connect/token"));
		return grantTypes;
	}

	private List<SecurityReference> defaultAuth() {
		return Arrays.asList(new SecurityReference(OAUTH_NAME, defaultScope().toArray(new AuthorizationScope[] {})));
	}

	private List<AuthorizationScope> defaultScope() {
		List<AuthorizationScope> authorizationScopes = new ArrayList<>();
		return authorizationScopes;
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot RESTFUL API").description(description).license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.2.0").build();
	}

}
