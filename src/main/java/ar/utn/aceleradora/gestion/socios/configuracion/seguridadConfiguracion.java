package ar.utn.aceleradora.gestion.socios.configuracion;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration


public class seguridadConfiguracion {

}
  /*
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(false);
      }
    };
  }
  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    // Mapeo de SocioPostDTO a Socio
    modelMapper.createTypeMap(SocioPostDTO.class, Socio.class)
        .addMappings(mapping -> mapping.skip(Socio::setId));

    return modelMapper;
  }
}


 */