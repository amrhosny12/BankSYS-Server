package com.OnlineBanking.api;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.net.URI;
import java.util.List;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.OnlineBanking.config.AuthTokenGenerator;
import com.OnlineBanking.config.Secure;
import com.OnlineBanking.entities.Customers;
import com.OnlineBanking.services.CustomerService;
import com.OnlineBanking.services.SecurityUtil;
import com.OnlineBanking.services.SessionService;

//-- CLASS URL - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer

@Path("/customer")
public class CustomerAPI {
	
	final static Logger logger = Logger.getLogger(CustomerAPI.class);
	
	@Context
	private UriInfo uriInfo;
	
	@Context 
	HttpServletRequest request;
	
	private SecurityUtil securityUtil = new SecurityUtil();
	private SessionService sessionService = new SessionService();
	private AuthTokenGenerator tokenGenerator = new AuthTokenGenerator();
	
	// Look into encoding user password going into the database withing hash code (lecture 92 suggestion)
	// use Apache sheild or Java EE security API to secure login (lecture 108)
	
	//-- API url for testing
	//-- GET - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/get/all
	@GET
	@Path("get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customers> getAllCust(){
		return CustomerService.getAllCust();
	}
	
	//-- API url for testing
	//-- GET - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/get/profile/{cis}
	@GET
	@Secure
	@Path("get/profile/{cis}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustByCIS(@PathParam("cis") int cis) {
		Customers cust = CustomerService.getCustByCIS(cis);
		logger.info("GET Logs");
		if (cust == null) {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		return Response.ok().entity(cust).build();
	}

	//-- API url for testing
	//-- GET - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/get/{ssn}
	@GET
	@Path("get/{ssn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customers getCustBySSN(@PathParam("ssn") int ssn) {
		return CustomerService.getCustBySSN(ssn);
	}
	
	//-- API url for testing
	//-- GET - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/login
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response loginCust(@FormParam("username") String username, @FormParam("pw") String pw) {
		try {
			authenticateUser(username, securityUtil.encodeText(pw));
			String token = tokenGenerator.getToken(username, pw, uriInfo);
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("password", securityUtil.encodeText(pw));
			sessionService.CreateSession(session.getId(), (String)session.getAttribute("username"), (String)session.getAttribute("password"), token);
			return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
			
		}catch (Exception e) {
			return Response.status(UNAUTHORIZED).build();
		}
	}
	

	//-- API url for testing
	//-- POST - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCustomer(JsonObject json) {
		
		Customers cust = new Customers (json.getString("FirstName"), json.getString("LastName"), json.getString("UserName"), 
										securityUtil.encodeText(json.getString("Password")),json.getString("UserType"));

		CustomerService.insertCust(cust);
		
		return Response.created(URI.create(uriInfo.getAbsolutePath() + "/" 
				+ cust.getCIS().toString())).build();
		
		
	}
	
	
	
	
	// --------------------------------------------------------------------- </API> --------------------------------------------------------------------- //
	
	// use security API to add another layer of security to this
		private void authenticateUser(String username, String pw) {

			Customers cust = CustomerService.loginCust(username, pw);
			if(cust == null) {
				throw new SecurityException("Invalid Credientals");
			}
		}
	
	
}
