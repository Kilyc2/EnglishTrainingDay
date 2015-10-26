package com.android.tfc.englishtrainingday.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;

import com.android.tfc.englishtrainingday.R;
import com.android.tfc.englishtrainingday.utils.Constants;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MainActivity extends Activity {

    public static Activity mainActivity;
    private String levelSelected;
    private ApiGetterVersion apiGetterVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        apiGetterVersion = new ApiGetterVersion(this);
        apiGetterVersion.execute();
        SharedPreferences preferenceInitial =
                getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        this.levelSelected = preferenceInitial.getString(Constants.LEVEL_SELECTED, "");
    }

    private void goToGrammar(String level) {
        Intent intent = new Intent(MainActivity.this, GrammarActivity.class);
        Bundle args = new Bundle();
        args.putString(Constants.LEVEL_SELECTED, level);
        intent.putExtras(args);
        startActivity(intent);
    }

    private void goToLevel() {
        Intent intent = new Intent(MainActivity.this, LevelActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (apiGetterVersion != null &&
                    apiGetterVersion.getStatus() == AsyncTask.Status.RUNNING) {
                apiGetterVersion.cancel(true);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private class ApiGetterVersion extends AsyncTask<Void, Void, String> {

        private ProgressDialog checkingVersionBox;
        private Context context;

        public ApiGetterVersion(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            checkingVersionBox = ProgressDialog.show(this.context,
                    "Checking version", "please wait...", true);
        }

        @Override
        protected String doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://crypto-plane-693.appspot.com/etd");
            try {
                HttpResponse response = httpClient.execute(httpPost);
                return EntityUtils.toString(response.getEntity());
            } catch (ClientProtocolException e) {
                return "";
            } catch (IOException e) {
                return "";
            }
        }

        @Override
        protected void onPostExecute(String version) {
            SharedPreferences settings =
                    getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(Constants.API_VERSION, version);
            editor.commit();
            checkingVersionBox.dismiss();
            if (!levelSelected.isEmpty()) {
                goToGrammar(levelSelected);
            } else {
                goToLevel();
            }
        }
    }
}
