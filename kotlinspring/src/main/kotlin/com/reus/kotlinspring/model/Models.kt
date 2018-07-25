package com.reus.kotlinspring.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Product (@Id var id: Int?,
                    var name: String,
                    var description: String,
                    var price: Int?)