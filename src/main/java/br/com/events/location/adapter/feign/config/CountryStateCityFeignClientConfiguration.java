package br.com.events.location.adapter.feign.config;

import br.com.events.location.adapter.feign.country_state_city.CountryStateCityFeignClient;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * This class makes all needed configuration for {@link CountryStateCityFeignClient} feign client
 *
 * @author Gabriel Guimarães de Almeida
 */
public class CountryStateCityFeignClientConfiguration extends BaseFeignClientConfig{

    @Value("${feign.client.country.state.city.header.name}")
    private String headerName;

    @Value("${feign.client.country.state.city.header.value}")
    private String headerValue;


    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header(headerName, headerValue);
    }
}
