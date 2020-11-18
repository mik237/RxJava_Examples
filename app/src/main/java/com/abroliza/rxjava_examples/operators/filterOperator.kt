package com.abroliza.rxjava_examples.operators

import android.util.Log
import com.abroliza.rxjava_examples.model.User
import io.reactivex.rxjava3.core.Observable


private val usersList = listOf(
        User("ibrahim", 30, 12345),
        User("abc", 22, 12346),
        User("xyz", 18, 12347),
        User("david", 27, 12348),
        User("hoor", 1, 12349),
        User("nain", 37, 12350)
)

fun filterOperator(){
    val TAG = "filterOperator"

    val observable = Observable.fromIterable(usersList)
    observable.filter {
        it.age > 25
    }.subscribe({
        Log.d(TAG, "onNext: $it")
    },{
        Log.d(TAG, "onError: ${it.message}")
    },{
        Log.d(TAG, "onComplete")
    })
}