package com.example.shiftkeyapp.ui.shiftdetails

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.shiftkeyapp.common.Constants
import com.example.shiftkeyapp.repository.api.data.response.Shift
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ShiftDetailsViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
) : ViewModel() {

    private val _uiState = MutableStateFlow<ShiftDetailsUiState>(ShiftDetailsUiState.Loading)

    var uiState: StateFlow<ShiftDetailsUiState> = _uiState

    init {
        val cachedShift = sharedPreferences.getString(Constants.SP_KEY_SHIFT_DETAIL, "")
        if (cachedShift.isNullOrBlank()){
            _uiState.value = ShiftDetailsUiState.Error("Failed to load shift data")
        }
        try {
            _uiState.value = ShiftDetailsUiState.Success(gson.fromJson(cachedShift, Shift::class.java))
        } catch (ex: Exception){
            _uiState.value = ShiftDetailsUiState.Error(ex.message.toString())
        }
    }

    sealed class ShiftDetailsUiState {
        data class Success(val shifts: Shift) : ShiftDetailsUiState()
        data class Error(val message: String) : ShiftDetailsUiState()
        object Loading : ShiftDetailsUiState()
    }
}