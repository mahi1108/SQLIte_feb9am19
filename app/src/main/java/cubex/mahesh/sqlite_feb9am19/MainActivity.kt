package cubex.mahesh.sqlite_feb9am19

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dBase:SQLiteDatabase = openOrCreateDatabase(
            "and9amfeb19",
            Context.MODE_PRIVATE, null)
        dBase.execSQL("create table if not exists employee(_id integer primary key  autoincrement,id integer,name varchar(50),desig varchar(50),dept varchar(50))")


        insert.setOnClickListener {

        }
        read.setOnClickListener {  }
        update.setOnClickListener {  }
        delete.setOnClickListener {  }
    }
}
