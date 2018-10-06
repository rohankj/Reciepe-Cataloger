package com.rohan.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(description = "Recipe Display", urlPatterns = { "/recipeServlet" })
public class RecipeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		saveRecipe(request, response);
	}
	
	protected void saveRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException
	{

		Map<String, String> recipes = null;
		String recipeName = request.getParameter("recipename");
		String recipeText = request.getParameter("area");
		String deleteRecipe = request.getParameter("delete");
		if((recipeName != null && !recipeName.isEmpty()) || (deleteRecipe != null && !deleteRecipe.isEmpty())) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			 session = request.getSession(true);
			 session.setMaxInactiveInterval(15*60);
			 recipes = new HashMap<String,String>();
			 session.setAttribute("recipesList", recipes);
			 
		}
		recipes = (Map<String, String>) session.getAttribute("recipesList");
		if(recipes == null) recipes = new HashMap<String,String>();
		if(recipeName != null && !recipeName.isEmpty() && recipeText != null) recipes.put(recipeName, recipeText);
		if(deleteRecipe != null && !deleteRecipe.isEmpty()) {
			recipes.remove(deleteRecipe);
		}
		session.setAttribute("recipesList", recipes);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
