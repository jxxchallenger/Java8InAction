package io.jxxchallenger.chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        
        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),  
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        List<Transaction> tr2011 = transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(tr2011);
        
        List<String> citys = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(citys);
        
        List<Trader> traders = transactions.stream().map(Transaction::getTrader).distinct().filter(t -> "Cambridge".equals(t.getCity())).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(traders);
        
        String traderStr = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("", String::concat);
        System.out.println(traderStr);
        
        System.out.println(transactions.stream().anyMatch(t -> "Milan".equals(t.getTrader().getCity())));
        
        transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).mapToInt(Transaction::getValue).forEach(System.out::println);
        
        transactions.stream().mapToInt(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
        
        transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1:t2).ifPresent(System.out::println);
        
    }

}
