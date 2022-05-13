package com.idnp.openglsample;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Icosahedron {

    // Icosaedro regular puntos
    /*
     *  AureaProportion = 1.618
     *  U = 0.f, -aP,  1,
     *  V = 0.f, -aP,  1,
     *  W = 0.f,  aP, -1,
     *  X = 0.f, -aP, -1,
     *  Y =  1, 0,  aP,
     *  Z = -1, 0,  aP,
     *  A = -1, 0, -aP,
     *  B =  1, 0, -aP
     *  C =  aP,  1, 0,
     *  D = -aP,  1, 0,
     *  E = -aP, -1, 0,
     *  F =  aP, -1, 0,
     */

    float aP = 1.618f;

    private float u[] = {0.f, -aP,  1};
    private float v[] = {0.f,  aP,  1};
    private float w[] = {0.f,  aP, -1};
    private float x[] = {0.f, -aP, -1};

    private float y[] = { 1, 0,  aP};
    private float z[] = {-1, 0,  aP};
    private float a[] = {-1, 0, -aP};
    private float b[] = { 1, 0, -aP};

    private float c[] = { aP, 1,  0};
    private float d[] = {-aP, 1,  0};
    private float e[] = {-aP,-1,  0};
    private float f[] = { aP,-1,  0};



    private FloatBuffer mVertexBuffer;
    private FloatBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;

    private float vertices[] = {
            0.f, -aP,   1,
            0.f,  aP,   1,
            0.f,  aP,  -1,
            0.f, -aP,  -1,
            1,   0,  aP,
            -1,   0,  aP,
            -1,   0, -aP,
            1,   0, -aP,
            aP,   1,   0,
            -aP,   1,   0,
            -aP, - 1,   0,
            aP, - 1,   0,
    };
    private float colors[] = {
            0.0f,  1.0f,  0.0f,  1.0f,
            0.0f,  1.0f,  0.0f,  1.0f,
            0.0f,  1.0f,  0.0f,  1.0f,
            0.0f,  1.0f,  0.0f,  1.0f,
            1.0f,  0.0f,  0.0f,  1.0f,
            1.0f,  0.0f,  0.0f,  1.0f,
            0.0f,  0.0f,  1.0f,  1.0f,
            1.0f,  0.0f,  1.0f,  1.0f,
            0.0f,  1.0f,  0.0f,  1.0f,
            1.0f,  0.5f,  0.0f,  1.0f,
            1.0f,  0.5f,  0.0f,  1.0f,
            0.0f,  1.0f,  0.0f,  1.0f
    };

    private byte indices[] = {
            11,8,7,
            0,5,4,
            5,4,1,
            1,5,9,
            1,9,2,
            8,1,2,
            4,1,8,
            11,4,8,
            0,11,4,
            8,7,2,
            0,5,10,
            5,10,9,
            6,9,2,
            10,6,9,
            10,3,6,
            0,10,6,
            0,3,11,
            11,3,7,
            3,6,7,
            6,7,2
    };

    public Icosahedron() {
        ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        mVertexBuffer = byteBuf.asFloatBuffer();
        mVertexBuffer.put(vertices);
        mVertexBuffer.position(0);

        byteBuf = ByteBuffer.allocateDirect(colors.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        mColorBuffer = byteBuf.asFloatBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);
    }

    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CW);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glDrawElements(GL10.GL_TRIANGLES, 60, GL10.GL_UNSIGNED_BYTE,
                mIndexBuffer);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
