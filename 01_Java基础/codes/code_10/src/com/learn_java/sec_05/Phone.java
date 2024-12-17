package com.learn_java.sec_05;

class Phone implements Comparable {
    String name;
    double price;

    public Phone() {
    }

    public Phone(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //当前类需要实现Comparable接口中的抽象方法compareTo(Object o)
    //在此方法中指明如何判断当前类的大小，比如按照价格排序
//    @Override
//    public int compareTo(Object o) {
//        if (o == this) {
//            return 0;
//        } else if (o instanceof Phone) {
//            Phone p = (Phone) o;
//            return Double.compare(this.price, p.price);
//        } else {
//            throw new RuntimeException();
//        }
//    }
    //价格一样按照名称排序，从小到大
//    @Override
//    public int compareTo(Object o) {
//        if (o == this) {
//            return 0;
//        } else if (o instanceof Phone) {
//            Phone p = (Phone) o;
//            int value = Double.compare(this.price, p.price);
//            if (value != 0) {
//                return value;
//            } else {
//                return this.name.compareTo(p.name);
//            }
//        } else {
//            throw new RuntimeException();
//        }
//    }
    //从大到小
    @Override
    public int compareTo(Object o) {
        if (o == this) {
            return 0;
        } else if (o instanceof Phone) {
            Phone p = (Phone) o;
            int value = Double.compare(this.price, p.price);
            if (value != 0) {
                return -value;
            } else {
                return -this.name.compareTo(p.name);
            }
        } else {
            throw new RuntimeException();
        }
    }
}
