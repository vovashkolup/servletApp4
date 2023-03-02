package com.example.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/updateNameById")
public class UpdateNameById extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id=request.getParameter("id");
        String name = request.getParameter("name");
        int sid=Integer.parseInt(id);
        EmployeeRepository.updateNameByID(sid,name);

        out.print(id+" id name was succesfully renamed to "+name);
        out.close();
    }

}
