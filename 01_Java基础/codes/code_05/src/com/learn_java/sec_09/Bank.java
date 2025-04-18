package com.learn_java.sec_09;

public class Bank {
    private Customer[] customers;  //用于保存多个客户
    private int numOfCustomer;  //用于记录存储客户的个数

    public Bank() {
        customers = new Customer[10];
    }

    /**
     * 将指定姓名的客户保存在银行客户列表中
     *
     * @param f
     * @param l
     */
    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
//        customers[numOfCustomer] = customer;
//        numOfCustomer++;
        customers[numOfCustomer++] = customer;
    }

    /**
     * 获取指定索引位置上的客户
     *
     * @param index
     * @return
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= numOfCustomer) {
            return null;
        }
        return customers[index];
    }

    /**
     * 获取客户列表中客户个数
     *
     * @return
     */
    public int getNumOfCustomer() {
        return numOfCustomer;
    }
}
