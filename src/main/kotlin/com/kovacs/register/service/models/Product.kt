package com.kovacs.register.service.models

import javax.persistence.*

@Entity
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0

    @Column
    var title = ""

    @Column
    var descProduct = ""

    @Column
    var image = ""

    @Column
    var price = 0
}