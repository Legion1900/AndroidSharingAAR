package com.nomad.sharepicture;

import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import static android.support.v4.content.FileProvider.getUriForFile;

public class MainActivity extends AppCompatActivity {

    private static final String MIME_TYPE = "image/jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowShareClick(View who) {
        String fileName = "/target.jpg";
        String path = getExternalFilesDir(null).toString() + fileName;
        String title = "Test Publishing";

//        Toast.makeText(this, getExternalFilesDir(null).toString(), Toast.LENGTH_LONG).show();

        publishImage(path, title);
    }

    private void publishImage(String filePath, String chooserTitle) {
        File imageFile = new File(filePath);
        Uri uri = getUriForFile(this, "com.nomad.sharepicture.fileprovider", imageFile);

        ShareCompat.IntentBuilder
                .from(this)
                .setType(MIME_TYPE)
                .setChooserTitle(chooserTitle)
                .setStream(uri)
                .startChooser();
    }
}
