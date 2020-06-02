package kr.co.tjoeun.colosseum_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvent()
        setValues()
    }

    override fun setupEvent() {

    }

    override fun setValues() {

        Handler().postDelayed({

            val myIntent = Intent(mContext, LoginActivity::class.java)
            startActivity(myIntent)

            finish()

        }, 2000)


    }

}
