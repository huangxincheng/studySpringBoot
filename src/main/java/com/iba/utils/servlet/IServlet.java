package com.iba.utils.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet(name = "iServlet", urlPatterns = "/iServlet")
public class IServlet extends HttpServlet{

	private static final long serialVersionUID = 3691943354716623633L;
	
	private static final Logger logger = LoggerFactory.getLogger(IServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("enter iServlet ...");
		resp.getWriter().write("iServlet return ...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
