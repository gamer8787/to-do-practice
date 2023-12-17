import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	
	public int deleteTodo(Long id) {
		int deleteCount = 0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "delete from todo where id = ?";
		try(Connection conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql);){				
			ps.setLong(1,id);
			deleteCount = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deleteCount;
	}
	
	public List<Todo> getTodos(){
		List<Todo> list = new ArrayList<>();
	
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}	catch (ClassNotFoundException e	) {
			e.printStackTrace();
		}
		
		String sql = "select * from todo order by id";
		try(Connection conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			try (ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Long id = rs.getLong("id");
					String name = rs.getString("name");
					String regDate = rs.getString("regDate");
					int sequence = rs.getInt("sequence");
					String title = rs.getString("title");
					String type = rs.getString("type");
									
					Todo todo = new Todo(id,name,regDate,sequence,title,type);
					list.add(todo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int addTodo(Todo todo) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO todo (name, sequence, title) VALUES (?,?,?)";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser,dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql);
				){
			ps.setString(1,todo.getName());
			ps.setInt(2,todo.getSequence());
			ps.setString(3,todo.getTitle());
			insertCount = ps.executeUpdate();	
		}catch (Exception e) {
			e.printStackTrace();
		}

		return insertCount;
	}
	
	public Todo getTodo(Long id) {	
		Todo todo = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "SELECT * FROM todo WHERE id = ?";
		try(Connection conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()){	
				if(rs.next()) {
					Long id2 = rs.getLong("id");
					String name = rs.getString("name");
					String regDate = rs.getString("regDate");
					int sequence = rs.getInt("sequence");
					String title = rs.getString("title");
					String type = rs.getString("type");
					todo = new Todo(id2, name,regDate,sequence,title,type);
				}
			}catch (Exception e) {
			e.printStackTrace();
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return todo;
	}
	//해당 id를 가진 것의 type을 바꿔줌 
	public int updateTodo(Long id, String type) {
		int updateCount = 0;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "update todo set type = ? where id = ?";
		try(Connection conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1,type);
			ps.setLong(2, id);
			updateCount = ps.executeUpdate();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return updateCount;
	}
}
