package com.amqo.databindingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {

    private val fruitNames: List<String> = listOf(
        "Apple", "Banana", "Orange", "Kiwi", "Grapes", "Fig",
        "Pear", "Strawberry", "Gooseberry", "Raspberry"
    )

    private val currentRandomFruitNameMutable = MutableLiveData<String>()
    val currentRandomFruitName: LiveData<String>
        get() = currentRandomFruitNameMutable

    init {
        currentRandomFruitNameMutable.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName() {
        currentRandomFruitNameMutable.value = getRandomFruitName()
    }
}