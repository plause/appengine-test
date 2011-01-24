package plause.appengine.test;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ContextServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();

        out.format("method:               %s\n", req.getMethod());
        out.format("protocol:             %s\n", req.getProtocol());
        out.format("content type:         %s\n", req.getContentType());
        out.format("querystring:          %s\n", req.getQueryString());
        out.format("character encoding:   %s\n", req.getCharacterEncoding());
        out.format("content length:       %s\n", req.getContentLength());
        out.format("requested session id: %s\n", req.getRequestedSessionId());
        out.format("scheme:               %s\n", req.getScheme());
        out.format("locale:               %s\n", req.getLocale());
        out.format("local name:           %s\n", req.getLocalName());
        out.format("local addr:           %s\n", req.getLocalAddr());
        out.format("local port:           %s\n", req.getLocalPort());
        out.format("server name:          %s\n", req.getServerName());
        out.format("server port:          %s\n", req.getServerPort());
        out.format("remote addr:          %s\n", req.getRemoteAddr());
        out.format("remote host:          %s\n", req.getRemoteHost());
        out.format("remote port:          %s\n", req.getRemotePort());
        out.format("servlet path:         %s\n", req.getServletPath());
        out.format("context path:         %s\n", req.getContextPath());
        out.format("request uri:          %s\n", req.getRequestURI());
        out.format("request url:          %s\n", req.getRequestURL());
        out.format("path info:            %s\n", req.getPathInfo());
        out.format("path translated:      %s\n", req.getPathTranslated());

        Cookie[] cookies = req.getCookies();

        out.println("\nCookies:");

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.format("  %s:%s\n", cookie.getName(), cookie.getValue());
            }
        }

        Enumeration<?> locales = req.getLocales();

        out.println("\nLocales:");

        while (locales.hasMoreElements()) {
            out.format("  %s\n", locales.nextElement());
        }

        Enumeration<?> headerNames = req.getHeaderNames();

        out.println("\nHeaders:");

        for (String headerName; headerNames.hasMoreElements();) {
            headerName = (String) headerNames.nextElement();
            out.format("  %s:%s\n", headerName, req.getHeader(headerName));
        }

        Enumeration<?> parameterNames = req.getParameterNames();

        out.println("\nParameters:");

        for (String parameterName; parameterNames.hasMoreElements();) {
            parameterName = (String) parameterNames.nextElement();
            out.format("  %s:%s\n", parameterName, req.getParameter(parameterName));
        }
    }
}
