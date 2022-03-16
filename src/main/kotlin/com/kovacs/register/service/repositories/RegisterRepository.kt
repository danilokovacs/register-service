package com.kovacs.register.service.repositories

import com.kovacs.register.service.models.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface RegisterRepository : JpaRepository <Product, Int>  {

    @Query("select p FROM Product p WHERE p.title like %?1% or p.descProduct like %?1%")
    fun search(s: String, pageable: Pageable): List<Product>

    @Query("select COUNT(p) FROM Product p WHERE p.title like %?1% or p.descProduct like %?1%", countQuery = "*")
    fun countSearch(s: String): Int
}
