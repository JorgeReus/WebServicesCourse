package com.reus.restws

import com.reus.restws.model.Passenger
import org.springframework.stereotype.Service
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.Response

@Service
open class PassengerServiceImpl : PassengerService {

    private val passengers: MutableList<Passenger> = ArrayList()
    private var currentId = 1

    init {
        passengers.add(Passenger(currentId++, "Reus"))
        passengers.add(Passenger(currentId++, "Alyne"))
    }

    override fun retrievePassengers(start: Int, size: Int):
            List<Passenger> {
        println("Start: $start - Size: $size")
        return passengers
    }

    override fun addPassenger(firstName: String, lastName: String, agent: String, headers: HttpHeaders): Response {
        val newPassenger = Passenger(currentId++, "$firstName $lastName")
        passengers.add(newPassenger)
        println("$newPassenger Agent: $agent")
        println("Headers \n")
        headers.requestHeaders.forEach      {
            (key, value) -> println("$key : $value")
        }
        println("Cookies: \n")
        headers.cookies.forEach {
            (name, cookie) -> println("$name : ${cookie.value}")
        }
        return Response.ok(newPassenger).build()
    }
}