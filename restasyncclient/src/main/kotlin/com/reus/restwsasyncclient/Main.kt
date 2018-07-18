package com.reus.restwsasyncclient

import com.reus.restwsasyncclient.model.CheckList
import java.util.concurrent.ExecutionException
import java.util.concurrent.Future
import javax.ws.rs.BadRequestException
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.Entity
import javax.ws.rs.core.MediaType

fun main(args: Array<String>) {
	val client = ClientBuilder.newClient()
	val target = client.target("http://localhost:8080/restasync/services/checkprocessingservice/checks")
	val invoker = target.request().async()
	val response: Future<Boolean> = invoker.post(Entity.entity(CheckList(), MediaType.APPLICATION_XML), Boolean::class.java)
    // Poll the service
    try {
    	println(response.get())
    } catch (e: ExecutionException) {
    	if (e.cause is BadRequestException) {
			println("Send a good list of checks")
		}
    }
}