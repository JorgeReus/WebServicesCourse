package com.reus.ws.soap

import javax.jws.WebMethod
import javax.jws.WebService

@WebService
open class HelloWsKT {

    @WebMethod
    fun hello () : String {
        return "hello"
    }
}