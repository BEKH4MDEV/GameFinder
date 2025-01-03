package bekhamdev.gamefinder.data.remote.dto.games

data class Rating(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)