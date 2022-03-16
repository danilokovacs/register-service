package com.kovacs.register.service.controllers

import com.kovacs.register.service.dtos.PaginatedResponse
import com.kovacs.register.service.models.Product
import com.kovacs.register.service.repositories.RegisterRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
class RegisterController (private val registerRepository: RegisterRepository) {

    @GetMapping("/products/frontend")
    fun frontend(): ResponseEntity<List<Product>>{
        return ResponseEntity.ok(this.registerRepository.findAll())
    }

    @GetMapping("/products/backend")
    fun backend(
        @RequestParam("s", defaultValue = "") s:String,
        @RequestParam("sort", defaultValue = "") sort:String,
        @RequestParam("page", defaultValue = "1") page: Int
    ): ResponseEntity<Any>{
        var direction = Sort.unsorted()

        if (sort == "asc"){
            direction = Sort.by(Sort.Direction.ASC,"price")
        }else if (sort == "desc"){
            direction = Sort.by(Sort.Direction.DESC, "price")
        }

        val perPage = 10
        val total = this.registerRepository.countSearch(s)

        return ResponseEntity.ok(
            PaginatedResponse(
                data = this.registerRepository.search(s, PageRequest.of(page - 1, perPage, direction)),
                total,
                page,
                last_page = total / perPage
            )
        )
    }

    @PostMapping("/products/register")
    fun registerProduct(
        @RequestBody json: Product
    ): ResponseEntity<Any> {
        val newProduct = registerRepository.save(json)
        return ResponseEntity.ok(newProduct)
    }
}
