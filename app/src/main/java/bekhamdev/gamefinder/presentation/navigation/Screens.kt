package bekhamdev.gamefinder.presentation.navigation

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Detail(
    val id: Int
)