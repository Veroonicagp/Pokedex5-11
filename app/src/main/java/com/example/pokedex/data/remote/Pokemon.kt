package com.example.pokedex.data.remote

import java.time.Instant

data class Pokemon(
    val id: String,
    var nombre: String,
    val height: Int=0,
    val weight: Int =0

)