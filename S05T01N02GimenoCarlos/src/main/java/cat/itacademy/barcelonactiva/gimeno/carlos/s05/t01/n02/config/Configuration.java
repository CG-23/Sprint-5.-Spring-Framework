package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
	  public ModelMapper modelMapper() {
	    return new ModelMapper();
	  }
}