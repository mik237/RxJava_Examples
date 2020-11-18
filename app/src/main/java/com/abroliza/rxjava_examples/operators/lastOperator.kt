package com.abroliza.rxjava_examples.operators

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import com.abroliza.rxjava_examples.model.User


private val usersList = listOf(
        User("ibrahim", 30, 12345),
        User("abc", 22, 12346),
        User("xyz", 18, 12347),
        User("david", 27, 12348),
        User("hoor", 1, 12349),
        User("nain", 37, 12350)
)

private val emptyList = emptyList<User>()

fun lastOperator(){
    val TAG = "lastOperator"

    val observable = Observable.fromIterable(usersList) // print last user(nain, 37, 12350)
//    val observable = Observable.fromIterable(emptyList)   // print default user value
    observable
//            .last(User("default", 0,0))
//            .lastElement()  //returning Maybe<> observable which may or may not have value
            .lastOrError()    //returning Single<> observable which has only single value to emit.(last or error)
            .subscribe({
                Log.d(TAG, "onNext: $it")
            },{
                Log.d(TAG, "onError: ${it.message}")
            })
}