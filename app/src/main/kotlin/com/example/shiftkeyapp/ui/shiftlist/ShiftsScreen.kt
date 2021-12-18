package com.example.shiftkeyapp.ui.shiftlist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shiftkeyapp.repository.api.data.response.Shift
import com.example.shiftkeyapp.ui.shiftlist.ShiftListViewModel.ShiftsUiState

@Composable
fun ShiftsScreen(
    navController: NavController?,
    viewModel: ShiftListViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    )
    {
        when (uiState.value) {
            is ShiftsUiState.Loading -> LoadingIndicator()
            is ShiftsUiState.Success -> {
                ShiftsList((uiState.value as ShiftsUiState.Success).shifts)
            }
            is ShiftsUiState.Error -> {
                Error((uiState.value as ShiftsUiState.Error).message)
            }
        }
    }
}

@Composable
fun ShiftsList(
    shiftsList: List<Shift>
) {
    LazyColumn(contentPadding = PaddingValues(8.dp)) {
        items(shiftsList.size) {
            ShiftItem(shift = shiftsList[it])
        }
    }
}

@Composable
fun ShiftItem(
    shift: Shift
) {
    val color = remember { shift.facilityType.color }
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .shadow(5.dp, RoundedCornerShape(15.dp))
            .background(Color(color.toColorInt()))
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .padding(10.dp)
        ) {
            ShiftItemContent(
                shiftKindTxt = shift.shiftKind,
                normalizedStartDateTimeTxt = shift.normalizedStartDateTime,
                normalizedEndDateTimeTxt = shift.normalizedEndDateTime,
                timezoneTxt = shift.timezone,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun ShiftItemContent(
    shiftKindTxt: String,
    normalizedStartDateTimeTxt: String,
    normalizedEndDateTimeTxt: String,
    timezoneTxt: String
) {
    val shiftKind = remember { shiftKindTxt }
    val normalizedStartDateTime = remember { normalizedStartDateTimeTxt }
    val normalizedEndDateTime = remember { normalizedEndDateTimeTxt }
    val timezone = remember { timezoneTxt }

    Column {
        Text(
            text = shiftKind,
            fontStyle = FontStyle.Italic,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Start: $normalizedStartDateTime",
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "End: $normalizedEndDateTime",
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Timezone: $timezone",
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun Error(
    message: String
) {
    Text(
        text = "ERROR OCCURRED: $message",
        textAlign = TextAlign.Center,
        color = Color.Red,
        fontSize = 30.sp
    )
}

@Composable
fun LoadingIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.size(40.dp),
        color = Color.Green,
        strokeWidth = 5.dp,
    )
}

@Preview
@Composable
fun Preview() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        ShiftItemContent(
            "test",
            "test",
            "test",
            "test",
        )
    }
}