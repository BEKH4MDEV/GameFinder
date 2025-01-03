package bekhamdev.gamefinder.domain.repository

import bekhamdev.gamefinder.domain.model.GameModel
import bekhamdev.gamefinder.domain.model.SingleGameModel

interface GamesRepository {
    suspend fun getGames(): List<GameModel>?
    suspend fun getGameById(id: Int): SingleGameModel?
}