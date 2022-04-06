import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description: 360面试题目
 *
 * @author: bberzhou@gmail.com
 * @date: 4/4/2022
 * Create By Intellij IDEA
 */
public class Test {
    public static boolean isHuiwen(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuicheng(String s) {
        String str = "AHIMOTUVWXY";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (str.contains(String.valueOf(s.charAt(i)))) {
                count++;
            }
        }
        return count == s.length();
    }

    public static void main(String[] args) {
        ArrayList<String > arrayList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入测试数据的组数:");
        int n = in.nextInt();

        /**
         *  *************************************这里注意一个问题*********************************
         *  在使用Scanner对象的nextLine()函数读取输入的一行数据时，有时会出现读取不到数据的情况。
         *  这是因为在调用nextLine()函数前调用了Scanner的另一个函数nextInt()（或是nextDouble()）。
         *  出现这种情况的原因是两个函数的处理机制不同，nextInt()函数在缓冲区中遇到“空格”、“回车符”等空白字符时会将空白字符前的数据读取走，
         *  但空白字符不会被处理掉，而nextLine()函数是在缓冲区中读取一行数据，这行数据以“回车符”为结束标志，
         *  nextLine()会把包括回车符在内的数据提走。所以nextInt()后的nextLine()函数并非读取不到数据，
         *  因为nextInt()将“回车符”留在了缓冲区，nextLine()读取时遇到的第一个字符便是“回车符”，所以直接结束了。
         *
         *
         *  解决方法：
         *      1、在要使用nextLine()前先调用一次nextLine()，这样留在缓冲区的“回车符”就会被处理掉，
         *          这时第二个nextLine()函数可以正常读取到数据。
         *      2、避免在nextLine()之前调用nextInt()等函数，可以统一使用nextLine()来读取数据，之后再进行类型转换。
         *
         *      其次，说一下next()，nextLine()，nextInt()三种函数的区别
         *      next():只读取输入直到空格。它不能读由空格隔开的两个单词。同样，next()在读取输入后将光标放在同一行。
         *      nextLine():读取输入，包括单词之间的空格(即读取到行\n的末尾)。读取输入后，nextLine()将光标定位在下一行。
         *      nextInt(): 它只读取int值，nextInt()在读取输入后将光标放在同一行。
         *
         */
        in.nextLine();
        while (n >0){
            String s = in.nextLine();
            if (isDuicheng(s)&& isHuiwen(s)){
                arrayList.add("YES");
            }else {
                arrayList.add("NO");
            }
            n--;
        }
        for (String str: arrayList){
            System.out.println(str);
        }
    }

}
