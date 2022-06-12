package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.util.*

class AirplaneModeChangeReceiver: BroadcastReceiver() {
    private lateinit var sqlHelper: SQLHelper;

    override fun onReceive(context: Context?, intent: Intent?) {
        var isAirplaneModeEnabled: Boolean = intent?.getBooleanExtra("state", false) ?:return

        fun getAutoId(): Int {
            var random = Random()
            return random.nextInt(1000000)
        }

        val airplane: AirplaneModeModel = AirplaneModeModel(getAutoId(), isAirplaneModeEnabled, Date())
        val success = sqlHelper.insertAirplaneModeState(airplane)

        if (success > -1) {
            Toast.makeText(context, "Airplane Mode Added", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Record couldn't added...", Toast.LENGTH_SHORT).show()
        }
}