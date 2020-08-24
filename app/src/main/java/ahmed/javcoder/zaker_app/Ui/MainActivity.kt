package ahmed.javcoder.zaker_app.Ui

import ahmed.javcoder.zaker_app.R
import ahmed.javcoder.zaker_app.createNotification.CreateNotification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // call create method
        CreateNotification.create(11 , 10 , 1000 , applicationContext)
        CreateNotification.create(18 , 30 , 2000 , applicationContext)
        CreateNotification.create(2 , 30 , 3000 , applicationContext)
        CreateNotification.create(3 , 20 , 4000 , applicationContext)
    }
}