package th.ac.su.bmi

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.floor
import java.math.BigDecimal
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_cal = findViewById<Button>(R.id.btnCal)
        var edtW = findViewById<EditText>(R.id.edtW)
        var edtH = findViewById<EditText>(R.id.edtH)
        btn_cal.setOnClickListener {
            var weight = edtW.text.toString().toDouble()
            var height = edtH.text.toString().toDouble()
            height = height/100
            hideKeyboard()
            var intent = Intent(this@MainActivity,DetailActivity::class.java)
            intent.putExtra("weight", weight)
            intent.putExtra("height", height*100)
            startActivity(intent)
        }
    }
    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
