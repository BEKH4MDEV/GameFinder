package bekhamdev.gamefinder.presentation.model


data class GameStateModel(
    val name: String = "",
    val descriptionRaw: String = "",
    val metacritic: Int = 0,
    val website: String = "",
    val backgroundImage: String = ""
)