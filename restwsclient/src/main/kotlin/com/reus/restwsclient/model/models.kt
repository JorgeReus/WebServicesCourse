package com.reus.restwsclient.model

import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name="Patient")
data class Patient (var id: Long, var name: String)