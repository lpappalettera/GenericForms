package ui.start

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import moe.tlaster.precompose.viewmodel.ViewModel


class StartViewModel : ViewModel() {

    private val _viewState = MutableStateFlow(StartState())
    val viewState = _viewState.asStateFlow()

    fun onUsernameChanged(username: String) {
        _viewState.update { state -> state.copy(username = username) }
    }

    fun onPasswordChanged(password: String) {
        _viewState.update { state -> state.copy(password = password) }
    }
}