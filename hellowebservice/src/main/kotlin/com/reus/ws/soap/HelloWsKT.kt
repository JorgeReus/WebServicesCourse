package com.reus.ws.soap

import org.apache.cxf.feature.Features
import javax.jws.WebMethod
import javax.jws.WebService

@WebService
@Features(features = ["org.apache.cxf.feature.LoggingFeature"])
open class HelloWsKT {

    @WebMethod
    fun hello () : String {
        return "hello"
    }
}