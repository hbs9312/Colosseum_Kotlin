package kr.co.tjoeun.colosseum_kotlin.datas

import org.json.JSONObject

class Topic {

    companion object {
        fun getTopicFromJson(json : JSONObject) : Topic {
            var topic = Topic()

            topic.id = json.getInt("id")
            topic.title = json.getString("title")
            topic.imageUrl = json.getString("img_url")

        }

    }

    var id = 0;
    var title = ""
    var imageUrl = ""

}