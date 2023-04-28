package bob.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI();
        String requestId = httpServletRequest.getHeader("Request-Id");

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            logger.info("[LoggingFilter] request fail message:{}", e.getLocalizedMessage());
        } finally {
            stopWatch.stop();

            logger.debug("uri:{} requestId:{} status:{} elapsed:{}ms",
                    uri, requestId, ((HttpServletResponse) response).getStatus(), stopWatch.getLastTaskTimeMillis());
        }
    }
}
