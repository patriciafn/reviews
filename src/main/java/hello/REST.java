package hello;



import static spark.Spark.get;
import static spark.Spark.post;


import java.io.UnsupportedEncodingException;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;


public class REST{
	
	private Model model;
	
	
	public REST(Model store){
		this.model = store;
	}
	
	
	public void getLogin(){
		
		get("/login/:username/:password", new Route() {
			@Override
            public Object handle(final Request request, final Response response){
	        	
	        	 
	        	 
	        	response.header("Access-Control-Allow-Origin", "*");
	        	 
	            
	            
	            try {
	            	Usuario student = model.login(request.params(":username"), request.params(":password"));
	            	
	            	if(student != null){
	            		
	            		JSONArray jsonResult = new JSONArray();
		         	    JSONObject jsonObj = new JSONObject();
		        		
		             	jsonResult.put(jsonObj);
		             	
		             	return jsonResult;
	            		
	            	} else {
	            		
	            		
	            		
	            	}
	            	
	            	
	             	
	        		} catch (JSONException e) {
	        				
	        			//e.printStackTrace();

	        		}
	         	    	
	
	            JSONArray jsonResult = new JSONArray();
         	    JSONObject jsonObj = new JSONObject();

        		jsonObj.put("ra", 0);
        		
        		
             	jsonResult.put(jsonObj);
             	
             	return jsonResult;
	            
	     	     
	         }
	         
	      });
			

	}
	
	
	public void loginADM(){
		
		post("/login/adm", new Route() {
			@Override
            public Object handle(final Request request, final Response response){
	        	
	           response.header("Access-Control-Allow-Origin", "*");

	        	
	        	
	        	
	           JSONObject json = new JSONObject(request.body());
	        	
	           String userName = json.getString("userName");
	           
	           String password = json.getString("password");
	           	
	           
         	    
	           try {
	        	   ADM adm = model.loginADM(userName, password);
	            	
	            	if(adm != null){
	            		
	            		JSONArray jsonResult = new JSONArray();
		         	    JSONObject jsonObj = new JSONObject();

		        		jsonObj.put("status", 1);
		        		jsonObj.put("userName", adm.getUserName());
		        		
		        		
		             	jsonResult.put(jsonObj);
		             	
		             	return jsonResult;
	            		
	            	} else {
	            		
	            		
	            		
	            	}
	            	
	            	
	             	
	        		} catch (JSONException e) {
	        				
	        			//e.printStackTrace();

	        		}
	         	    	
	
	            JSONArray jsonResult = new JSONArray();
        	    JSONObject jsonObj = new JSONObject();

        	    jsonObj.put("status", 0);
       		
       		
            	jsonResult.put(jsonObj);
            	
            	return jsonResult;
         	   
         	   
	        	
		   }
		});     

         
	}
		
}
