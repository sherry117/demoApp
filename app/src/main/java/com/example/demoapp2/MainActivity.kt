package com.example.demoapp2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.gategory_ticket.*
import kotlinx.android.synthetic.main.gategory_ticket.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var url="http://192.168.8.101/saleweb/get_category.php"
        var list=ArrayList<categoryClass>()
        var rq:RequestQueue=Volley.newRequestQueue(this)

        var jar= JsonArrayRequest(Request.Method.GET,url,null, Response.Listener { response ->

            for (x in 0..response.length()-1)
                list.add(
                    categoryClass(
                        response.getJSONObject(x).getInt("id"), response.getJSONObject(x).getString("name")
                        , response.getJSONObject(x).getString("photo")
                    )
                )

            var adp = categoryAdapter(this, list)
            category_rv.layoutManager = GridLayoutManager(this, 2)
            category_rv.adapter = adp
        },
            Response.ErrorListener { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            })
        rq.add(jar)


    }
}
