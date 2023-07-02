package app.uni.lar.utils;

import android.content.Context;
import android.content.res.Configuration;

public class DarkModeChecker {

    public static boolean isDarkModeOff(Context context) {
        int currentNightMode = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return currentNightMode == Configuration.UI_MODE_NIGHT_NO;
    }

}
