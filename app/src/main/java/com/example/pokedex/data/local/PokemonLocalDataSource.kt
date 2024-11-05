package com.example.pokedex.data.local

import com.example.pokedex.data.remote.Pokemon
import kotlinx.coroutines.flow.Flow


//contrato

interface PokemonLocalDataSource {

    suspend fun insert(pokemons:List<Pokemon>)
    suspend fun readAll():List<Pokemon>
    fun observeAll(): Flow<List<Pokemon>>


}