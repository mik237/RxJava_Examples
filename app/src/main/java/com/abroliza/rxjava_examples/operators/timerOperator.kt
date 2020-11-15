package com.abroliza.rxjava_examples.operators

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit


fun timerOperator(){
    val TAG = "timerOperator"

    //suppose after some delay, we want to perform some task. so timer is emiting once and then complete.
    val observable = Observable.timer(1, TimeUnit.SECONDS)

    val observer = object : Observer<Long>{
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
    }

    observable.subscribe(observer)
}