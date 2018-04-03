package com.example.user.kotrv1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.intellij.lang.annotations.JdkConstants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list=ArrayList<Meal>()
        /*list.add(Meal("Pizza 101",4.0,R.drawable.a))
        list.add(Meal("Pizza 105",3.5,R.drawable.b))
        list.add(Meal("Pizza 108",2.8,R.drawable.c))
        list.add(Meal("Pizza 109",3.7,R.drawable.d))*/

        var url:String="http://pioneersacademyproject.com/get_items.php?category=Pizza"

        var rq=Volley.newRequestQueue(this)
        var jar=JsonArrayRequest(Request.Method.GET,url,null,
                Response.Listener { response ->
                    (0 until response.length()).mapTo(list) {
                        Meal(response.getJSONObject(it).
                                getString("name"),response.getJSONObject(it)
                                .getDouble("price"),
                                "http://pioneersacademyproject.com/images/"+
                                        response.getJSONObject(it)
                                                .getString("photo")
                                                .replace(" ","%20"))
                    }
                    var adp=MealAdapter(this,list)
                    rv.layoutManager=LinearLayoutManager(this)
                    rv.adapter=adp

                },
                Response.ErrorListener { })

        rq.add(jar)



        //rv.layoutManager=LinearLayoutManager(this,
                //` LinearLayoutManager.HORIZONTAL,false)



    }
}
