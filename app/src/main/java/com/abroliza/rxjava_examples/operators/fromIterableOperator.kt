package com.abroliza.rxjava_examples.operators

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun fromIterableOperator(){
    val TAG = "fromIterableOperator"
    val list = mutableListOf(1,2,3,4,5,6,7)
    val observable = Observable.fromIterable(list)
    val observer = object : Observer<Int>{
        override fun onComplete() {
            Log.d(TAG, "onComplete: ")
        }

        override fun onSubscribe(d: Disposable?) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onNext(t: Int?) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable?) {
            Log.d(TAG, "onError: ")
        }
    }
    observable.subscribe(observer)
}