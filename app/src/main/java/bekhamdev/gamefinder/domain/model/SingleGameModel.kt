package bekhamdev.gamefinder.domain.model

data class SingleGameModel(
    val name: String,
    val descriptionRaw: String,
    val metacritic: Int,
    val website: String,
    val backgroundImage: String
)
