package fr.utbm.to52.carshop.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class ConnectionMonitoringService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null) {
            if (!info.isConnected()) {

            }
        }
    }
}
