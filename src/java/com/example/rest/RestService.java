package com.example.rest;

import com.example.rest.repository.UserRepositoryLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Niki
 */
@Path("service")
@Stateless
public class RestService {

    @EJB
    private UserRepositoryLocal userRepository;

    @GET
    @Path("getuser/{email}/{username}/{firstname}/{lastname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getUser(
            @PathParam(value = "email") String email,
            @PathParam(value = "username") String userName,
            @PathParam(value = "firstname") String firstName,
            @PathParam(value = "lastname") String lastName) {
        return getResponse(userRepository.getUser(email, userName, firstName, lastName));
    }
    
    @GET
    @Path("getuser/{email}/{username}/{firstname}/{lastname}/cors")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getUserCors(
            @PathParam(value = "email") String email,
            @PathParam(value = "username") String userName,
            @PathParam(value = "firstname") String firstName,
            @PathParam(value = "lastname") String lastName) {
        return getCORSResponse(userRepository.getUser(email, userName, firstName, lastName));
    }

    private Response getCORSResponse(Object object) {
        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(object)
                .build();

    }

    private Response getResponse(Object object) {
        return Response
                .status(Response.Status.OK)
                .entity(object)
                .build();
    }
}
