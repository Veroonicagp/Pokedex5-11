package com.example.pokedex.data.local

import com.example.pokedex.data.remote.Pokemon

fun Pokemon.toLocal():PokemonEntity =
    PokemonEntity(
        id=this.id,
        name = this.nombre,
        height = this.height,
        weight = this.weight
    )


fun List<Pokemon>.toLocal():List<PokemonEntity>{
    return this.map{p -> p.toLocal()}
}

fun PokemonEntity.toExternal(): Pokemon{
    return Pokemon(
        id = this.id,
        nombre = this.name,
        height = this.height,
        weight = this.weight
    )

}

fun List<PokemonEntity>.toExternal():List<Pokemon> = map(PokemonEntity::toExternal)