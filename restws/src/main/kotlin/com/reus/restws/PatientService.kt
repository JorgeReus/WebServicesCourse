package com.reus.restws

import com.reus.restws.model.Patient
import javax.ws.rs.*
import javax.ws.rs.core.Response

@Path("/patientservice")
interface PatientService {

    @Path("/patients")
    @GET
    fun getPatients(): MutableList<Patient>

    @Path("/patients/{id}")
    @GET
    fun getPatient(@PathParam(value = "id") id: Long): Patient?

    @Path("/patients")
    @POST
    fun createPatient(patient: Patient): Response

    @Path("/patients")
    @PUT
    fun updatePatient(patient: Patient): Response

    @Path("/patients/{id}")
    @DELETE
    fun deletePatient(@PathParam(value = "id")id: Long): Response

}