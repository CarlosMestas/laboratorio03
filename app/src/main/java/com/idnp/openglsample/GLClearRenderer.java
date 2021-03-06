package com.idnp.openglsample;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class GLClearRenderer implements Renderer {

    private Cube mCube = new Cube();
    private Icosahedron mIcosahedron = new Icosahedron();
    private float mCubeRotation;
    private float mIcosahedronRotation;

    public void onDrawFrame( GL10 gl ) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glTranslatef(2.0f, 0.0f, -10.0f);
        gl.glRotatef(mCubeRotation, -1.0f, 0.0f, 0.0f);

        mCube.draw(gl);

        gl.glTranslatef(-5.0f, 0.0f, .0f);
        gl.glRotatef(mIcosahedronRotation, -1.0f, 0.0f, 0.0f);

        mIcosahedron.draw(gl);

        gl.glLoadIdentity();

        mCubeRotation -= 0.15f;
        mIcosahedronRotation -= 0.15f;

    }

    public void onSurfaceChanged( GL10 gl, int width, int height ) {
        gl.glViewport( 0, 0, width, height );

        GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void onSurfaceCreated( GL10 gl, EGLConfig config ) {
        // No need to do anything here.
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);

        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);

        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                GL10.GL_NICEST);
    }
}