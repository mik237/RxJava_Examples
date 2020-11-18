package com.abroliza.rxjava_examples.operators

import android.util.Log
import com.abroliza.rxjava_examples.model.User
import com.abroliza.rxjava_examples.model.UserProfile
import io.reactivex.rxjava3.core.Observable


private val usersList = listOf(
        User("ibrahim", 30, 1),
        User("abc", 22, 2),
        User("xyz", 18, 3),
        User("david", 27, 4),
        User("hoor", 1, 5),
        User("hoor", 1, 6),
        User("hoor", 1, 7),
        User("hoor", 1, 8),
        User("nain", 37, 9)
)

private val usersProfile = listOf(
        UserProfile("ibrahim1", 30, 1, ""),
        UserProfile("ibrahim2", 30, 1, ""),

        UserProfile("abc", 22, 2, ""),
        UserProfile("xyz", 18, 3, ""),
        UserProfile("david", 27, 4, ""),
        UserProfile("hoor", 1, 5, ""),
        UserProfile("hoor", 1, 6, ""),
        UserProfile("hoor", 1, 7, ""),
        UserProfile("hoor", 1, 8, ""),
        UserProfile("nain", 37, 9, "")
)

fun flatMapOperator(){
    val TAG = "flatMapOperator"

    val observable = Observable.fromIterable(usersList)
    observable.filter {
        it.id <= 1
    }.flatMap {
        getUserProfile(it.id)
    }.subscribe({
        Log.d(TAG, "onNext: $it")
            },{
        Log.d(TAG, "onError: ${it.message}")
            },{
        Log.d(TAG, "onComplete:")
            })
}


fun getUserProfile(id : Int) : Observable<UserProfile>{
    return Observable.fromIterable(usersProfile).filter {
        it.id == id
    }
}