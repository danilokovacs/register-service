package com.kovacs.register.service.repositories

import com.kovacs.register.service.models.Product
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RegisterRepository : JpaRepository<Product, Int> {

    @Query("select p FROM Product p WHERE p.title like %?1% or p.description like %?1%")
    fun search(s: String, sort: Sort): List<Product>

}