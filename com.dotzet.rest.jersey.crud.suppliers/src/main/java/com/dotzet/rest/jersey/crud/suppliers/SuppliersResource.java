package com.dotzet.rest.jersey.crud.suppliers;

import java.io.IOException;
import java.io.StringReader;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PATCH;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.dotzet.rest.jersey.crud.suppliers.Supplier;
import com.dotzet.rest.jersey.crud.suppliers.SupplierDAO;
 
import javax.json.JsonObjectBuilder;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.log4j.Logger;



// Will map the resource to the URL providers
@Path("/suppliers")
public class SuppliersResource {
	
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    final static Logger logger = Logger.getLogger(SuppliersResource.class);
	
	// Returns an ACK if the Suppliers Service is up and running
    // Allows to type api/suppliers/ping
	@GET
    @Path("ping")
    public String getServerTime() {
		String myDate = new Date().toString();
		if(logger.isDebugEnabled()){
			logger.debug("Ping received --> ACK sent with date: " + myDate + ".");
		}
    	return "ACK - received ping on " + myDate + ". Suppliers Service is up and running";
    }
    
	// Creates a supplier with the given JSON
	// Allows to type api/suppliers/create
	@PUT
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String newSupplier(String JSONSupplier) throws IOException {
		JsonObjectBuilder myAnswer = Json.createObjectBuilder();
		if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.create: JSONObjectBuilder created.");
		}
		JsonReader myJSONReader = Json.createReader(new StringReader(JSONSupplier));
		if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.create: JSONReader created.");
		}
    	JsonObject myJSONObject = myJSONReader.readObject();
    	if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.create: JSONObject read from JSONReader.");
		}
    	Supplier supplier = new Supplier();
    	if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.create: Supplier created.");
		}
    	supplier.setVat(myJSONObject.getString("vat"));
    	supplier.setCompanyName(myJSONObject.getString("companyName"));
    	supplier.setAddress(myJSONObject.getString("address"));
    	supplier.setCity(myJSONObject.getString("city"));
    	supplier.setRegion(myJSONObject.getString("region"));
    	supplier.setPostalCode(myJSONObject.getString("postalCode"));
    	supplier.setCountry(myJSONObject.getString("country"));
    	supplier.setPhone(myJSONObject.getString("phone"));
    	supplier.setFax(myJSONObject.getString("fax"));
    	supplier.setHomePage(myJSONObject.getString("homePage"));
    	if(logger.isDebugEnabled()){
			logger.debug("Supplier with vat: " + supplier.getVat() + " created.");
		}
    	SupplierDAO mySupplierDAO = new SupplierDAO();
    	if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.create: SupplierDAO created.");
		}
    	mySupplierDAO.insertSupplier(supplier);
    	if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.create: Supplier insertion lainched.");
		}
    	myAnswer.add("message","The Supplier: " + myJSONObject.toString() + " insertion has finished. CHECK previous logs for possible errors");
    	if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.create: Answer created, just befor being sent.");
		}
    	return myAnswer.build().toString();
    }
	
	// Selects the supplier with vat written in the url down
    // Allows to type api/suppliers/read/{vat}
    @GET
	@Path("read/{vat}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSupplier(@PathParam("vat") String vat) {
    	SupplierDAO mySupplierDAO = new SupplierDAO();
    	if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.read: ( " + vat + ") SupplierDAO created.");
		}
    	Supplier mySupplier = mySupplierDAO.getSupplier(vat);
    	if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.read: ( " + vat + ") supplier has been gotten.");
		}
    	JsonObjectBuilder myAnswer = Json.createObjectBuilder();
    	if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.read: ( " + vat + ") myAnswer created.");
		}
    	myAnswer.add("vat", mySupplier.getVat());
    	myAnswer.add("companyName", mySupplier.getCompanyName());
    	myAnswer.add("address", mySupplier.getAddress());
    	myAnswer.add("city", mySupplier.getCity());
    	myAnswer.add("region", mySupplier.getRegion());
    	myAnswer.add("postalCode", mySupplier.getPostalCode());
    	myAnswer.add("country", mySupplier.getCountry());
    	myAnswer.add("phone", mySupplier.getPhone());
    	myAnswer.add("fax", mySupplier.getFax());
    	myAnswer.add("homePage", mySupplier.getHomePage());
    	if(logger.isDebugEnabled()){
			logger.debug("SuppliersResource.read: ( " + vat + ") Answer created, just before being sent.");
		}
    	return myAnswer.build().toString();	
    }
	
	// Updates the supplier with vat in the json
    // Allows to type api/suppliers/update
 	@PATCH
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateSupplier(String JSONSupplier) throws IOException {
 		JsonObjectBuilder myAnswer = Json.createObjectBuilder();
 		JsonReader myJSONReader = Json.createReader(new StringReader(JSONSupplier));
     	JsonObject myJSONObject = myJSONReader.readObject();
     	Supplier supplier = new Supplier();
     	supplier.setVat(myJSONObject.getString("vat"));
     	supplier.setCompanyName(myJSONObject.getString("companyName"));
     	supplier.setAddress(myJSONObject.getString("address"));
     	supplier.setCity(myJSONObject.getString("city"));
     	supplier.setRegion(myJSONObject.getString("region"));
     	supplier.setPostalCode(myJSONObject.getString("postalCode"));
     	supplier.setCountry(myJSONObject.getString("country"));
     	supplier.setPhone(myJSONObject.getString("phone"));
     	supplier.setFax(myJSONObject.getString("fax"));
     	supplier.setHomePage(myJSONObject.getString("homePage"));
     	SupplierDAO mySupplierDAO = new SupplierDAO();
     	mySupplierDAO.updateSupplier(supplier);
     	myAnswer.add("message", "The Supplier: " + myJSONObject.toString() + " update has finished. CHECK previous logs for possible errors");
     	return myAnswer.build().toString();
    }
    
 	// Deletes the supplier with vat written in the url down
    // Allows to type api/suppliers/delete/{vat}
    @DELETE
	@Path("delete/{vat}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteSupplier(@PathParam("vat") String vat) {
    	JsonObjectBuilder myAnswer = Json.createObjectBuilder();
    	SupplierDAO mySupplierDAO = new SupplierDAO();
    	mySupplierDAO.deleteSupplier(vat);
    	myAnswer.add("message", "The Supplier with vat: " + vat + " deletion has finished. CHECK previous logs for possible errors");
     	return myAnswer.build().toString();
    }
    
    // Selects all the suppliers 
    // Allows to type api/suppliers/list
    @GET
	@Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSupplier() {
    	SupplierDAO mySupplierDAO = new SupplierDAO();
    	List<Supplier> mySuppliers = mySupplierDAO.getAll();
    	JsonArrayBuilder myAnswer = Json.createArrayBuilder();
    	for (Supplier mySupplier: mySuppliers) {
    		JsonObjectBuilder myJSON = Json.createObjectBuilder();
    		myJSON.add("vat", mySupplier.getVat());
    		myJSON.add("companyName", mySupplier.getCompanyName());
    		myJSON.add("address", mySupplier.getAddress());
    		myJSON.add("city", mySupplier.getCity());
    		myJSON.add("region", mySupplier.getRegion());
    		myJSON.add("postalCode", mySupplier.getPostalCode());
    		myJSON.add("country", mySupplier.getCountry());
    		myJSON.add("phone", mySupplier.getPhone());
    		myJSON.add("fax", mySupplier.getFax());
    		myJSON.add("homePage", mySupplier.getHomePage());
    		myAnswer.add(myJSON);
    	}
    	return myAnswer.build().toString();
    }
    
    // Deletes the supplier with vat written in the url down
    // Allows to type api/suppliers/deleteAll
    @DELETE
	@Path("deleteAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteAllSuppliers() {
    	JsonObjectBuilder myAnswer = Json.createObjectBuilder();
    	SupplierDAO mySupplierDAO = new SupplierDAO();
    	mySupplierDAO.deleteAll();
    	myAnswer.add("message", "All suppliers deletion has finished. CHECK previous logs for possible errors");
     	return myAnswer.build().toString();
    }
}