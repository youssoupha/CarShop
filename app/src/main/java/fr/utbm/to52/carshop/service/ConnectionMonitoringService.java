package fr.utbm.to52.carshop.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import fr.utbm.to52.carshop.utils.enums.SynchronizationType;

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
                SynchronizationService synchronizationService = new SynchronizationService();
                synchronizationService.execute(SynchronizationType.CONNECTION_LOSS.toString());
            }
        }
    }

    public static boolean isConnectedToNetwork(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return  activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
