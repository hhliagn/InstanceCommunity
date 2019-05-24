package com.lhh.ByteBuf;

import java.nio.ByteBuffer;

/**
 * @author lhh
 * @date 2019/5/23 22:10
 */
public class ByteBufTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        byteBuffer.put(new byte[]{1, 2, 3, 4, 5, 6});
        byteBuffer.flip();
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer);
        //byteBuffer.flip(); //0, 1
        //byteBuffer.put((byte)10); //1, 1
        //System.out.println(byteBuffer);
        //byteBuffer.put((byte)11);
        //byteBuffer.flip();
        //System.out.println(byteBuffer.get());
        //System.out.println(byteBuffer);

        //
        byteBuffer.mark();
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer);

        byteBuffer.reset();
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer);

        //
        byteBuffer.compact();
        byteBuffer.flip();
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
//        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer);
    }
}
