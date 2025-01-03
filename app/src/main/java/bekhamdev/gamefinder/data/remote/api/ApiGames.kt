package bekhamdev.gamefinder.data.remote.api

import retrofit2.http.GET
import bekhamdev.gamefinder.data.remote.Constants.API_KEY_GAMES
import bekhamdev.gamefinder.data.remote.dto.game.GameDto
import bekhamdev.gamefinder.data.remote.dto.games.GamesDto
import retrofit2.Response
import retrofit2.http.Path

interface ApiGames {
    @GET("games?key=$API_KEY_GAMES")
    suspend fun getGames(): Response<GamesDto>

    @GET("games/{id}?key=$API_KEY_GAMES")
    suspend fun getGameById(@Path(value = "id") id: Int): Response<GameDto>
}