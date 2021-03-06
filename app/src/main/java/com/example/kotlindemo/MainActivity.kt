package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.adapter.UserAdapter
import com.example.kotlindemo.model.UserModel

import org.json.JSONObject
import android.util.Log
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray


class MainActivity : AppCompatActivity() {

    var userModel = ArrayList<UserModel>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val recyclerView = findViewById(R.id.recyclerview) as RecyclerView
        //val recyclerView: RecyclerView = recyclerview1


        recyclerView = findViewById(R.id.recyclerview)


        /*for(i in UserData().contactinfo.indices)
            userModel.add(UserModel(UserData().usernames[i], UserData().contactinfo[i]))*/

        getJSOndata();

        /*val recyclerView: RecyclerView = recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val userModel = ArrayList<UserModel>()

        for(i in UserData().contactinfo.indices)
            userModel.add(UserModel(UserData().usernames[i], UserData().contactinfo[i]))


        val adapter = UserAdapter(userModel)
        recyclerView.adapter = adapter*/

    }

    private fun getJSOndata() {
        val queue = Volley.newRequestQueue(this)
        val jsonObjReq = object : JsonArrayRequest(Method.GET,
            "https://jsonplaceholder.typicode.com/users", null,
            object : Response.Listener<JSONArray> {

                override fun onResponse(response: JSONArray) {

                    Log.d("hello " ,"" +response)

                    var jsonArray:JSONArray = response;

                    for(i in 0..(jsonArray.length()-1)){
                        var jsonObject: JSONObject = jsonArray.optJSONObject(i)
                        if(jsonObject.has("name")){
                            userModel.add(UserModel(jsonObject.optString("name"), jsonObject.optString("phone")))
                        }
                    }

                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    //recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2);
                    val adapter = UserAdapter(userModel)
                    recyclerView.adapter = adapter

                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {
                    error.message
                }
            }) {

        }
        queue.add(jsonObjReq)
    }
}


/*package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.Adapter.UserAdapter
import com.example.kotlindemo.Class.UserModel

import org.json.JSONObject
import android.util.Log
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray


class MainActivity : AppCompatActivity() {

    var userModel = ArrayList<UserModel>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)

        getJSOndata();

    }

    private fun getJSOndata() {

        val queue = Volley.newRequestQueue(this)
        val jsonObjReq = object : JsonArrayRequest(Method.GET,
            "http://www.json-generator.com/api/json/get/cpLdqfQvdu?indent=2", null,
            object : Response.Listener<JSONArray> {

                override fun onResponse(response: JSONArray) {

                    Log.d("hello ", "" + response)

                    for (i in 0..(response.length() - 1)) {
                        var jsonObject: JSONObject = response.optJSONObject(i)

                        if(jsonObject.has("name_of_song") || jsonObject.has("artist_name") || jsonObject.has("image_url") || jsonObject.has("song_url")){
                            userModel.add(
                                UserModel(
                                    jsonObject.optString("name_of_song"),
                                    jsonObject.optString("artist_name"),
                                    jsonObject.optString("image_url"),
                                    jsonObject.optString("song_url")
                                )
                            )
                        }

                    }
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    val adapter = UserAdapter(userModel)
                    recyclerView.adapter = adapter

                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {
                    error.message
                }
            }) {

        }
        queue.add(jsonObjReq)
    }
}*/
