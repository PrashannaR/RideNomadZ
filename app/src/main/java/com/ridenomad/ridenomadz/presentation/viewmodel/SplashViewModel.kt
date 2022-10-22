package com.ridenomad.ridenomadz.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridenomad.ridenomadz.data.DataStoreRepository
import com.ridenomad.ridenomadz.presentation.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {
    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Screens.OnBoarding.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect() { completed ->
                if (completed) {
                    _startDestination.value = Screens.Home.route
                } else {
                    _startDestination.value = Screens.OnBoarding.route
                }

            }
            _isLoading.value = false
        }
    }
}