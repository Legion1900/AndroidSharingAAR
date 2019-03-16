package com.nomad.sharepicture;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.app.ShareCompat;

import java.io.File;

import static android.support.v4.content.FileProvider.getUriForFile;

public class ShareUtil {

    public void publishFile
            (String filePath, String chooserTitle, String mimeType, Activity activity) {
        File imageFile = new File(filePath);
        Uri uri = getUriForFile(activity, "com.nomad.sharepicture.fileprovider", imageFile);

        ShareCompat.IntentBuilder
                .from(activity)
                .setType(mimeType)
                .setChooserTitle(chooserTitle)
                .setStream(uri)
                .startChooser();
    }

}
