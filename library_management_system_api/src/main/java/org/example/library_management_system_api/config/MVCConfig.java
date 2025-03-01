package org.example.library_management_system_api.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MVCConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
