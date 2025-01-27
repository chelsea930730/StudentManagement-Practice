import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
	
	private final List<Student> students=new ArrayList<>();
	private int nextId=1;
	
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {
    	student= new Student(nextId++, student.getName(),student.getMajor());
    	students.add(student);
    }

    @Override
    public void update(int id, Student updatedStudent) {

    }

    @Override
    public void delete(int id) {

    }
}
