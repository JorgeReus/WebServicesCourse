package com.reus.restws

import com.reus.restws.model.Passenger
import javax.ws.rs.*
import javax.ws.rs.core.Context
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.Response

@Path("/passengerservice")
@Consumes("application/xml,application/json,application/x-www-form-urlencoded")
@Produces("application/xml,application/json")
interface PassengerService {

    @Path("/passengers")
    @GET
    fun retrievePassengers(@QueryParam("start")start: Int, @QueryParam("size")size: Int): List<Passenger>

    @Path("/passengers")
    @POST
    fun addPassenger(@FormParam("firstName")firstName: String,
                     @FormParam("lastName")lastName: String,
                     @HeaderParam("agent") agent: String,
                     @Context headers: HttpHeaders): Response

}