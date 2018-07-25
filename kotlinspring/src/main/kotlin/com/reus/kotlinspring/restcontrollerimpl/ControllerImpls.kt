package com.reus.kotlinspring.restcontrollerimpl

import com.reus.kotlinspring.ProductRepository
import com.reus.kotlinspring.model.Product
import com.reus.kotlinspring.restcontroller.ProductInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class Product: ProductInterface {

    @Autowired
    lateinit var productRepository: ProductRepository

    override fun retrieveProducts(): List<Product> {
        return productRepository.findAll()
    }

    override fun retrieveProduct(@PathVariable id: Int): Product {
        return productRepository.findById(id).get()
    }

    override fun createProduct(@RequestBody product: Product): Product {
        return productRepository.save(product)
    }

    override fun updateProduct(@RequestBody product: Product): Product {
        return productRepository.save(product)
    }

    override fun deleteProduct(@RequestBody product: Product): Product {
        productRepository.delete(product)
        return product
    }
}