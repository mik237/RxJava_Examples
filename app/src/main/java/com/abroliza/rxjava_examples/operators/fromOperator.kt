package com.abroliza.rxjava_examples.operators

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun fromOperator(){
    val TAG = "fromOperator"
    val list1 = mutableListOf<Int>(1,2,3,4,5,6)
    val list2 = mutableListOf<Int>(10,20,30,40,50,60)

    val observable = Observable.fromArray(list1, list2)
    val observer = object : Observer<List<Int>>{
        override fun onComplete() {
            Log.d(TAG, "onComplete: ")
        }

        override fun onSubscribe(d: Disposable?) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onNext(t: List<Int>?) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable?) {
            Log.d(TAG, "onError: ${e?.message}")
        }
    }

    observable.subscribe(observer)
}