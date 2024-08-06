package com.code.pep.pep_pro_servlet.e_Servlet_Old;

import com.code.pep.pep_pro_servlet.d_Service_Old.FlightServiceOld;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@WebServlet("/flightsold")
public class FlightServletOld extends HttpServlet {

    private final FlightServiceOld flightService = FlightServiceOld.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString();

        // Формирование ответа - Начало
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.write("<h1>Flights %s</h1>" .formatted(time));
            out.write("<ul>");
            flightService.findAll().forEach(
                    f -> out.write("""
                            <li>
                             <a href="/ticketold?flightId=%d">%s</a>
                            </li>""".formatted(
                            f.getId(),
                            f.getDescription()
                    )));
            out.write("</ul>");
        }
        // Формирование ответа - Конец
    }
}
