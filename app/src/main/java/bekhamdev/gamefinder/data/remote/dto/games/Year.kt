package bekhamdev.gamefinder.data.remote.dto.games

data class Year(
    val count: Int,
    val decade: Int,
    val filter: String,
    val from: Int,
    val nofollow: Boolean,
    val to: Int,
    val years: List<YearX>
)