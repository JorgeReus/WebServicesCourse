package com.reus.restws.exception

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
open class PatientBusinessExceptionMapper: ExceptionMapper<PatientBussinessException> {
    override fun toResponse(exception: PatientBussinessException?): Response {
        val message = "{\"status\":\"error\", \"message\":\"Try Again Later\"}"
        return Response.serverError().entity(message).type(MediaType.APPLICATION_JSON).build()
    }
}