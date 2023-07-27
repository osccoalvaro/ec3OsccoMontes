package com.alvaro.ec3_osccomontesalvaro.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvaro.ec3_osccomontesalvaro.data.repository.SimpsonRepository
import com.alvaro.ec3_osccomontesalvaro.data.repository.SimpsonServiceResult
import com.alvaro.ec3_osccomontesalvaro.model.Simpson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SimpsonListViewModel: ViewModel() {

    val notes: MutableLiveData<List<Simpson>> = MutableLiveData<List<Simpson>>()
    val repository = SimpsonRepository()

    fun getNotesFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getNotes()
            when(response) {
                is SimpsonServiceResult.Success -> {
                    notes.postValue(response.data.docs)
                }
                is SimpsonServiceResult.Error -> {
                    //
                }
            }
        }
    }

}