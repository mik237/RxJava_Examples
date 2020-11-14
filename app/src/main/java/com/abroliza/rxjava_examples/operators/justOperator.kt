package com.abroliza.rxjava_examples.operators

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

object justOperator {
    val TAG = "justOperator:"
    //just operator can take maximum 10 values, create an observable and emit those values.
    val justObservable = Observable.just(1, 2, 3,4, 5)

    val justObserver = object : Observer<Int> {
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
            Log.d(TAG, "onError: ${e?.message}")
        }
    }
    
    //emit only once. onNext of observer will be called once with list of values
    val justArrayObservable = Observable.just(mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12))
    val justArrayObserver = object : Observer<List<Int>>{
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
            Log.d(TAG, "onError: ")
        }
    }
}