package hello;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model{
	
	ObjectContainer students = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/students.db4o");
	
	
	public void addStudent(Student student){
		students.store(student);
	}
	
	public Student login(String email, String senha){
		Query query = students.query();
		query.constrain(Student.class);
	    ObjectSet<Student> allStudents = query.execute();
	    
	    for(Student student: allStudents){
	    	if(student.getUserName().equals(email) && student.getPassword().equals(senha)) return student;
	    }
	    
	    return null;
	}
	
}
