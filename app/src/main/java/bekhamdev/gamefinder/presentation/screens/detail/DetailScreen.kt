package bekhamdev.gamefinder.presentation.screens.detail

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import bekhamdev.gamefinder.presentation.components.MainImage
import bekhamdev.gamefinder.presentation.components.MainTopBar
import bekhamdev.gamefinder.presentation.components.MetaWebsite
import bekhamdev.gamefinder.presentation.components.ReviewCard

@Composable
fun DetailScreen(
    id: Int,
    detailViewModel: DetailViewModel = hiltViewModel(),
    comeBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        detailViewModel.getGameById(id)
    }

    val name = detailViewModel.state.name

    Scaffold(
        topBar = {
            MainTopBar(
                title = name,
                showBackButton = true,
                onClickBackButton = {
                    comeBack()
                }
            )
        },
        modifier = Modifier
            .fillMaxSize()
    ) {
        ContentDetailScreen(
            paddingValues = it,
            detailViewModel = detailViewModel
        )
    }
}

@Composable
fun ContentDetailScreen(
    paddingValues: PaddingValues,
    detailViewModel: DetailViewModel
) {

    val image = detailViewModel.state.backgroundImage
    val website = detailViewModel.state.website
    val metacritic = detailViewModel.state.metacritic
    val description = detailViewModel.state.descriptionRaw

    Column(
        modifier = Modifier
            .padding(paddingValues)

    ) {
        MainImage(
            imageUrl = image
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 10.dp)
        ) {
            MetaWebsite(url = website)
            ReviewCard(metaScore = metacritic)
        }

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Text(
                text = description,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .padding(bottom = 10.dp)
            )

        }

    }
}