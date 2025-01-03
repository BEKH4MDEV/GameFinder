package bekhamdev.gamefinder.di

import bekhamdev.gamefinder.data.remote.api.ApiGames
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideApiGame(retrofit: Retrofit): ApiGames {
        return retrofit.create(ApiGames::class.java)
    }

}