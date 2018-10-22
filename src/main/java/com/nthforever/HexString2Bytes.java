package com.nthforever;

/**
 * @author Nthforever
 * @date 2018/10/22
 * 对16进制字符串转byte函数解读，实际上是对信息的压缩
 */
public class HexString2Bytes {

    /**
     *
     * 16进制 To byte[]
     * * @param hexString
     * * @return byte[]
     * */
    public static byte[] hexStringToBytes(String hexString) {//将16进制字符串转为byte
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        //转大写
        hexString = hexString.toUpperCase();
        //十六进制需要4bit来表示，一个byte包含8bit
        //这里的长度计算就很明显了，一个byte刚好可以容纳两个16进制的字符
        int length = hexString.length() / 2;
        //将字符串转化为字符数组
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        //遍历字符数组
        for (int i = 0; i < length; i++) {
            //每次取两个字符  比如说AB
            int pos = i * 2;
            //对应byte高4位
            char c = hexChars[pos];
            //对应byte低4位
            char c2 = hexChars[pos + 1];
            //这里返回的是两个byte，但是两个byte高4位全部为0 ，要把他们组合起来，
            //00001001
            byte b = charToByte(c);
            //00001100
            byte b2 = charToByte(c2);
            //所以对b,左移动4位  与上 b2 就是最后结果
            // b << 4 ==》 10010000  | 00001100
            d[i] = (byte) ( b << 4 | b2);
        }
        return d;
    }

    /** *
     *  Convert char to byte
     *  * @param c char
     *  * @return byte
     *  */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
