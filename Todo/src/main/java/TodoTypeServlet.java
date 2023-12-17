

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class TodoTypeServlet
 */
@WebServlet("/todotype")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String type = request.getParameter("type");
		System.out.println("id is " + id);
		System.out.println("type is " + type);
		TodoDao dao = new TodoDao();
		if(type.equals("TODO")) {
			dao.updateTodo(id, "DOING");
		}
		else if(type.equals("DOING")) {
			dao.updateTodo(id, "DONE");
		}
		else {
			dao.deleteTodo(id);
		}
		Todo todo = dao.getTodo(id);
		   
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(todo);
        
        response.setContentType("application/json; charset=UTF-8"); 
        PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
