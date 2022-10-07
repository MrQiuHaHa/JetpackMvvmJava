package com.davis.jetpackmvvm.util;

public class UrlEncoderUtils {
    private UrlEncoderUtils() {}
    /**
     * 判断 str 是否已经 URLEncoder.encode() 过
     * 经常遇到这样的情况, 拿到一个 URL, 但是搞不清楚到底要不要 URLEncoder.encode()
     * 不做 URLEncoder.encode() 吧, 担心出错, 做 URLEncoder.encode() 吧, 又怕重复了
     * @param str
     * @return
     */
    static boolean hasUrlEncoded(String str) {
        boolean encode = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '%' && i + 2 < str.length()) {
                // 判断是否符合urlEncode规范
                char c1 = str.charAt(i+1);
                char c2 = str.charAt(i+2);
                if (isValidHexChar(c1) && isValidHexChar(c2)) {
                    encode = true;
                    break;
                }
            }
        }
        return encode;
    }

    /*
    判断 字符 是否是 16 进制的字符
     */
    private static boolean isValidHexChar(char c) {
        return Character.isLetterOrDigit(c);
    }
}
