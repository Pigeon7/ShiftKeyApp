package com.example.shiftkeyapp.ui.shiftlist

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftkeyapp.common.Constants.SP_KEY_SHIFT_DETAIL
import com.example.shiftkeyapp.repository.ShiftsRepo
import com.example.shiftkeyapp.repository.api.data.response.Shift
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShiftListViewModel @Inject constructor(
    private val shiftsRepo: ShiftsRepo,
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
) : ViewModel() {

    private val _uiState = MutableStateFlow<ShiftsUiState>(ShiftsUiState.Loading)

    var uiState: StateFlow<ShiftsUiState> = _uiState

    init {
        viewModelScope.launch {
            try {
                val result = shiftsRepo.getShifts(address = "Dallas, TX")
                _uiState.value = ShiftsUiState.Success(result.flatMap { it.shifts })
            } catch (ex: Exception) {
                _uiState.value = ShiftsUiState.Error(ex.message.toString())
            }
        }
    }

    fun cacheShiftOnClick(shift: Shift){
        val editor = sharedPreferences.edit()
        editor.putString(SP_KEY_SHIFT_DETAIL,  gson.toJson(shift))
        editor.apply()
    }

    sealed class ShiftsUiState {
        data class Success(val shifts: List<Shift>) : ShiftsUiState()
        data class Error(val message: String) : ShiftsUiState()
        object Loading : ShiftsUiState()
    }
}