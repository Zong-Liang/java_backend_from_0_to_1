package computational_complexity;

public class time_complexity {
    /* 常数阶 */
    static int constant(){
        int count = 0;
        for (int i = 0; i < 10000; i++){
            count++;
        }
        return count;
    }

    /* 线性阶 */
    static int linear(int n){
        int count = 0;
        for (int i = 0; i < n; i++){
            count++;
        }
        return count;
    }

    /* 线性阶（遍历数组） */
    static int arrayTraversal(int[] nums){
        int count = 0;
        for (int num : nums){
            count++;
        }
        return count;
    }

    /* 平方阶 */
    static int quadratic(int n){
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                count++;
            }
        }
        return count;
    }

    /* 平方阶（冒泡排序） */
    static int bubbleSort(int[] nums){
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    count += 3;
                }
            }
        }
        return count;
    }

    /* 指数阶（循环实现） */
    static int exponential(int n){
        int count = 0, base = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < base; j++){
                count++;
            }
            base *= 2;
        }
        return count;
    }

    /* 指数阶（递归实现） */
    static int expRecur(int n){
        if (n == 1){
            return 1;
        } else {
            return expRecur(n - 1) + expRecur(n - 1) + 1;
        }
    }

    /* 对数阶（循环实现） */
    static int logarithmic(int n){
        int count = 0;
        while (n > 1){
            n /= 2;
            count++;
        }
        return count;
    }

    /* 对数阶（递归实现） */
    static int logRecur(int n){
        if (n <= 1){
            return 0;
        } else {
            return logRecur(n / 2) + 1;
        }
    }

    /* 线性对数阶 */
    static int linearLogRecur(int n){
        if (n <= 1)
            return 1;
        int count = linearLogRecur(n / 2) + linearLogRecur(n / 2);
        for (int i = 1; i < n; i++){
            count++;
        }
        return count;
    }

    /* 阶乘阶（递归实现） */
    static int factorialRecur(int n) {
        if (n == 0)
            return 1;
        int count = 0;
        //从 1 个分裂出 n 个
        for (int i = 0; i < n; i++) {
            count += factorialRecur(n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("输入数据大小 n = " + n);

        int count = constant();
        System.out.println("常数阶的操作数量 = " + count);

        count = linear(n);
        System.out.println("线性阶的操作数量 = " + count);
        count = arrayTraversal(new int[n]);
        System.out.println("线性阶（遍历数组）的操作数量 = " + count);

        count = quadratic(n);
        System.out.println("平方阶的操作数量 = " + count);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            //[n,n-1,...,2,1]
            nums[i] = n - i;
        }
        count = bubbleSort(nums);
        System.out.println("平方阶（冒泡排序）的操作数量 = " + count);

        count = exponential(n);
        System.out.println("指数阶（循环实现）的操作数量 = " + count);
        count = expRecur(n);
        System.out.println("指数阶（递归实现）的操作数量 = " + count);

        count = logarithmic(n);
        System.out.println("对数阶（循环实现）的操作数量 = " + count);
        count = logRecur(n);
        System.out.println("对数阶（递归实现）的操作数量 = " + count);

        count = linearLogRecur(n);
        System.out.println("线性对数阶（递归实现）的操作数量 = " + count);

        count = factorialRecur(n);
        System.out.println("阶乘阶（递归实现）的操作数量 = " + count);
    }
}
