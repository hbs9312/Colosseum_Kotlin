package kr.co.tjoeun.colosseum_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.tjoeun.colosseum_kotlin.utils.ContextUtil

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvent()
        setValues()
    }

    override fun setupEvent() {

    }

    override fun setValues() {

        title = "진행중인 토론 목록"

        Log.d("로그인토큰", ContextUtil.getUserToken(mContext));
    }

}
