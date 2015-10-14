/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.simpleclock;

import android.media.MediaPlayer;
import android.net.Uri;
import android.service.dreams.DreamService;
import android.util.Log;
import android.widget.VideoView;

public class Daydream extends DreamService {
    private VideoView myVideoView;

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
        setFullscreen(true);
        setScreenBright(false);
        setContentView(R.layout.fullscreen_clock);

        Log.v("Test", "Test");

        myVideoView = (VideoView) findViewById(R.id.video_view);
        try {
            //set the uri of the video to be played
            myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tokyo));


        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }


        myVideoView.requestFocus();
        //we also set an setOnPreparedListener in order to know when the video file is ready for playback
        myVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {
                myVideoView.start();
            }
        });
    }
}
