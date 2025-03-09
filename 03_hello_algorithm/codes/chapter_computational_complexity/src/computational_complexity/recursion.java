package computational_complexity;

import java.util.Stack;

public class recursion {
    /* 递归 */
    static int recur(int n){
        if (n == 1) {
            return 1;
        } else {
            return n + recur(n - 1);
        }
    }

    /* 使用迭代模拟递归 */
    static int forLoopRecur(int n){
        //使用一个显式的栈来模拟系统调用栈
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        //递：递归调用
        for (int i = n; i >0; i--){
            //通过“入栈操作”模拟“递”
            stack.push(i);
        }
        //归：返回结果
        while (!stack.isEmpty()){
            //通过“出栈操作”模拟“归”
            res += stack.pop();
        }
        //res = 1+2+3+...+n
        return res;
    }

    /* 尾递归 */
    static int tailRecur(int n, int res){
        //终止条件
        if (n == 0) {
            return res;
        } else {
            //尾递归调用
            return tailRecur(n - 1, res + n);
        }
    }

    /* 斐波那契数列：递归 */
    static int fib(int n){
        if (n ==1 || n == 2){
            return n - 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 5;

        int res1 = recur(n);
        System.out.println("\n递归的求和结果 res = " + res1);

        int res2 = forLoopRecur(n);
        System.out.println("\n使用迭代模拟递归的求和结果 res = " + res2);

        int res3 = tailRecur(n, 0);
        System.out.println("\n尾递归的求和结果 res = " + res3);

        int res4 = fib(n);
        System.out.println("\n斐波那契数列的第 " + n + " 项为：" + res4);
    }


}
