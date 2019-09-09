package com.samsad.demorest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("samsad")
public class Samsad {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMail() {
        return "samsadch@gmail.com!";
    }

}
