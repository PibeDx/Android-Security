package com.josecuentas.android_security.security;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import com.josecuentas.android_security.BuildConfig;

import java.security.MessageDigest;

/**
 * Created by jcuentas on 25/05/17.
 * Info:
 * https://www.airpair.com/android/posts/adding-tampering-detection-to-your-android-app
 * https://stackoverflow.com/a/25011746
 */

public class CheckApp {

    public static final int VALID = 0;

    public static final int INVALID = 1;

    public static boolean checkAppSignature(Context context) {

        try {

            PackageInfo packageInfo = context.getPackageManager()

                    .getPackageInfo(context.getPackageName(),

                            PackageManager.GET_SIGNATURES);

            for (Signature signature : packageInfo.signatures) {

                byte[] signatureBytes = signature.toByteArray();

                MessageDigest md = MessageDigest.getInstance("SHA");

                md.update(signature.toByteArray());

                final String currentSignature = Base64.encodeToString(md.digest(), Base64.NO_WRAP); //NO_WRAP evita el salto de linea

                //Log.d("REMOVE_ME", "Include this string as a value for SIGNATURE:" + currentSignature);

                //compare signatures

                if (BuildConfig.SIGNATURE.equals(currentSignature)){

                    return true;

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            //assumes an issue in checking signature., but we let the caller decide on what to do.

        }

        return false;

    }
}
