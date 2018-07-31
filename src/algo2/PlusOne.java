package algo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sse on 2017/9/4.
 */
public class PlusOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inStr = scanner.nextLine();
        List<Integer> reList = new ArrayList<>();
        if (null==inStr || inStr.length()==0) {
            System.out.println("输入不合法");
            return;
        }
//        else if (isPositive(inStr)){}
        else {
            int len = inStr.length();
            for (int i = 0; i < len; i++) {
                reList.add(inStr.charAt(len-1-i)-'0');
            }
            showList(reList);
            /*for (int i = 0; i < len; i++) {
                System.out.print(reList.get(i));
            }*/
//            plus one
            plusOne(reList);
        }

    }

    public static void plusOne(List<Integer> reList){
        int one = 1;
        for (int i=0,len=reList.size(); i<len;i++){
            if (one == 1) {
                int sum = one + reList.get(i);
                reList.set(i,sum%10);
                one = sum/10;
            }else {
                break;
            }
        }
        if (one==1){
            reList.add(reList.size(),1);
        }
        showList(reList);
    }
    public static void showList(List list){
        List tmp = new ArrayList<>();
        for (int i = 0,len = list.size(); i < len; i++) {
            tmp.add(list.get(len-1-i));
        }
        tmp.stream().forEach(System.out::print);
        System.out.println();
    }
    public static boolean isPositive(String s) {
        char ch = s.charAt(0);
        if ('+' == ch) {
            for (int i = 1; i < s.length(); i++) {

            }
        }
        return false;
    }
}
