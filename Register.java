
import java.util.Map;
import java.util.Scanner;

public class Register {

    //Declare the denominations
     private static Denomination[] types = new Denomination[] {new Denomination("Hundred-Dollar",100,"bill",".png"),new Denomination("Fifty-Dollar",50,"bill",".png"),
                                                       new Denomination("Twenty-Dollar",20,"bill",".png"),new Denomination("Ten-Dollar",10,"bill",".png"),
                                                       new Denomination("Five-Dollar",5,"bill",".png"), new Denomination("One-Dollar",1,"bill",".png"),
                                                       new Denomination("Quarter",0.25,"coin",".png"),new Denomination("Dime",0.1,"coin",".png"),
                                                       new Denomination("Nickel",0.05,"coin",".png"),new Denomination("Penny",0.01,"coin",".png")};

    //private Purse p = new Purse();

    public Purse makeChange(double amt) {


        Purse p = new Purse();
        // Number of Denominations
        double numD = 0.0;

        //Check if the amount can be divided by each Denomination. Add to the purse and subtract from the amount if so
        for(Denomination n: types) {
            numD = amt/n.amt();
            if(numD >= 1)
            {
                p.add(n,(int)numD);
                (amt)-=n.amt()*(int)numD;
            }

        }
        return p;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Amount: ");
        double amt = input.nextDouble();

       Purse p = new Register().makeChange(amt);

        System.out.println(p.getValue());
        if(p.getValue() == 0)
        {
            System.out.println("Empty Purse.");
        }



        for(Denomination n: types) {
            if(p.getCash().containsKey(n)){
                if(p.getCash().get(n) > 0) {
                    System.out.println(p.getCash().get(n) + " " + n.name());
                }

            }
        }


    }
}
