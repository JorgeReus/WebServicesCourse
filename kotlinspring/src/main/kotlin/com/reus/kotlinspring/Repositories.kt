package com.reus.kotlinspring

import com.reus.kotlinspring.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Int?>