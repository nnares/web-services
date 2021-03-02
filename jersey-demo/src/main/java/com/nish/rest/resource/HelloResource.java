package com.nish.rest.resource;

import com.nish.rest.model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/")
public class HelloResource {

    @GET
    @Path("/hello")
    public String sayHello() {
        return "Hello, I am a text!";
    }

    @GET
    @Path("/sample")
    public String test() {
        return "/sample POST";
    }

    // runtime content negotiation
    @POST
    @Path("/sample")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response runtime_content_negotiation(Message message, @Context Request request) {

        List<Variant> vs = Variant.mediaTypes(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_XML_TYPE).build();
        Variant variant = request.selectVariant(vs);

        if (variant == null) {
            return Response.serverError().status(Response.Status.NOT_ACCEPTABLE).build();
        }

        MediaType requestedMediaType =  variant.getMediaType();
        if(requestedMediaType.isCompatible(MediaType.APPLICATION_JSON_TYPE)){
            System.out.println("Data Receive in JSON format");
            System.out.println("message - " + message);
            return Response.ok().build();
        }else{
            System.out.println("Data Receive in XML format");
            System.out.println("message - " + message);
            return Response.ok().build();
        }
    }


}


