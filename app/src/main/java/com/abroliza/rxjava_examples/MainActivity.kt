package com.abroliza.rxjava_examples

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.abroliza.rxjava_examples.operators.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        //justOperatorExample()
        //fromOperator()
        //fromIterableOperator()
        //rangeOperator()
        //repeatOperator()
        //intervalOperator1sec()
        //intervalOperator2sec()
        //intervalOperator()
        //timerOperator()
        //createOperator()
        //filterOperator()
        //lastOperator()
        //distinctOperator()
        //skipOperator()
        bufferOperator()
        //mapOperator()
    }

    private fun justOperatorExample() {
        justOperator.justObservable.subscribe(justOperator.justObserver)
        justOperator.justArrayObservable.subscribe(justOperator.justArrayObserver)
    }


    private fun intervalOperator(){
        val TAG = "intervalOperator"
        //run on different thread
        val observable = Observable.interval(1, 1, TimeUnit.SECONDS).takeWhile {
            it <= 15
        }
        observable.subscribe(object : Observer<Long> {
            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }

            override fun onSubscribe(d: Disposable?) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: Long?) {
                Log.d(TAG, "onNext: $t")
                runOnUiThread{
                    textView.text = "$t"
                }
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, "onError: ${e?.message}")
            }
        })
    }
}