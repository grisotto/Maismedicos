package br.ufg.jatai.fsw.sisquest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author dfranco
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     *
     * @return
     */
    @Override
	protected Class[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

    /**
     *
     * @return
     */
    @Override
	protected Class[] getServletConfigClasses() {
		return null;
	}

    /**
     *
     * @return
     */
    @Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

 
        

}