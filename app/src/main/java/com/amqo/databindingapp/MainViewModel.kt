package com.amqo.databindingapp

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    @Bindable
    val editTextContent = MutableLiveData<String>()

    private val displayedEditTextContentMutable = MutableLiveData<String>()
    val displayedEditTextContent: LiveData<String>
        get() = displayedEditTextContentMutable

    val currentRandomFruitName: LiveData<String>
        get() = FakeRepository.currentRandomFruitName

    fun onChangeRandomFruitClick() = FakeRepository.changeCurrentRandomFruitName()

    fun onDisplayEditTextContentClick() {
        displayedEditTextContentMutable.value = editTextContent.value
    }

    fun onSelectRandomEditTextFruit() {
        displayedEditTextContentMutable.value = ""
        editTextContent.value = FakeRepository.getRandomFruitName()
    }
}