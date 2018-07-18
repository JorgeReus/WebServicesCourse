package com.reus.restwsasync.model
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
data class Check(var checkNumber: String, var accountNumber: String, var amount: Double)

@XmlRootElement
data class CheckList(var checks: List<Check>)