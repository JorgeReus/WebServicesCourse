package com.reus.restwsasyncclient.model

import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
data class Check(var checkNumber: String = "", var accountNumber: String = "", var amount: Double = 0.0)

@XmlRootElement
data class CheckList(var checks: List<Check> = listOf(Check()))