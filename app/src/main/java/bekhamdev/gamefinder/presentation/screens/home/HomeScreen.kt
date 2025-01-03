package bekhamdev.gamefinder.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import bekhamdev.gamefinder.domain.model.GameModel
import bekhamdev.gamefinder.presentation.components.CardGame
import bekhamdev.gamefinder.presentation.components.MainTopBar

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (Int) -> Unit
) {
    val games by homeViewModel.filteredGames.collectAsState()

    Scaffold(
        topBar = {
            MainTopBar(
                title = "API GAMES",
                onClickBackButton = {},
                filterGames = { homeViewModel.filterGames(it) }
            )
        }
    ) {
        ContentHomeScreen(
            paddingValues = it,
            homeViewModel = homeViewModel,
            navigateToDetail = navigateToDetail,
            games = games
        )
    }

}


@Composable
fun ContentHomeScreen(
    homeViewModel: HomeViewModel,
    paddingValues: PaddingValues,
    navigateToDetail: (Int) -> Unit,
    games: List<GameModel>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        items(games) { game ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                CardGame(
                    game = game
                ) {
                    navigateToDetail(game.id)
                }

                Text(
                    text = game.name,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}