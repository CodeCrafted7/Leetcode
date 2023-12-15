
import java.util.*;
 class Bank
{
        String name,type;
        long ac,bl;
        void put_dataa()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name of the Owner : ");
            name = sc.nextLine();
            System.out.println("Enter the Type of Account : ");
            type = sc.nextLine();
            System.out.println("Enter the Account Number : ");
            ac = sc.nextLong();
            System.out.println("Enter the Account Balance : ");
            bl = sc.nextLong();
        }
        void money_deposit()
        {
            Long x;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the amount You have to Deposit : ");
            x = sc.nextLong();
            bl+=x;
        }
        void Money_withdraw()
        {
            Long x;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Money You have to Withdraw : ");
            x = sc.nextLong();
            bl-=x;
        }
}
public class six 
{
    public static void main(String[] args) 
    {
        Bank b = new Bank();
        b.put_dataa();
        b.money_deposit();
        b.Money_withdraw();

    }
}