package com.abroliza.rxjava_examples.operators

import android.util.Log
import io.reactivex.rxjava3.core.Observable

fun repeatOperator(){
    val TAG = "repeatOperator"
    //emit 1, 2, 3 and repeat this emission two times
    val observable = Observable.just(1,2,3).repeat(2)
    observable.subscribe(
            {
                Log.d(TAG, "onNext: $it")
            },
            {
                Log.d(TAG, "onError: ${it.message}")
            },
            {
                Log.d(TAG, "onComplete: ")
            }
    )
}