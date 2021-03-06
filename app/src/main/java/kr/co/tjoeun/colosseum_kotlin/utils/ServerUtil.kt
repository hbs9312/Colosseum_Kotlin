package kr.co.tjoeun.colosseum_kotlin.utils

import android.content.Context
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.internal.http2.Http2Reader
import org.json.JSONObject
import java.io.IOException

class ServerUtil {

    interface JsonReponseHandler {
        fun onReponse(json : JSONObject)
    }

    companion object {

        private val BASE_URl = "http://15.165.177.142"

        fun postRequestLogin(context : Context, email : String, pw : String, hanlder : JsonReponseHandler) {

            val client = OkHttpClient()

            val formBody = FormBody.Builder()
                .add("email", email)
                .add("password", pw)
                .build()

            val request = Request.Builder()
                .url("${BASE_URl}/user")
                .post(formBody)
//                .header
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    val body  = response.body!!.string()

                    val jsonObj = JSONObject(body)

                    hanlder.onReponse(jsonObj)
                }

            })


        }
        
        fun getRequestMainInfo (context: Context, hanlder: JsonReponseHandler) {

            val client = OkHttpClient

            val urlBuilder = "${BASE_URl}/v2/main_info".toHttpUrlOrNull()!!.newBuilder()
            urlBuilder.addEncodedQueryParameter("device_token", "임시토큰")
            urlBuilder.addEncodedQueryParameter("os", "Android")

            val urlStr = urlBuilder.build().toString()

            val request = Request.Builder()
                .url(urlStr)
                .header("X-Http_Token", ContextUtil.getUserToken(context))
                .get()
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    val body  = response.body!!.string()

                    val jsonObj = JSONObject(body)

                    hanlder.onReponse(jsonObj)
                }

            })



        }

    }

}