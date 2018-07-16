package com.reus.restwsclient

import com.reus.restwsclient.model.Patient
import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.Entity
import javax.ws.rs.core.MediaType

private const val PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice"

private const val PATIENTS  = "/patients"

fun main(args: Array<String>) {
    // Get a patient
    val client: Client = ClientBuilder.newClient()
    val getTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 123)
    val patient: Patient = getTarget.request().get(Patient::class.java)
    println("Id: ${patient.id} -  Name: ${patient.name}")

    // Update a patient
    patient.name = "Alyne"
    val putTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS)
    val updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML))
    println("updateResponse: ${updateResponse.status}")
    updateResponse.close()

    // Create a patient
    val newPatient = Patient(1, "Stephany")
    val postTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS)
    val createdPatient = postTarget.request().post(Entity.entity(newPatient, MediaType.APPLICATION_XML), Patient::class.java)
    println("Created Patient - id: ${createdPatient.id} name: ${createdPatient.name}")

    // Delete a patient
    val deleteTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 124)
    val deleteResponse = deleteTarget.request().delete()
    println("deleteResponse: ${deleteResponse.status}")
    deleteResponse.close()
    client.close()
}
