package ua.edu.nuos.web_lab3_jakartaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.edu.nuos.web_lab3_jakartaee.model.Function;
import ua.edu.nuos.web_lab3_jakartaee.model.ListValue;
import ua.edu.nuos.web_lab3_jakartaee.model.Tabulation;

import java.io.IOException;

@WebServlet(name = "TabulationServlet", value = "/tabulation")
public class TabulationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double h = Double.parseDouble(request.getParameter("h"));

        Tabulation tabulation = new Tabulation(a, b, h, new Function());
        ListValue maxValue = tabulation.getMax();
        ListValue minValue = tabulation.getMin();

        request.setAttribute("tab", tabulation);
        request.setAttribute("maxValue", maxValue);
        request.setAttribute("minValue", minValue);
        request.getRequestDispatcher("/tabulation.jsp").forward(request, response);
    }
}
