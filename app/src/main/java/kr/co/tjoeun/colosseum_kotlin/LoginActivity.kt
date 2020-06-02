package kr.co.tjoeun.colosseum_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import kr.co.tjoeun.colosseum_kotlin.utils.ContextUtil
import kr.co.tjoeun.colosseum_kotlin.utils.ServerUtil
import org.json.JSONObject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvent()
        setValues()
    }

    override fun setupEvent() {

        loginBtn.setOnClickListener {
            val email = emailEdt.text.toString()
            val pw = pwEdt.text.toString()

            ServerUtil.postRequestLogin(mContext,email, pw, object : ServerUtil.JsonReponseHandler{
                override fun onReponse(json: JSONObject) {
                    Log.d("로그인응답", json.toString())

                    val data = json.getJSONObject("data")
                    val token = data.getString("token")

                    ContextUtil.setUserToken(mContext, token)

                }


            })



        }

    }

    override fun setValues() {

    }


}
