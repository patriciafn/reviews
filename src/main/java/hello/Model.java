package hello;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model{
	
	ObjectContainer students = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/students.db4o");
	ObjectContainer questions = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/questions.db4o");
	ObjectContainer competencies = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/competencies.db4o");
	ObjectContainer institutions = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/institutions.db4o");
	ObjectContainer psychologists = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/psychologists.db4o");
	ObjectContainer adms = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/adms.db4o");
	

	
	public boolean addUsuario(Usuario student){
		
		if(isUserAvailable(student.getUserName())){
			students.store(student);
			students.commit();
			
			return true;
		}
		
		return false;
		
	}
	
	public boolean addADM(ADM adm){
		if(isADMUserAvailable(adm.getUserName())){
			

		    adms.store(adm);
		    adms.commit();
			
			return true;
		}
		
		return false;
	}
	
	public boolean isUserAvailable(String username){
		Query query = students.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> allStudents = query.execute();
	    
	    for(Usuario student:allStudents){
	    	if(student.getUserName().equals(username)) return false;
	    }
	    
	    return true;
	}
	
	public boolean isADMUserAvailable(String username){
		Query query = adms.query();
		query.constrain(ADM.class);
	    ObjectSet<ADM> allADMs = query.execute();
	    
	    for(ADM adm:allADMs){
	    	if(adm.getUserName().equals(username)) return false;
	    }
	    
	    return true;
	}
	

	public Usuario login(String username, String password){
		
		Query query = students.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> allStudents = query.execute();
		
	    
	    for(Usuario student:allStudents){
	    	if(student.getUserName().equals(username) && student.getPassword().equals(password)){
	    		
	    		return student;
	    	}
	    	
	    }
	    
	    return null;

	}
	
	public ADM loginADM(String username, String password){
		
		Query query = adms.query();
		query.constrain(ADM.class);
	    ObjectSet<ADM> allADMs = query.execute();
		
	    
	    for(ADM adm:allADMs){
	    	if(adm.getUserName().equals(username) && adm.getPassword().equals(password)){
	    		
	    		return adm;
	    	}
	    	
	    }
	    
	    return null;

	}
	
}
