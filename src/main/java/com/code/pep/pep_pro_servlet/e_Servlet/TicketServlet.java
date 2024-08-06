package com.code.pep.pep_pro_servlet.e_Servlet;

import com.code.pep.pep_pro_servlet.d_Service.TicketService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {

    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString();

        // Формирование ответа - Начало
        Long fligthId = Long.valueOf(req.getParameter("flightId"));
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.write("<h1>Tickets %s</h1>".formatted(time));
            out.write("<ul>");
            ticketService.getAllByFlightId(fligthId).forEach(
                    f -> out.write("""
                            <li>
                             Место: %s
                            </li>""".formatted(
                            f.getSeat_no()
                    )));
            out.write("</ul>");
        }
        // Формирование ответа - Конец
    }
}
