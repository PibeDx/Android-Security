package com.josecuentas.android_security;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.josecuentas.android_security.security.CheckApp;
import com.josecuentas.android_security.security.CheckDebug;
import com.josecuentas.android_security.security.CheckInstallPlayStore;
import com.josecuentas.android_security.security.CheckRunEmulador;

public class MainActivity extends AppCompatActivity {

    private TextView tviSignature;
    private TextView tviRunEmulador;
    private TextView tviRunDebug;
    private TextView tviInstallOfPlayStore;
    private ImageView vieSignature, vieRunEmulador, vieRunDebug, vieInstallOfPlayStore;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectView();

        validationSignature();
        validationRunEmulador();
        validationDebug();
        validationVerifyInstall();

    }

    private void validationSignature() {
        if (CheckApp.checkAppSignature(this)) {
            tviSignature.setText(R.string.valid);
            imageSuccess(vieSignature);
        } else {
            tviSignature.setText(R.string.invalid);
            imageError(vieSignature);
        }
    }

    private void validationRunEmulador() {
        if (CheckRunEmulador.checkEmulator()) {
            tviRunEmulador.setText(R.string.yes);
            imageError(vieRunEmulador);
        } else {
            tviRunEmulador.setText(R.string.no);
            imageSuccess(vieRunEmulador);
        }
    }

    private void validationDebug() {
        if (CheckDebug.checkDebuggable(this)) {
            tviRunDebug.setText(R.string.yes);
            imageError(vieRunDebug);
        } else {
            tviRunDebug.setText(R.string.no);
            imageSuccess(vieRunDebug);
        }
    }

    private void validationVerifyInstall() {
        if (CheckInstallPlayStore.verifyInstaller(this)) {
            tviInstallOfPlayStore.setText(R.string.yes);
            imageSuccess(vieInstallOfPlayStore);
        } else{
            tviInstallOfPlayStore.setText(R.string.no);
            imageError(vieInstallOfPlayStore);
        }
    }
    private void imageSuccess(ImageView view) {
        Drawable normalDrawable = ContextCompat.getDrawable(this, R.drawable.ic_sentiment_very_satisfied_black_24dp);
        Drawable wrapDrawable = DrawableCompat.wrap(normalDrawable);
        DrawableCompat.setTint(wrapDrawable, ContextCompat.getColor(this ,R.color.green));
        view.setImageDrawable(wrapDrawable);
    }

    private void imageError(ImageView view) {
        Drawable normalDrawable = ContextCompat.getDrawable(this, R.drawable.ic_sentiment_very_dissatisfied_black_24dp);
        Drawable wrapDrawable = DrawableCompat.wrap(normalDrawable);
        DrawableCompat.setTint(wrapDrawable, ContextCompat.getColor(this ,R.color.red));
        view.setImageDrawable(wrapDrawable);
    }

    private void injectView() {
        tviSignature = (TextView) findViewById(R.id.tviSignature);
        tviRunEmulador = (TextView) findViewById(R.id.tviRunEmulador);
        tviRunDebug = (TextView) findViewById(R.id.tviRunDebug);
        tviInstallOfPlayStore = (TextView) findViewById(R.id.tviInstallOfPlayStore);
        vieSignature = (ImageView) findViewById(R.id.vieSignature );
        vieRunEmulador = (ImageView) findViewById(R.id.vieRunEmulador);
        vieRunDebug = (ImageView) findViewById(R.id.vieRunDebug );
        vieInstallOfPlayStore = (ImageView) findViewById(R.id.vieInstallOfPlayStore);
    }
}
