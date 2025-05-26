package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Guestbook;

@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet{
	//記錄所有留言資料
	private static final List<Guestbook> guestbooks = new CopyOnWriteArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/guest_form.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = req.getParameter("message");
		
		Guestbook guestbook = new Guestbook(message);
		
		guestbooks.add(guestbook);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/guest_result.jsp");
		req.setAttribute("message", message); //本次留言
		req.setAttribute("guestbooks", guestbooks); //歷史留言
		rd.forward(req, resp);
	}

	
}
