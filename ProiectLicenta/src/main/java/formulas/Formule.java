/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulas;

import static java.lang.Math.pow;

/**
 *
 * @author gigisan
 */
    
public class Formule {
    public static final int analysisCommission=200; 
    public static final int administrationCommission=7; 
    public static final double earlyReimbursementFee=0.01;
    public static final int NRMA=64;// National register of mobile advertising tax
    public static final int lifeInsurance=100;
    public static final int periodPerYear=12;
    
    public static double computeInterestRate(double amount){
        
        double interestRate;
            if(amount<20000)
                interestRate=8.99;
            else if(amount>20000 &&amount<50000)
                interestRate=9.75;
            else
                interestRate=10.49;
            
        return interestRate;
    }
    public static double computeMonthlyPayment(double loanedAmount,double interestRate, int period){
       double R;
        R=administrationCommission+2*(loanedAmount/(12*period))-loanedAmount/(12*period+(interestRate/100));
       return R;
    }
    public static double computeDAE(double interestRate,int period){
        double DAE;
        switch (period) {
            case 1: 
                DAE=interestRate+earlyReimbursementFee+5;
                break;
            case 2:
                DAE=interestRate+earlyReimbursementFee+3;
                break;
            default:
                DAE=interestRate+earlyReimbursementFee+2;
                break;
        }
        return DAE;
        }
    
    
    public static double computeTotal(double interestRate,double loanedAmount,double period){
    double total;
        total=(loanedAmount/interestRate/100+(loanedAmount+interestRate)/(12*period))*period+analysisCommission+lifeInsurance+administrationCommission+NRMA+loanedAmount;
        return total;
    }
    //VantageScore
    public static int computeScore(double salary,double loanedAmount,int period){
        int score=0;
         switch (period) {
            case 1: 
                score=3;
                break;
            case 2: 
                score=5;
                break;
            case 3: 
                score=7;
                break;
            case 4: 
                score=9;
                break;
            default:
                score=10;
                break;
        }
        
         
         if(salary>10000)
             score=score+70;
         else if(salary<10000&& salary>8000)
             score=score+60;
         else if(salary<8000&& salary>6000)
             score=score+50;
         else if(salary<6000&& salary>4000)
             score=score+40;
         else if(salary<4000&& salary>2000)
             score=score+30;
         else 
             score=score+20;
         
         
          if (loanedAmount < 20000) {
            score = score + 0;
        } else if (loanedAmount > 20000 && loanedAmount < 50000) {
            score = score + 10;
        } else {
            score = score + 20;
        }
          
    return score;
    }
    
    public static String computeClass(int score){
        if(score>=47)
            return "yes";
        else
            return "no";
    }
   
}
