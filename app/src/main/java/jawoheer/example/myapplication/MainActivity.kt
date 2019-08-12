package jawoheer.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {
    private var bookInfo=ArrayList<BookInfo>()

    //private val tripsRecyclerViewAdapter=TripsRecyclerViewAdapter(bookInfo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar=findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))
        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))
        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))
        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))
        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))
        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))
        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))
        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))
        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))
        bookInfo.add(BookInfo("Tashkent city, Shaykhontokhur district dom 4", "New York, Manhatten district",
            "2019-07-08 09:58:32", "9,000 soum"))

        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=TripsRecyclerViewAdapter(bookInfo,object:TripsRecyclerViewAdapter.OnItemClickListener{
            override fun onItemClick(item: BookInfo) {

                val intent=Intent(applicationContext, MapsActivity::class.java)
                startActivity(intent)
            }
        })
    }


}
