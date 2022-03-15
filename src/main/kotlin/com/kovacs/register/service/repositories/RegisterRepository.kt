package com.kovacs.register.service.repositories

import com.kovacs.register.service.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface RegisterRepository : JpaRepository<Product, Int> {
}