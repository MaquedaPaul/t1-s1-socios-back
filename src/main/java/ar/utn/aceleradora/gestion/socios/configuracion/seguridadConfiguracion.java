package ar.utn.aceleradora.gestion.socios.configuracion;

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