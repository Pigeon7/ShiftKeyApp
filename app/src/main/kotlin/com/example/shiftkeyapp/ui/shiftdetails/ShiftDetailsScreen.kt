package com.example.shiftkeyapp.ui.shiftdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shiftkeyapp.repository.api.data.response.*
import com.example.shiftkeyapp.ui.common.ErrorMessage
import com.example.shiftkeyapp.ui.common.LoadingIndicator

@Composable
fun ShiftDetailsScreen(
    navController: NavController? = null,
    viewModel: ShiftDetailsViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()


    when (uiState.value) {
        is ShiftDetailsViewModel.ShiftDetailsUiState.Loading -> LoadingIndicator()
        is ShiftDetailsViewModel.ShiftDetailsUiState.Success -> {
            ShiftDetails(
                shift = (uiState.value as ShiftDetailsViewModel.ShiftDetailsUiState.Success).shifts
            )
        }
        is ShiftDetailsViewModel.ShiftDetailsUiState.Error -> {
            ErrorMessage((uiState.value as ShiftDetailsViewModel.ShiftDetailsUiState.Error).message)
        }
    }
}

@Composable
fun ShiftDetails(
    shift: Shift
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.TopStart
    ) {
        Column {
            Text(
                text = shift.shiftKind,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Text(
                    text = "Start: ${shift.normalizedStartDateTime}",
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "End: ${shift.normalizedEndDateTime}",
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Timezone: ${shift.timezone}",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Premium: ${shift.premiumRate}",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Covid: ${shift.isCovid}",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Within distance: ${shift.withinDistance}",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Facility: ${shift.facilityType.name}",
                color = Color(shift.facilityType.color.toColorInt()),
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Skill: ${shift.skill.name}",
                color = Color(shift.skill.color.toColorInt()),
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Localized speciality: ${shift.localizedSpecialty.name}",
                color = Color(shift.localizedSpecialty.specialty.color.toColorInt()),
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
fun DetailsPreview() {
    ShiftDetails(
        Shift(
            isCovid = true,
            endTime = "2021-12-12",
            facilityType = FacilityType(
                color = "#888888",
                id = 1,
                name = "testFacility"
            ),
            localizedSpecialty = LocalizedSpecialty(
                abbreviation = "testAbbreviation",
                id = 1,
                name = "testName",
                specialty = Specialty(
                    abbreviation = "testAbbreviation",
                    color = "#888888",
                    id = 1,
                    name = "testName"
                ),
                specialtyId = 1,
                stateId = 1,
            ),
            normalizedEndDateTime = "2021-12-12",
            normalizedStartDateTime = "2021-12-12",
            premiumRate = true,
            shiftId = 1,
            shiftKind = "testShiftKind",
            skill = Skill(
                color = "#888888",
                id = 1,
                name = "testName"
            ),
            startTime = "2021-12-12",
            timezone = "Central",
            withinDistance = 1
        )
    )
}