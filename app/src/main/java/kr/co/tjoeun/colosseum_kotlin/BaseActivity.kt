package kr.co.tjoeun.colosseum_kotlin

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val mContext = this

    abstract fun setupEvent()
    abstract fun setValues()


}