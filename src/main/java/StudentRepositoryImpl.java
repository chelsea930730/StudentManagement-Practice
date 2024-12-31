import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    
	
	private final List<Student> students = new ArrayList<>();
	private int nextId=1;
	
	@Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(int id) {
//    	foreach 방식:
    	for(Student student: students) {
    	if(student.getId()==id) {
    		return student;
    	}
    	}

//      for (int i=0;i < students.size();i++){
//    	   if (students.get(i).getId()==id) {
//    		   return students.get(i);
//    	   }
//       }
//    	람다표현식 기본 문법
//    	(매개변수)->{본문}
//    	Student result=null;
//    	students.forEach(student ->{
//    		if(student.getId()==id) {
//    			result=student;
//    			break;
//    			
//    		}
//    	});
       return null;
    }

    @Override
    public void save(Student student) {
    	student=new Student(nextId++, student.getName(),student.getMajor());
    	students.add(student);
    }

    @Override
    public void update(int id, Student updatedStudent) {
    	Student student = findById(id);
    	if(student !=null) {
    		student.setName(updatedStudent.getName());
    		student.setMajor(updatedStudent.getMajor());
    		
    	}
    }

    @Override
    public void delete(int id) {
    	for(int i=0; i < students.size(); i++) {
    		if(students.get(i).getId()==id) {
    			students.remove(i);
    			break;
    		}
    	}
//    	Student student = findById(id);
//    	students.remove(student);
    }
}
