package ahmed.javcoder.zaker_app.createNotification

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*

class CreateNotification {

    companion object {
        fun create(hour:Int , minute:Int , port:Int , context: Context):Unit {
            var calendar:Calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY , hour)
            calendar.set(Calendar.MINUTE , minute)
            calendar.set(Calendar.SECOND , 0)
            calendar.set(Calendar.MILLISECOND , 0)
            var cal:Calendar = Calendar.getInstance()
            if (cal.after(calendar)){
                calendar.add(Calendar.DATE , 1)
            }

            var am :AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            var intent:Intent = Intent(context , MyReceiver::class.java)
            var pending:PendingIntent = PendingIntent.getBroadcast(context , port , intent , PendingIntent.FLAG_UPDATE_CURRENT)
            am.setRepeating(AlarmManager.RTC_WAKEUP , calendar.timeInMillis , AlarmManager.INTERVAL_DAY , pending)
        }
    }
}