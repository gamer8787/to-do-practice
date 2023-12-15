import java.util.List;


public class Test {

	public static void main(String[] args) {
		String name = "seok";
		int sequence = 3;
		String title = "코딩";
		
		Todo todo = new Todo(name,sequence,title);
		
		TodoDao dao = new TodoDao();
		
		
		todo = dao.getTodo((long) 1);
		System.out.println(todo);
		
		List<Todo> list = dao.getTodos();
		
		for(Todo todo1 : list) {
			System.out.println(todo1);
		}
		
		long id = 1;
		String type = "DOING";
		
		todo = new Todo(id, type);
		
		int updateCount = dao.updateTodo(todo);

		System.out.println(updateCount);
	}

}
