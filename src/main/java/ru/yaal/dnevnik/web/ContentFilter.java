package ru.yaal.dnevnik.web;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import ru.yaal.dnevnik.domain.ExcelEntity;
import ru.yaal.dnevnik.service.DatabaseService;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/content.jsp")
public class ContentFilter implements Filter {
    private DatabaseService service;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext ac = (ApplicationContext) filterConfig.getServletContext()
                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        service = ac.getBean(DatabaseService.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<ExcelEntity> entities = service.getAllEntities();
        request.setAttribute("content", entities);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
