package com.github.itdachen.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Description: 权限不足
 * Created by 王大宸 on 2022-09-23 16:41
 * Created with IntelliJ IDEA.
 */
@Component
public class FlyAccessDeniedExceptionHandler implements AccessDeniedHandler {
    private static final Logger logger = LoggerFactory.getLogger(FlyAccessDeniedExceptionHandler.class);
    private final ObjectMapper objectMapper;

    public FlyAccessDeniedExceptionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException {
        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString("没有权限，不允许访问"));
    }

}
