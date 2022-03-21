package com.kovacs.register.service.repositories

import com.kovacs.register.service.models.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface RegisterRepository : JpaRepository <Product, Int>  {

    @Query("SELECT p FROM Product AS p WHERE p.title like %?1% or p.desc_product like %?1%")
    fun search(s: String, pageable: Pageable): List<Product>

    @Query("SELECT COUNT(p) FROM Product AS p WHERE p.title like %?1% or p.desc_product like %?1%", countQuery = "*")
    fun countSearch(s: String): Int

    @Query("SELECT p FROM Product AS p WHERE p.id = ?1")
    fun getPriceById(id: Int): Product

    @Query("SELECT SUM(p.price) FROM Product AS p WHERE p.id BETWEEN ?1 AND ?2")
    fun getSumPriceInterval(origin: Int, bound: Int): String
}
