import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.doctor.medication.presentation.drugScreenViewModel.DrugScreenViewModel
import com.example.doctor.medication.presentation.drugsViewState
import com.example.doctor.medication.presentation.util.LoadingDialog
import com.example.doctor.medication.presentation.util.components.DrugCard
import com.example.doctor.medication.presentation.util.components.MyTopBar

@Composable
fun DrugsInfoScreen(
    viewModel: DrugScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    DrugsInfoContent(state = state)
}

@Composable
fun DrugsInfoContent(
    state: drugsViewState
) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        topBar = { MyTopBar(title = "Drug Info") }
    ) { paddingValues ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalItemSpacing = 9.dp,
            columns = StaggeredGridCells.Fixed(2)
        ) {
            items(state.druginfo) { druginfo ->
                DrugCard(druginfo = druginfo)
            }
        }
    }
}

@Preview
@Composable
fun DrugsInfoContentPreview() {
    DrugsInfoContent(state = drugsViewState())
}
