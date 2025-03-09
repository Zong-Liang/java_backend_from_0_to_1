package computational_complexity;

public class iteration {
    /* for 循环 */
    static int forLoop(int n){
        int res = 0;
        //循环求和 1, 2, ..., n-1, n
        for (int i = 0; i < n; i++){
            res += i;
        }
        return res;
    }

    /* while 循环 */
    static int whileLoop1(int n){
        int res = 0;
        //初始化条件变量
        int i = 1;
        //循环求和 1, 2, ..., n-1, n
        while (i < n){
            res += i;
            //更新条件变量
            i++;
        }
        return res;
    }

    /* while 循环（两次更新） */
    static int whileLoop2(int n){
        int res = 0;
        int i = 1;
        while (i < n){
            res += i;
            i++;
            i *= 2;
        }
        return res;
    }

    /* 双层 for 循环 */
    static String nestedForLoop(int n){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                res.append("(").append(i).append(", ").append(j).append("), ");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int n = 5;

        int res1 = forLoop(n);
        System.out.println("\nfor 循环的求和结果 res = " + res1);

        int res2 = whileLoop1(n);
        System.out.println("\nwhile 循环的求和结果 res = " + res2);

        int res3 = whileLoop2(n);
        System.out.println("\nwhile 循环（两次更新）求和结果 res = " + res3);

        String resStr = nestedForLoop(n);
        System.out.println("\n双层 for 循环的遍历结果 " + resStr);
    }
}
