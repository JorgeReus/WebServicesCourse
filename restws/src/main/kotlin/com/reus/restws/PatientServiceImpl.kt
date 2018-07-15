package com.reus.restws

import com.reus.restws.model.Patient
import org.springframework.stereotype.Service
import javax.validation.constraints.Null
import javax.ws.rs.core.Response

@Service
open class PatientServiceImpl: PatientService {

    var results: MutableMap<Long, Patient> = HashMap()
    var currentId:Long = 123

    init {
        results[currentId] = Patient(currentId, "Reus")
    }

    override fun getPatients(): MutableList<Patient> = results.map { it.value }.toMutableList()

    override fun getPatient(id: Long): Patient? = results[id]

    override fun createPatient(patient: Patient): Response {
        patient.id = ++currentId
        results[patient.id] = patient
        return Response.ok(patient).build()
    }

    override fun updatePatient(patient: Patient): Response {
        val response: Response
        if(results[patient.id] != null){
            results[patient.id] = patient
            response = Response.ok(patient).build()
        } else {
            response = Response.notModified().build()
        }
        return response
    }

    override fun deletePatient(id: Long): Response {
        val response: Response
        if(results[id] != null){
            response = Response.ok(results.remove(id)).build()
        } else {
            response = Response.notModified().build()
        }
        return response
    }
}