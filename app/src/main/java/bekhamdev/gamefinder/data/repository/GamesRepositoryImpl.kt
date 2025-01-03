package bekhamdev.gamefinder.data.repository

import bekhamdev.gamefinder.data.remote.api.ApiGames
import bekhamdev.gamefinder.data.remote.dto.game.toSingleGameModel
import bekhamdev.gamefinder.data.remote.dto.games.toGameModel
import bekhamdev.gamefinder.domain.model.GameModel
import bekhamdev.gamefinder.domain.model.SingleGameModel
import bekhamdev.gamefinder.domain.repository.GamesRepository
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val apiGames: ApiGames
) : GamesRepository {
    override suspend fun getGames(): List<GameModel>? {
        val response = apiGames.getGames()
        if (response.isSuccessful) {
            return response.body()?.results?.map {
                it.toGameModel()
            }
        }
        return null
    }

    override suspend fun getGameById(id: Int): SingleGameModel? {
        val response = apiGames.getGameById(id)
        if (response.isSuccessful) {
            return response.body()?.toSingleGameModel()
        }
        return null
    }
}