package plause.appengine.test;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/ms-office-word");
        resp.getOutputStream().write(new byte[] {1, 2, 3, 4});
    }
}
