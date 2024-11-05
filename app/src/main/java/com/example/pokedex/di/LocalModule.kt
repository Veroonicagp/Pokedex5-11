package com.example.pokedex.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedex.data.DefaultPokemonRepository
import com.example.pokedex.data.PokemonReepository
import com.example.pokedex.data.local.PokemonDao
import com.example.pokedex.data.local.PokemonDataBase
import com.example.pokedex.data.local.PokemonLocalDataSource
import com.example.pokedex.data.local.PokemonLocalDatabase
import com.example.pokedex.data.remote.PokemonNetworkDataSource
import com.example.pokedex.data.remote.PokemonRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun providePokemonDataBase(@ApplicationContext context: Context): PokemonDataBase {
        val dataBase = Room.databaseBuilder(
            context,
            PokemonDataBase::class.java,
            "pokemon-db"
        )
        return  dataBase.build()
    }

    @Provides
    fun providedao(pokemonDataBase: PokemonDataBase):PokemonDao = pokemonDataBase.pokemonDao()
}

