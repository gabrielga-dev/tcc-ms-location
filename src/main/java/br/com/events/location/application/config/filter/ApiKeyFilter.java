package br.com.events.location.application.config.filter;

import br.com.events.location.application.config.filter.exception.InvalidApiKeyException;
import br.com.events.location.application.config.filter.exception.NoApiKeyReceivedException;
import br.com.events.location.util.FilterExceptionUtil;
import br.com.events.location.util.FilteredRoutesUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * This class makes the request filtering so only consumers with allowed api-key can access this microservice's
 * features
 *
 * @author Gabriel Guimarães de Almeida
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    @Value("${valid.api.keys}")
    private List<String> validApiKeys;

    @Value("${api.key.header}")
    private String apiKeyHeader;

    private final FilteredRoutesUtil filteredRoutesUtil;
    private final FilterExceptionUtil filterExceptionUtil;

    @Override
    protected boolean shouldNotFilter(final HttpServletRequest request) {
        var path = request.getRequestURI();
        return filteredRoutesUtil.isRouteNotProtected(path);
    }

    @Override
    public void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse response, FilterChain filterChain)
        throws IOException, ServletException {

        log.info("Filtering by api-key");

        var apiKeyOpt = Optional.ofNullable(httpRequest.getHeader(apiKeyHeader));

        if (apiKeyOpt.isPresent()){
            if (validApiKeys.contains(apiKeyOpt.get())) {
                filterChain.doFilter(httpRequest, response);
            } else {
                filterExceptionUtil.setResponseError(response, new InvalidApiKeyException());
            }
        } else {
            filterExceptionUtil.setResponseError(response, new NoApiKeyReceivedException());
        }
    }
}
