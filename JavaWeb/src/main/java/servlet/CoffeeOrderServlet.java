package servlet;

import java.io.IOException;

import model.CoffeeOrder;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffeeOrder")
public class CoffeeOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//設定編碼
		resp.setContentType("text/html; charset=UTF-8");
		
		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String sugar = req.getParameter("sugar");
		
		if(type == null||size == null||sugar == null) {
			resp.getWriter().print("請輸入參數");
			return;
		} 
		CoffeeOrder coffeeOrder = new CoffeeOrder(type, size, sugar);
		//resp.getWriter().print(coffeeOrder.getPrice());
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_order.jsp");
		req.setAttribute("coffeeOrder", coffeeOrder);
		rd.forward(req, resp);		
	}
	
}
