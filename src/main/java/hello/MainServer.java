package hello;

import static spark.Spark.*;




import java.util.LinkedList;
import java.util.List;



public class MainServer {

	final static Model model = new Model();

    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

		
        
        initializeModel();
		
        
		
		staticFileLocation("/static");
		
		REST controller = new REST(model); 
		controller.getLogin();
		controller.loginADM();
		
    }
	
    public static void initializeModel(){
		
    	model.addADM(new ADM("adm@adm.com", "12345", "João", "Fatec"));	
		model.addADM(new ADM("adm@adm.com", "12345", "João", "Fatec"));
		model.addUsuario(new Usuario("joao@gmail.com", "12345"));
		model.addUsuario(new Usuario("lilian@gmail.com", "12345"));
		model.addUsuario(new Usuario("giuliano@gmail.com", "12345"));
		
		
		//adicionando a questao 1
		
		
	}
	
}
