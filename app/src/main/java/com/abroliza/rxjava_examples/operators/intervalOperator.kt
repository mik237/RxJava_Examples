package com.abroliza.rxjava_examples.operators

import android.util.Log
import com.abroliza.rxjava_examples.MainActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

fun intervalOperator1sec(){
    val TAG = "intervalOperator"
    //run on different thread
    val observable = Observable.interval(3, 1, TimeUnit.SECONDS).takeWhile {
        it <= 15 //will stop when condition is met
    }
    observable.subscribe(object : Observer<Long>{
        override fun onComplete() {
            Log.d(TAG, "onComplete: ")
        }

        override fun onSubscribe(d: Disposable?) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onNext(t: Long?) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable?) {
            Log.d(TAG, "onError: ${e?.message}")
        }
    })
}

fun intervalOperator2sec(){
    val TAG = "intervalOperator"
    val observable = Observable.interval(3, 2, TimeUnit.SECONDS)
    observable.subscribe(object : Observer<Long>{
        override fun onComplete() {
            Log.d(TAG, "onComplete: ")
        }

        override fun onSubscribe(d: Disposable?) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onNext(t: Long?) {
            Log.d(TAG, "onNext: $t")
        }

        override fun onError(e: Throwable?) {
            Log.d(TAG, "onError: ${e?.message}")
        }
    })
}