package bekhamdev.gamefinder.presentation.screens.home
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bekhamdev.gamefinder.domain.model.GameModel
import bekhamdev.gamefinder.domain.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gamesRepository: GamesRepository
) : ViewModel() {

    private val _games: MutableStateFlow<List<GameModel>> = MutableStateFlow(emptyList())
    val games: StateFlow<List<GameModel>> = _games
    private val _filteredGames: MutableStateFlow<List<GameModel>> = MutableStateFlow(emptyList())
    val filteredGames = _filteredGames.asStateFlow()

    private var searchJob: Job? = null

    init {
        fetchGames()
    }

    private fun fetchGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = gamesRepository.getGames()
            _games.value = result ?: emptyList()
            _filteredGames.value = result ?: emptyList()
        }
    }

    fun filterGames(value: String) {
        searchJob?.cancel()
        if (value.isBlank()) {
            _filteredGames.value = _games.value
            return
        }
        searchJob = viewModelScope.launch {
            delay(300L)  // Añadimos un retraso de 300ms (puede ajustarse)
            _filteredGames.value = _games.value.filter {
                it.name.contains(value, ignoreCase = true)
            }
        }
    }
}