package com.OnlineBanking.api;

import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.OnlineBanking.beans.Customers;
import com.OnlineBanking.services.CustomerService;


//-- CLASS URL - http://18.220.194.122:8085/OnlineBankingSystem/rest/Customer
@Path("/Customer")
public class CustomerAPI {
	
	//-- API url for testing
	//-- GET - http://18.220.194.122:8085/OnlineBankingSystem/rest/Customer/get/all
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customers> getAllCust(){
		return CustomerService.getAllCust();
	}

	//-- API url for testing
	//-- GET - http://18.220.194.122:8085/OnlineBankingSystem/rest/Customer/get/{ssn}
	@GET
	@Path("/get/{ssn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customers getCustBySSN(@PathParam("ssn") int ssn) {
		return CustomerService.getCustBySSN(ssn);
	}
	
	//-- API url for testing
	//-- GET - http://18.220.194.122:8085/OnlineBankingSystem/rest/Customer/get/{username}/{pw}	
	@GET
	@Path("/get/{username}/{pw}")
	@Produces(MediaType.APPLICATION_JSON)
	public Integer loginCust(@PathParam("username") String username, @PathParam("pw") String pw) {
		Integer CIS = null;
		CIS = CustomerService.loginCust(username, pw);
		return CIS;
	}
	
	
	
	
	
	
	
	
	
	
}
