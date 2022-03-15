package com.kovacs.register.service.controllers

import com.kovacs.register.service.models.Product
import com.kovacs.register.service.repositories.RegisterRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class RegisterController (private val registerRepository: RegisterRepository) {

    @GetMapping("/products/frontend")
    fun frontend(): ResponseEntity<List<Product>>{
        return ResponseEntity.ok(this.registerRepository.findAll())
    }
}