package plause.appengine.test;

import java.util.Properties;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SystemServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");

        Properties props = System.getProperties();

        for (String property : props.stringPropertyNames()) {
            resp.getWriter().println(property + "=" + props.getProperty(property));
        }
    }
}
