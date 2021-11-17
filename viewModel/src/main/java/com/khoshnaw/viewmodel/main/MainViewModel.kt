package com.khoshnaw.viewmodel.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khoshnaw.viewmodel.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
) : BaseViewModel<MainState, MainIntent>(application) {
    private val _state = MutableLiveData<MainState>()

    override val intents: Channel<MainIntent> = Channel()
    override val state: LiveData<MainState> = _state

}
