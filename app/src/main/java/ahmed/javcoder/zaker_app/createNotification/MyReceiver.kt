package ahmed.javcoder.zaker_app.createNotification

import ahmed.javcoder.zaker_app.R
import ahmed.javcoder.zaker_app.Ui.MainActivity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

class MyReceiver : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent != null){
            var Channel_id :String = "my_channel_01"
            var name:CharSequence = context.getString(R.string.channel_name)
            var importance :Int = NotificationManager.IMPORTANCE_HIGH
            var nChannel:NotificationChannel = NotificationChannel(Channel_id , name , importance)
            var nBuilder:NotificationCompat.Builder = NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.zakericon)
                .setContentTitle("Zaker_app")
                .setContentText(context.getString(R.string.message))
                .setChannelId(Channel_id)
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))

            var intent:Intent = Intent(context , MainActivity::class.java)
            var pending:PendingIntent = PendingIntent.getActivity(
                context , 0 ,intent , PendingIntent.FLAG_UPDATE_CURRENT)
            nBuilder.setContentIntent(pending)
            var notManager:NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                notManager.createNotificationChannel(nChannel)
            }
            notManager.notify(0 , nBuilder.build())
        }
    }
}