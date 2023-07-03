package com.cuidar.api.core.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {


    /**
     * MessageSource
     * Le o message.properties
     *
     * bean.setValidationMessageSource(messageSource);
     * Indicando que o arquivo de message padrão sera o message.properties
     * e nao o validation.properties do Bean validation
     */
    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

}
