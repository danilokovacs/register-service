package com.kovacs.register.service.repositories

import com.kovacs.register.service.models.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RegisterRepository : JpaRepository<Product, Int> {

    @Query("SELECT * FROM PRODUCT WHERE title like %?1%", nativeQuery = true)
    fun search(s: String): List<Product>

}