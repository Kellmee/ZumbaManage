package com.zumba.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.zumba.dao.BatchDAO;
import com.zumba.model.Batch;

@WebServlet("/batch")
public class BatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final BatchDAO batchDAO = new BatchDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Batch> batches = batchDAO.getAllBatches();
        request.setAttribute("batches", batches);
        request.getRequestDispatcher("/batches.jsp").forward(request, response);
    }

    
}
