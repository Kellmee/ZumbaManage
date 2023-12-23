package com.zumba.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.zumba.dao.ParticipantDAO;
import com.zumba.model.Participant;

@WebServlet("/participant")
public class ParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ParticipantDAO participantDAO = new ParticipantDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Participant> participants = participantDAO.getAllParticipants();
        request.setAttribute("participants", participants);
        request.getRequestDispatcher("/participants.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String batchId = request.getParameter("batchId");
            String phone = request.getParameter("phone");

            Participant participant = new Participant();
            participant.setName(name);
            participant.setBatchId(Long.parseLong(batchId));
            participant.setPhoneNumber(phone);

            participantDAO.addParticipant(participant);

            response.sendRedirect("/success.html");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error processing request", e);
        }
    }
}
