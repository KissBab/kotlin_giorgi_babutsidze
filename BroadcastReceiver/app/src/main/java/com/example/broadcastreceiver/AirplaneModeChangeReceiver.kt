package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.util.*

class AirplaneModeChangeReceiver: BroadcastReceiver() {
    private lateinit var sqlHelper: SQLHelper;

    override fun onReceive(context: Context?, intent: Intent?) {
        var isAirplaneModeEnabled: Boolean = intent?.getBooleanExtra("state", false) ?: return

        fun getId(): Int {
            var random = Random()
            return random.nextInt(999999999)
        }

        val airplane: AirplaneEntity = AirplaneEntity(getId(), isAirplaneModeEnabled, Date())
        val queryStatus = sqlHelper.saveAirplaneModeState(airplane)

        if (queryStatus > -1) {
            Toast.makeText(context, "Saved to database", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Couldn't save to database", Toast.LENGTH_SHORT).show()
        }
    }
}