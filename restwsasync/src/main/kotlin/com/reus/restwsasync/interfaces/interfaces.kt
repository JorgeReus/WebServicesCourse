package com.reus.restwsasync.interfaces

import com.reus.restwsasync.model.CheckList
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.container.AsyncResponse
import javax.ws.rs.container.Suspended

@Path("/checkprocessingservice")
interface CheckProcessor {

    @Path("/checks")
    @POST
    fun processChecks(@Suspended response: AsyncResponse, checkList: CheckList)
}