import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/2/2022
 * Create By Intellij IDEA
 */

public class ttt{

    public static void main(String[] args) {
        /**
         * 第一题
         * 现在的调查问卷越来越多了，所以出现了很多人恶意刷问卷的情况，已知某问卷需要填写名字，，
         * 则我们认为这个名字是真实有效的，否则就判定为恶意填写问卷。
         * 请你判断出由多少有效问卷（只要名字是真实有效的，就认为问卷有效
         *
         */
        // 如果名字仅由大小写英文字母组成且长度不超过10即为有效
        /**
         * 输入第一行包含一个正整数n，表示收到的问卷数量。(1<=n<=2000)
         * 接下来有n行，每行有一个由大小写英文字母，数字，下划线组成的字符串，分别表示一份问卷的名字，字符串长度不超过100。
         * 输出只有一个整数，表示有效问卷数量。
         */
        Scanner scanner = new Scanner(System.in);
        // 获取问卷数量和问卷名称
        int testCount = scanner.nextInt();
        // 对问卷数量进行控制
        if(testCount < 1 || testCount > 2000){
            System.exit(0);
        }
        List<String> inputStrings = new ArrayList<>();
        for(int i = 0;i < testCount;i++){
            String next = scanner.next();
            inputStrings.add(next);
        }
        // 用数组来存储是否合法
        boolean[] isLegal = new boolean[inputStrings.size()];
        int[] numbers = {0,1,2,3,4,5,6,7,8,9};
        // 赋予初值
        Arrays.fill(isLegal, false);
        // 开始校验
        for(int i = 0;i < inputStrings.size();i++){
            String inputString = inputStrings.get(i);
            // 1、首先判断长度
            if(inputString.length() > 100){
                isLegal[i] = false;
            }
            if(inputString.length() > 0 && inputString.length() <= 10){
                isLegal[i] = true;
            }else{
                continue;
            }
            // 2、看看是否包括数字和下划线
            for(int j = 0;j < inputString.length();j++){
                char sName = inputString.charAt(j);
                for(int k = 0;k < 10;k++){
                    if(sName == numbers[k]){
                        isLegal[i] = false;
                        break;
                    }
                }
            }
            if(inputString.contains("_")){
                isLegal[i] = false;
                continue;
            }
            // 3、接下来判断是否包含大小写英文字母
            String s = inputString.toUpperCase();
            for(int j = 0;j < s.length();j++){
                char sName = s.charAt(j);
                isLegal[i] = sName >= 65 && sName <= 97;
            }
        }
        // 统计满足要求的个数
        int resultCount = 0;
        for (boolean b : isLegal) {
            if (b) {
                resultCount++;
            }
        }
        System.out.println(resultCount);

    }
}