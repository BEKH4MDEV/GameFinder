package bekhamdev.gamefinder.di

import bekhamdev.gamefinder.data.repository.GamesRepositoryImpl
import bekhamdev.gamefinder.domain.repository.GamesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideGamesRepository(gamesRepositoryImpl: GamesRepositoryImpl): GamesRepository
}