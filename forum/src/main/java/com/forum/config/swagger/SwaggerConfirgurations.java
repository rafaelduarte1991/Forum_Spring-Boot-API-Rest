package com.forum.config.swagger;

import org.springframework.context.annotation.Configuration;
import com.forum.model.ForumUser;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Arrays;

@Configuration
public class SwaggerConfirgurations {

	public Docket forumApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.forum"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(ForumUser.class)
				.globalOperationParameters(Arrays.asList(
                                new ParameterBuilder()
                                    .name("Authorization")
                                    .description("Header (Token JWT)")
                                    .modelRef(new ModelRef("string"))
                                    .parameterType("header")
                                    .required(false)
                                    .build()));
	} 
}
