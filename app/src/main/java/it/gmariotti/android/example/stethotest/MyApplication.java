package it.gmariotti.android.example.stethotest;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by g.mariotti on 16/07/2015.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Stetho configuration
        if (BuildConfig.DEBUG){
            Stetho.initialize(
                    Stetho.newInitializerBuilder(this)
                            .enableDumpapp(
                                    Stetho.defaultDumperPluginsProvider(this))
                            .enableWebKitInspector(
                                    Stetho.defaultInspectorModulesProvider(this))
                            .build());
        }
    }
}
