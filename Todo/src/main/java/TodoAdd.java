

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoAdd
 */
@WebServlet("/todoadd")
public class TodoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDao dao = new TodoDao();
		request.setCharacterEncoding("UTF-8");
		String title =request.getParameter("title");
		String name =request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		String result = String.format("title : %s name : %s sequence : %d", title,name,sequence);
		System.out.println(result);
		
		Todo todo = new Todo(name, sequence, title);
		dao.addTodo(todo);
		response.sendRedirect("/Todo/main");
		
	}

}
