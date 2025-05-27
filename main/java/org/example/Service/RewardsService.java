package org.example.Service;

import  org.example.Exception.RewardsCalculationException;
import org.example.Model.CustomerReward;
import org.example.Model.MonthlyReward;
import org.example.Model.Transaction;
import org.example.data.MockTransactionData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Component
public class RewardsService
   {
    public List<CustomerReward> calculateRewards( )
    {
        List<Transaction> transactions= MockTransactionData.getTransactions();
          List<CustomerReward> rewardsList=new ArrayList<>();
          Map<String,List<Transaction>> groupingtxns=transactions.
                                                     stream().
                                                     collect(Collectors.groupingBy
                                                             (Transaction::getCustomerId));
          for(Map.Entry<String,List<Transaction>> entry:groupingtxns.entrySet())
          {
              String CustId=entry.getKey();
              List<Transaction> CustTxns=entry.getValue();
              String CustName=CustTxns.get(0).getCustomerName();

              Map<String,Integer> MonthlyPoints=new HashMap<>();
              int totalPoints=0;

              for(Transaction txn:CustTxns)
              {
                  int point=CalculatePoints(txn.getAmount());
                  String month= txn.getDate().getMonth() + " " + txn.getDate().getYear();;
                  MonthlyPoints.put(month, MonthlyPoints.getOrDefault(month, 0) + point);
                  totalPoints=totalPoints+point;
              }
              List<MonthlyReward> monthrewards=MonthlyPoints.entrySet()
                      .stream()
                      .map(e -> new MonthlyReward
                              (e.getKey(), e.getValue()))
                      .collect(Collectors.toList());

              rewardsList.add(new CustomerReward(CustId,CustName,monthrewards,totalPoints));
          }
          return rewardsList;

    }

       public int CalculatePoints(double amount) {
        int points=0;

           if (amount < 0)
           {
              throw  new RewardsCalculationException("Transaction amount cannot be negative.");
           }

           if(amount>100)
        {
            points= (int) (points+((amount-100)*2));
            points=points+50;
        }
        else if (amount>50)
        {
            points=(int)(points+(amount-50));
        }
        return points;

       }

   }
