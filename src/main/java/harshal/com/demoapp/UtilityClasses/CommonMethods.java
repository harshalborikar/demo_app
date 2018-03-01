package harshal.com.demoapp.UtilityClasses;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;


public class CommonMethods {
    public static boolean checkInternetConnection(Context mContext) {
        ConnectivityManager conMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() &&
                conMgr.getActiveNetworkInfo().isConnected()) {
            return true;
        }
        return false;
    }

    public static void Toast(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
