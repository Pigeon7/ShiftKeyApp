package com.example.shiftkeyapp.ui.shiftlist

import androidx.lifecycle.ViewModel
import com.example.shiftkeyapp.repository.api.data.response.DailyShifts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ShiftListViewModel @Inject constructor(

) : ViewModel() {

    private val _shifts = MutableStateFlow<List<DailyShifts>>(mutableListOf())

    var shifts: StateFlow<List<DailyShifts>> = _shifts

}