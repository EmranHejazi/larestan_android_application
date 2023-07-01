package app.uni.lar.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class ExitDialog {

    public static void show(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("خروج از برنامه");
        builder.setMessage("آیا می خواهید از برنامه خارج شوید؟");
        builder.setCancelable(false);
        builder.setPositiveButton("خروج", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // Exit the app
                System.exit(0);
            }
        });
        builder.setNegativeButton("لغو", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // Do nothing
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
