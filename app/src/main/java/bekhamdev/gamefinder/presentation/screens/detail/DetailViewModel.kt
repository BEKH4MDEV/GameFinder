package bekhamdev.gamefinder.presentation.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bekhamdev.gamefinder.domain.model.GameModel
import bekhamdev.gamefinder.domain.repository.GamesRepository
import bekhamdev.gamefinder.presentation.model.GameStateModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val gamesRepository: GamesRepository
) : ViewModel() {
    var state by mutableStateOf(GameStateModel())
        private set

    fun getGameById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = gamesRepository.getGameById(id)
            if (result != null) {
                state = state.copy(
                    name = result.name,
                    descriptionRaw = result.descriptionRaw,
                    metacritic = result.metacritic,
                    website = result.website,
                    backgroundImage = result.backgroundImage
                )
            }
        }
    }
}