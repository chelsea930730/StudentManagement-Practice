import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class StudentRepositoryImpl implements StudentRepository {
    private final String url = "jdbc:mysql://localhost:3306/students";
    private final String username = "student";
    private final String password = "1234";

    public List<Student> findAll() {
    	List<Student> result = new ArrayList<>();
        try {
        	System.out.println("데이터베이스 연결");
    		Connection connection = DriverManager.getConnection(url, username, password);
    		System.out.println("데이터베이스 연결 성공!!");
    		
    		// insert sql 작성
    		String sql = "select * from students";
    		
    		// sql 실행
    		PreparedStatement statement = connection.prepareStatement(sql);
    		ResultSet resultSet = statement.executeQuery();
    		
    		while (resultSet.next()) {
    			result.add(new Student(
    					resultSet.getInt("id"),
    					resultSet.getString("name"),
    					resultSet.getString("major")));
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return result;
    }

    public Student findById(int id) {
    	try {
        	System.out.println("데이터베이스 연결");
    		Connection connection = DriverManager.getConnection(url, username, password);
    		System.out.println("데이터베이스 연결 성공!!");
    		
    		// insert sql 작성
    		String sql = "select * from students where id = ?";
    		
    		// sql 실행
    		PreparedStatement statement = connection.prepareStatement(sql);
    		statement.setInt(1, id);
    		
    		ResultSet resultSet = statement.executeQuery();
    		
    		if (resultSet.next()) {
    			return new Student(
    					resultSet.getInt("id"),
    					resultSet.getString("name"),
    					resultSet.getString("major"));
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        return null;
    }

    public void save(Student student) {
    	// Connection 연결
    	try {
    		System.out.println("데이터베이스 연결");
    		Connection connection = DriverManager.getConnection(url, username, password);
    		System.out.println("데이터베이스 연결 성공!!");
    		
    		// insert sql 작성
    		String sql = "insert into students (name, major) values (?, ?)";
    		
    		// parameter 세팅
    		PreparedStatement statement = connection.prepareStatement(sql);
    		statement.setString(1, student.getName());
    		statement.setString(2, student.getMajor());
    		
    		// sql 실행
    		statement.executeUpdate();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    public void update(int id, Student updatedStudent) {
    	try {
    		System.out.println("데이터베이스 연결");
    		Connection connection = DriverManager.getConnection(url, username, password);
    		System.out.println("데이터베이스 연결 성공!!");
    		
    		// insert sql 작성
    		String sql = "update students set name = ?, major = ? where id = ?";
    		
    		// parameter 세팅
    		PreparedStatement statement = connection.prepareStatement(sql);
    		statement.setString(1, updatedStudent.getName());
    		statement.setString(2, updatedStudent.getMajor());
    		statement.setInt(3, id);
    		
    		// sql 실행
    		statement.executeUpdate();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    public void delete(int id) {
    	try {
    		System.out.println("데이터베이스 연결");
    		Connection connection = DriverManager.getConnection(url, username, password);
    		System.out.println("데이터베이스 연결 성공!!");
    		
    		// insert sql 작성
    		String sql = "delete from students where id = ?";
    		
    		// parameter 세팅
    		PreparedStatement statement = connection.prepareStatement(sql);
    		statement.setInt(1, id);
    		
    		// sql 실행
    		statement.executeUpdate();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void main(String[] args) {
    	StudentRepository repository = new StudentRepositoryImpl();
//    	Student student = new Student(0, "홍길동", "스프링");
    	
//    	repository.save(student);
    	
    	List<Student> students = repository.findAll();
    	for (Student student : students) {
    		System.out.println(student);
		}
	}
}












