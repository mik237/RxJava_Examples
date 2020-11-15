package com.abroliza.rxjava_examples.operators

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import java.lang.Exception

fun createOperator(){
    val TAG = "createOperator"

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    //operator to create observer with some custom logic.
    val observable = Observable.create(ObservableOnSubscribe<Int>{
        //it -> an emitter which can call methods on observer.
        try {
            for (i in list){
                it.onNext(i)
            }
            it.onComplete()
        }catch (e: Exception){
            it.onError(e)
        }
    })

    observable.filter {
        it % 2 == 0
    }.map {
        it*10
    }.subscribe({
        Log.d(TAG, "onNext: $it")
    },{
        Log.d(TAG, "onError: ${it.message}")
    },{
        Log.d(TAG, "onComplete")
    })
}