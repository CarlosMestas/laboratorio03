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

    private FloatBuffer mVertexBuffer;
    private FloatBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;

    private float vertices[] = {
            0.f, -aP,   1,                  // Inicio               (0)
            0.f,  aP,   1,
            0.f,  aP,  -1,
            0.f, -aP,  -1,                  // Debe apuntar aqui    (3)
            1,   0,  aP,
            -1,   0,  aP,
            -1,   0, -aP,                    // Acá esta apuntando   (6)
            1,   0, -aP,
            aP,   1,   0,
            -aP,   1,   0,
            -aP, - 1,   0,                  // Tope (10)
            aP, - 1,   0,
    };
    // Rojo     1.0f,  0.0f,  0.0f
    // Azul     0.0f,  0.0f,  1.0f
    // Verde    0.0f,  1.0f,  0.0f
    private float colors[] = {
            0.0f,  0.2f,  1.0f,  1.0f,          // 00           x
            0.0f,  0.5f,  0.2f,  1.0f,          // 01
            0.0f,  0.7f,  1.0f,  1.0f,          // 02
            0.0f,  1.0f,  0.7f,  1.0f,          // 03
            0.4f,  0.5f,  0.3f,  1.0f,          // 04           x
            0.5f,  0.0f,  0.2f,  1.0f,          // 05           x
            0.6f,  0.2f,  0.9f,  1.0f,          // 06
            0.8f,  1.0f,  0.4f,  1.0f,          // 07
            1.0f,  0.0f,  0.2f,  1.0f,          // 08
            1.0f,  0.6f,  0.6f,  1.0f,          // 09
            1.0f,  0.8f,  0.9f,  1.0f,          // 10
            1.0f,  1.0f,  0.7f,  1.0f           // 11
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
            0,10,3,
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
