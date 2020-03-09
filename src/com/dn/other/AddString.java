package com.dn.other;

public class AddString {

    public static void main(String[] args) {
        // 字符串加法
        /*
        有两个字符串数字，数字特别大，数字超出了Integer相加的范围，类似于
        String a1 = “1615146841218….1234”;
        String a2 = “8675446841218….4321”;
        直接相加的会有溢出，写一个算法实现相加：
        我们直接计算是不行的，需要每一位字符一个一个相加，相加之后在一位一位添加到一个新字符串中，但是如果说两个大于5的数值相加，
        就会溢出一位，相应的上一位就应该加1，所以说我们需要将两个字符串反转，从小到大一个一个的加，溢出之后，在进位上加1。
        假设这个字符串是99999和123，倒序排序之后为99999,321，将小的字符串长度补齐， 为99999，32100，第一次遍历，
         9 + 3 为12 ，即个位数为2 ，十位数进一位，我们就需要将1 提出来，在下一次遍历时加上，即现在新字符串值为2，进一位有个1；
         第二次遍历，9+2 = 11，新字符串值为‘2 ’+ ‘（1 + 1）’，又有一个进位1…依此类推
         */
        String str1 = "132";
        String str2  = "12354";
        StringBuffer s1 = new StringBuffer(str1).reverse();
        System.out.println(s1);
        StringBuffer s2 = new StringBuffer(str2).reverse();
        System.out.println(s2);
        StringBuffer res = new StringBuffer();

        int len1 = s1.length();
        int len2 = s2.length();
        int len;

        if (len1 < len2) {
            len = len2;
            int count = len2 - len1;
            while (count-- > 0)
                s1.append('0');
        } else {
            len = len1;
            int count = len1 - len2;
            while (count-- > 0)
                s2.append('0');
        }
        System.out.println(s1);
        System.out.println(s2);

        int overflow = 0;
        int num;

        for (int i = 0; i < len; i++) {
            System.out.println("s1.charAt(i):"+s1.charAt(i));
            System.out.println("s2.charAt(i):"+s2.charAt(i));

            num = (s1.charAt(i)) - '0' + s2.charAt(i) - '0' + overflow;
            System.out.println("num:"+num);
            if (num >= 10) {
                overflow = 1;
                num -= 10;
            } else {
                overflow = 0;
            }
            res.append(String.valueOf(num));
        }

        if (overflow == 1)
            res.append(1);

        System.out.println(res.reverse().toString()) ;
    }
}
