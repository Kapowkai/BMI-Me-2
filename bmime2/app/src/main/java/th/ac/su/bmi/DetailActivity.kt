package th.ac.su.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val weight = intent.getDoubleExtra("weight",0.00)
        var height = intent.getDoubleExtra("height",0.00)
        var tvResult2 = findViewById<TextView>(R.id.tvResult2)
        var tvResult3 = findViewById<TextView>(R.id.tvResult3)
        var tvResult4 = findViewById<TextView>(R.id.tvResult4)
        var btnShare = findViewById<Button>(R.id.btnShare)
        var btnClose = findViewById<Button>(R.id.btnClose)

        height = height/100
        var bmi:Double = weight/(height*height)
        var result:String
        if(bmi>30)
            result = "Obese"
        else if (bmi> 25)
            result = "Overweight"
        else if (bmi> 18)
            result = "Healthy"
        else
            result = "Underweight"
        tvResult4.setText("(height: "+height+" weight: "+weight+")")
        tvResult3.setText(result)
        tvResult2.setText(bmi.round(2).toString())
        btnShare.setOnClickListener {

            var value = "My BMI is "+bmi.round(2).toString()+"("+result+")"
            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, value)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share to "))
        }
        btnClose.setOnClickListener {
            finish()
        }
    }
    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }
}
