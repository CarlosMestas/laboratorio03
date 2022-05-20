package com.idnp.openglsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // When working with the camera, it's useful to stick to one orientation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Now let's create an OpenGL surface.
        GLSurfaceView glView = new GLSurfaceView(this);
        // The renderer will be implemented in a separate class, GLView, which I'll show next.
        glView.setRenderer(new GLClearRenderer());
        // Now set this as the main view.
        setContentView(glView);



    }

}
