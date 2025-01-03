package bekhamdev.gamefinder.di

import bekhamdev.gamefinder.data.remote.Constants.API_GAMES_URL
import bekhamdev.gamefinder.data.remote.api.ApiGames
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_GAMES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}