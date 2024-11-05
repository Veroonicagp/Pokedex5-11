package com.example.pokedex.data

import com.example.pokedex.data.local.PokemonLocalDataSource
import com.example.pokedex.data.remote.Pokemon
import com.example.pokedex.data.remote.PokemonListResponse
import com.example.pokedex.data.remote.PokemonRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultPokemonRepository
    @Inject constructor(
        private val remotedataSource: PokemonRemoteDataSource,
        private val localDataSource: PokemonLocalDataSource
    ):PokemonReepository {


    override suspend fun readAll(): PokemonListResponse {
        val pokemons = remotedataSource.readAll()
        return pokemons
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        refreshLocal()
        return localDataSource.observeAll()
    }

    private fun refreshLocal(){
        //
        Global.launch(Dispatchers.IO){
            val pokemonRemote = remotedataSource.readAll()
            localDataSource.insert(pokemonRemote)
        }

    }

    override suspend fun readOne(name: String): Pokemon {
        return remotedataSource.readOne(name)
    }
    override suspend fun readOne(id: Int): Pokemon {
        return remotedataSource.readOne(id)
    }

}