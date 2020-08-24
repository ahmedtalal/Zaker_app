package ahmed.javcoder.zaker_app.Ui

import ahmed.javcoder.zaker_app.R
import ahmed.javcoder.zaker_app.databinding.ActivitySplashscreenBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

class SplashscreenActivity : AppCompatActivity() {
    private lateinit var  binding : ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

//        generate data binding file
        binding = DataBindingUtil.setContentView(this , R.layout.activity_splashscreen)

        binding.skipId.setOnClickListener(){
            var intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent = Intent(this , MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}