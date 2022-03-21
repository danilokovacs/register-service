package com.kovacs.register.service.seeders

import com.kovacs.register.service.models.Product
import com.kovacs.register.service.repositories.RegisterRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class DataSeeder(private val registerRepository: RegisterRepository): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        for (i in 1..10){
            val product = Product()
            val image = Random.nextInt(10000)

            product.title = "Title #" + i
            product.desc_product = "Description #" + (i + 1)
            product.image = "https://picsum.photos/id/${image}/200/300"
            product.price = Random.nextInt(10,100)
            this.registerRepository.save(product)
        }
    }
}