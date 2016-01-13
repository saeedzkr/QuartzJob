package org.tamin.services.service;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/UserService")
public class UserService {

    final Logger logger = Logger.getLogger("ServiceLogger");


    @GET
    @Path("/users")
    public String getUsers(@QueryParam("username") String user)
    {
        System.out.println("hereeeeeeeeeeeeeeeeeee");
        logger.log(Level.INFO , "getuser");
        return "hello " + user;
    }


    @GET
    @Path("/credit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response responseCredit(@QueryParam("username") String user ,@QueryParam("password") String password) {
        logger.log(Level.INFO , "responseCredit");
        String output = "Prameter1: " + user + "\nParameter2: " + password;
        return Response.status(200).entity(output).build();
    }
        //todo ok
//    @GET
//    @Path("/remain")
//    @Produces(MediaType.APPLICATION_JSON)
//    public org.entity.Credit remain(@QueryParam("username") String user ,@QueryParam("password") String password)
//
//    {
//        logger.log(Level.INFO , "remain");
//        Credit credit = new Credit("saeed" , "fatoldsun" , 100 );
////        String output = "Prameter1: " + user + "\nParameter2: " + password;
////        return Response.status(200).entity(output).build();
//
//        return credit;
//    }

}