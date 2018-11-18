package com.luokp.java8Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Chapter5 {
    class Trader{
        private final String name;
        private final String city;

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Trader{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return trader;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "trader=" + trader +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {

        Trader raoul = new Chapter5().new Trader("Raoul", "Cambridge");
        Trader mario = new Chapter5().new Trader("Mario", "Milan");
        Trader alan = new Chapter5().new Trader("Alan", "Cambridge");
        Trader brian = new Chapter5().new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(new Transaction[]{
                new Chapter5().new Transaction(brian, 2011, 300),
                new Chapter5().new Transaction(raoul, 2012, 1000),
                new Chapter5().new Transaction(raoul, 2011, 400),
                new Chapter5().new Transaction(mario, 2012, 700),
                new Chapter5().new Transaction(mario, 2012, 710),
                new Chapter5().new Transaction(alan, 2012, 950),
        });



        //2011发生的所有交易，并按交易顺序排序
        List<Transaction> tra1 = transactions.stream()
                                    .filter(x -> x.getYear() == 2011)
                                    .sorted(comparing(Transaction::getValue))
                                    .collect(Collectors.toList());
        //交易员的城市
        List<String> city = transactions.stream()
                                    .map(x -> x.getTrader().getCity())
                                    .distinct()
                                    .collect(Collectors.toList());
        //查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader>  traders = transactions.stream()
                                    .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                                    .map(x -> x.getTrader())
                                    .distinct()
                                    .sorted()
                                    .collect(Collectors.toList());
        //返回所有交易员的姓名字符串，并按字母顺序排序
        String names = transactions.stream()
                                    .map(x -> x.getTrader().getName())
                                    .distinct()
                                    .sorted()
                                    .reduce("", (a, b) -> a+b );

        //有没有交易员在米兰工作的
        Boolean workAtMilan = transactions.stream()
                                    .anyMatch(x -> x.getTrader().getCity().equals("Milan"));
        //打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                                    .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                                    .map(Transaction::getValue)
                                    .forEach(System.out::println);
        //所有交易中最高的交易额
        Optional<Integer> maxValue = transactions.stream()
                                    .map(x -> x.getValue())
                                    .reduce(Integer::max);
        //交易额最小的交易
        Optional<Integer> minValueTransaction = transactions.stream()
                                    .map(x -> x.getValue())
                                    .min((Integer a, Integer b) -> a < b ? a : b );

    }
}
