package com.abroliza.rxjava_examples.operators

import android.util.Log
import io.reactivex.rxjava3.core.Observable

//observer as lambda operator
fun rangeOperator(){
    val TAG = "rangeOperator"
    val observable = Observable.range(1, 15)
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