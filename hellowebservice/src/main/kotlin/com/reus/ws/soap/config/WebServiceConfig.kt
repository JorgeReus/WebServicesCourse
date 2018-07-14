package com.reus.ws.soap.config

import com.reus.ws.soap.HelloWsKT
import org.apache.cxf.Bus
import org.apache.cxf.jaxws.EndpointImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.ws.Endpoint

@Configuration
open class WebServiceConfig {

    @Autowired
    private lateinit var bus : Bus

    @Bean
    open fun endPoint () : Endpoint {
        var endpointImpl = EndpointImpl(bus, HelloWsKT())
        endpointImpl.publish("/hello")
        return endpointImpl
    }
}