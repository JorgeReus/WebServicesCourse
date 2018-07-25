package com.reus.kotlinspring.restcontroller

import com.reus.kotlinspring.model.Product
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@RequestMapping("/productService")
interface ProductInterface {
    @RequestMapping("/products", method = [RequestMethod.GET])
    fun retrieveProducts(): List<Product>

    @RequestMapping("/products/{id}", method = [RequestMethod.GET])
    fun retrieveProduct(id: Int): Product

    @RequestMapping("/products", method = [RequestMethod.POST])
    fun createProduct(product: Product): Product

    @RequestMapping("/products", method = [RequestMethod.PUT])
    fun updateProduct(product: Product): Product

    @RequestMapping("/products", method = [RequestMethod.DELETE])
    fun deleteProduct(product: Product): Product
}