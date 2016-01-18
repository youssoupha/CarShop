package fr.utbm.to52.carshop.service;

import android.os.AsyncTask;

import fr.utbm.to52.carshop.utils.enums.SynchronizationType;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class SynchronizationService extends AsyncTask<String, Void, String> {

    private void downloadAllData() {
        //TODO this function download all data from MySQL DB and overwrite the local DB
    }

    private void syncronizeAfterConnectionLoss() {
        //TODO this function uploads the local database changes to mysql db and then download the remaining data from command and client
    }

    @Override
    protected String doInBackground(String... params) {
        SynchronizationType syncType = SynchronizationType.valueOf(params[0]);
        switch(syncType) {
            case DOWN_ALL_DATA:
                downloadAllData();
                break;
            case CONNECTION_LOSS:
                syncronizeAfterConnectionLoss();
                break;
        }

        return null;
    }
}
