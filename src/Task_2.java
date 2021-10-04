import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*Вариант 11. Задание 2. Вывести сведения о товарах, срок годности которых менее 20-ти дней.
Определить количество просроченных товаров.*/
public class Task_2
{
    private static final Scanner scanner = new Scanner(System.in);
    private String product_name, producer, production_date, expiration_date;
    private int quantity, price;
    private long diff_between_dates;
    private boolean expired;

    private static void writeExpired(Task_2[] products, int size)
    {
        int count = 0;

        System.out.println("Expired products:");
        for(int i = 0; i < size; i++)
        {
            if(products[i].getExpired())
            {
                System.out.println("Product №" + (i + 1)+". Name: " + products[i].getProduct_name() + ", Producer: " + products[i].getProducer());
                System.out.println("Quantity: " + products[i].getQuantity() + ", Price: " + products[i].getPrice());
                System.out.println("Production date: " + products[i].getProduction_date() + ", Expiration date: " + products[i].getExpiration_date());
                System.out.println("Difference between dates: " + products[i].getDiff_between_dates());
                System.out.println();
                count++;
            }
        }
        if(count == 0)
            System.out.println("There are no expired products among these.");
    }
    private boolean isExpiredGoods(LocalDate expiration_date, LocalDate today)
    {
        if(today.isAfter(expiration_date))
            return true;
        else
            return false;
    }
    private static void dateDifference(Task_2[] products, int size)
    {
        int count = 0;

        System.out.println("Products with the expiration date less than 20 days:");
        for(int i = 0; i < size; i++)
        {
            if(products[i].getDiff_between_dates() < 20)
            {
                System.out.println("Product №" + (i + 1)+". Name: " + products[i].getProduct_name() + ", Producer: " + products[i].getProducer());
                System.out.println("Quantity: " + products[i].getQuantity() + ", Price: " + products[i].getPrice());
                System.out.println("Production date: " + products[i].getProduction_date() + ", Expiration date: " + products[i].getExpiration_date());
                System.out.println("Difference between dates: " + products[i].getDiff_between_dates());
                System.out.println();
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("Was not found products with the expiration date less than 20 days");
            System.out.println();
        }
    }
    private static void allInfo(Task_2[] products, int size)
    {
        for(int i = 0; i < size; i++)
        {
            System.out.println("Product №" + (i + 1)+". Name: " + products[i].getProduct_name() + ", Producer: " + products[i].getProducer());
            System.out.println("Quantity: " + products[i].getQuantity() + ", Price: " + products[i].getPrice());
            System.out.println("Production date: " + products[i].getProduction_date() + ", Expiration date: " + products[i].getExpiration_date());
            System.out.println("Difference between dates: " + products[i].getDiff_between_dates());
            System.out.println();
        }
    }
    private boolean isCorrectString(String name)
    {
        if(name.matches("^[a-zA-Z]+$"))
            return true;
        else
            return false;
    }
    private int isCorrectInt()
    {
        int number = 0;
        do
        {
            try
            {
                System.out.print("Input a correct number(>0): ");
                number = scanner.nextInt();
                System.out.println();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue;
            }
        }while(number <= 0);
        scanner.nextLine();

        return number;
    }
    public boolean getExpired()
    { return expired; }
    public void setExpired(boolean expired)
    { this.expired = expired; }
    public long getDiff_between_dates()
    { return diff_between_dates; }
    public void setDiff_between_dates(long diff_between_dates)
    { this.diff_between_dates=diff_between_dates; }
    public int getQuantity()
    { return quantity; }
    public void setQuantity()
    { this.quantity=isCorrectInt(); }
    public int getPrice()
    { return price; }
    public void setPrice()
    { this.price=isCorrectInt(); }
    public String getExpiration_date()
    { return expiration_date; }
    public void setExpiration_date(String expiration_date)
    { this.expiration_date = expiration_date; }
    public String getProduction_date()
    { return production_date; }
    public void setProduction_date(String production_date)
    { this.production_date = production_date; }
    public String getProducer()
    { return producer; }
    public boolean setProducer(String producer)
    {
        if(isCorrectString(producer))
        {
            this.producer = producer;
            return true;
        }
        else
            return false;
    }
    public String getProduct_name()
    { return product_name; }
    public boolean setProduct_name(String product_name)
    {
        if(isCorrectString(product_name))
        {
            this.product_name = product_name;
            return true;
        }
        else
            return false;
    }

    public static void task_2()
    {
        String product_name, producer;
        int size = 0, year, months, day;

        do
        {
            try {
                System.out.print("Input a count of products: ");
                size = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue;
            }
        } while(size <= 0);
        scanner.nextLine();
        System.out.println();

        Task_2[] products = new Task_2[size];
        Random random = new Random();
        LocalDate today = LocalDate.now();
        LocalDate production_date = LocalDate.now();
        LocalDate expiration_date;

        for(int i = 0; i < size; i++)
        {
            products[i] = new Task_2();

            do
            {
                System.out.print("Input a name of product number " + (i + 1) + ": ");
                product_name=scanner.nextLine();
            }while(!products[i].setProduct_name(product_name));
            System.out.println();
            do
            {
                System.out.print("Input a producer name: ");
                producer=scanner.nextLine();
            }while(!products[i].setProducer(producer));
            System.out.println();

            System.out.println("Quantity of the product units");
            products[i].setQuantity();
            System.out.println("Price of the product");
            products[i].setPrice();

            day=production_date.getDayOfMonth();
            months=production_date.getMonthValue();
            year=production_date.getYear();
            products[i].setProduction_date(Integer.toString(day) + "." + Integer.toString(months) + "." + Integer.toString(year));

            expiration_date = production_date.plusDays(random.nextInt(20) + 10);
            day=expiration_date.getDayOfMonth();
            months=expiration_date.getMonthValue();
            year=expiration_date.getYear();
            products[i].setExpiration_date(Integer.toString(day) + "." + Integer.toString(months) + "." + Integer.toString(year));

            products[i].setExpired(products[i].isExpiredGoods(expiration_date, today));
            products[i].setDiff_between_dates(ChronoUnit.DAYS.between(production_date, expiration_date));
            production_date = production_date.minusDays(10);
        }

        Task_2.allInfo(products, size);
        Task_2.dateDifference(products, size);
        Task_2.writeExpired(products, size);
        System.out.println();
    }
}