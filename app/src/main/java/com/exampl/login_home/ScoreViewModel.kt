package com.exampl.login_home
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class ScoreViewModel:ViewModel() {
    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> = _scoreB


//    var scoreA : Int = 0
//    var scoreB : Int = 0

    fun incrementSkorA() {
        _scoreA.value = (_scoreA.value ?: 0) + 1
    }
    fun incrementSkorB() {
        _scoreB.value = (_scoreB.value ?: 0) + 1
    }

    fun resetSkor() {
        _scoreA.value = 0
        _scoreB.value = 0
    }

}