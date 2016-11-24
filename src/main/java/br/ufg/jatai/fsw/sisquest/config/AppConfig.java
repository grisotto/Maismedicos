package br.ufg.jatai.fsw.sisquest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author dfranco
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.ufg.jatai.fsw.sisquest")
public class AppConfig extends WebMvcConfigurerAdapter {

    private static Logger log = LoggerFactory.getLogger(AppConfig.class.getName());

    /**
     *
     * @return
     */
    @Bean
    public ViewResolver getViewResolver() {
        log.info("Configurando View Resolver");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * Configurando os locais de acesso aos recursos
     * @param registry 
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("Configurando Resouce Local");
        registry.addResourceHandler("/tema/**")
                .addResourceLocations("/assets/dist/");
        registry.addResourceHandler("/plugins/**")
                .addResourceLocations("/assets/plugins/");
        registry.addResourceHandler("/bootstrap/**")
                .addResourceLocations("/assets/bootstrap/");
    }

}
