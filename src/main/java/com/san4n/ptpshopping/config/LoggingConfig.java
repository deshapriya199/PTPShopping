package com.san4n.ptpshopping.config;

import com.san4n.ptpshopping.filter.CustomLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

@Configuration
public class LoggingConfig {


    @Bean
    public AbstractRequestLoggingFilter requestLoggingFilter() {
        AbstractRequestLoggingFilter requestLoggingFilter = new CustomLoggingFilter();
        requestLoggingFilter.setIncludeClientInfo(true);
        //requestLoggingFilter.setIncludeHeaders(true);
        requestLoggingFilter.setIncludeQueryString(true);
        requestLoggingFilter.setIncludePayload(true);
        return requestLoggingFilter;
    }

}
