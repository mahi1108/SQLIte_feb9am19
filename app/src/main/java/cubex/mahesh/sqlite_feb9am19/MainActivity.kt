package cubex.mahesh.sqlite_feb9am19

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import android.widget.Toast
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

            var cv = ContentValues( )
            cv.put("id",et1.text.toString().toInt())
            cv.put("name",et2.text.toString())
            cv.put("desig",et3.text.toString())
            cv.put("dept",et4.text.toString())
            var status:Long = dBase.insert("employee",
                null, cv)
            if(status != -1L){
                Toast.makeText(this@MainActivity,
                    "Record Inserted Successfully",
                    Toast.LENGTH_LONG).show()
                et1.setText("");   et2.setText("")
                et3.setText("");  et4.setText("")
            }else{
                Toast.makeText(this@MainActivity,
                    "Record insertion  is failed..",
                    Toast.LENGTH_LONG).show()
            }
        }
        read.setOnClickListener {
       /*     var c:Cursor = dBase.query("employee",
                null,null,null,
               null,null,null ) */
          /*  var c:Cursor = dBase.query("employee",
                arrayOf("id","name","desig","dept"),null,null,
                null,null,null ) */
          /*  var c:Cursor = dBase.query("employee",
                null,"id=?",
                arrayOf(et1.text.toString()),
                null,null,null ) */
         /*   var c:Cursor = dBase.query("employee",
                null,null,null,
                "id","id>125",null ) */
            var c:Cursor = dBase.query("employee",
                null,null,null,
                null,null,
                "id desc" )
            var cAdapter = SimpleCursorAdapter(
                this@MainActivity,R.layout.indiview,
                c, arrayOf("id","name","desig","dept"),
                    intArrayOf(R.id.id,R.id.name,R.id.desig,R.id.dept),
                    0)
            lview.adapter = cAdapter
        }
        update.setOnClickListener {
            var cv = ContentValues()
            cv.put("name",et2.text.toString())
            cv.put("desig",et3.text.toString())
            var status : Int = dBase.update("employee",cv,
                "id=?", arrayOf(et1.text.toString()))
            if(status >0){
                Toast.makeText(this@MainActivity,
                    "Record Updated Successfully",
                    Toast.LENGTH_LONG).show()
                et1.setText("");   et2.setText("")
                et3.setText("");  et4.setText("")
            }else{
                Toast.makeText(this@MainActivity,
                    "Record Updation  is failed..",
                    Toast.LENGTH_LONG).show()
            }

        }
        delete.setOnClickListener {
    // delete from employee where column_name = ?
            var status : Int = dBase.delete("employee",
                "id=?", arrayOf(et1.text.toString()))
            if(status >0){
                Toast.makeText(this@MainActivity,
                    "Record Deleted Successfully",
                    Toast.LENGTH_LONG).show()
                et1.setText("");   et2.setText("")
                et3.setText("");  et4.setText("")
            }else{
                Toast.makeText(this@MainActivity,
                    "Record Deletion  is failed..",
                    Toast.LENGTH_LONG).show()
            }

        }
    }
}
