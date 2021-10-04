import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

/*Вариант 11. Задание 1. Определить среднюю стоимость товаров и товар с
минимальной стоимостью.*/
public class Task_1
{
    private static final Scanner scanner = new Scanner(System.in);
    private String product_name, producer, date;
    private int quantity, price;

    private static void minPrice(Task_1[] products, int size)
    {
        int min = products[0].getPrice(), min_index = 0;
        for(int i = 0; i < size; i++)
        {
            if(products[i].getPrice() < min)
            {
                min = products[i].getPrice();
                min_index = i;
            }
        }
        System.out.println("Product with a minimal cost has an index " + (min_index + 1));
    }
    private static void averageCost(Task_1[] products, int size)
    {
        float average_cost = 0;
        for(int i = 0; i < size; i++)
            average_cost += products[i].getPrice();
        average_cost /= size;
        System.out.println("Average cost of all products: " + average_cost);
    }
    private static void allInfo(Task_1[] products, int size)
    {
        for(int i = 0; i < size; i++)
        {
            System.out.println("Product №" + (i + 1)+". Name: " + products[i].getProduct_name() + ", Producer: " + products[i].getProducer());
            System.out.println("Quantity: " + products[i].getQuantity() + ", Price: " + products[i].getPrice() + ", Release date: " + products[i].getDate());
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
    public int getQuantity()
    { return quantity; }
    public void setQuantity()
    { this.quantity=isCorrectInt(); }
    public int getPrice()
    { return price; }
    public void setPrice()
    { this.price=isCorrectInt(); }
    public String getDate()
    { return date; }
    public void setDate(String date)
    { this.date = date; }
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

    public static void task_1()
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

        Task_1[] products = new Task_1[size];
        LocalDate date = LocalDate.now();

        for(int i = 0; i < size; i++)
        {
            products[i] = new Task_1();

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

            day=date.getDayOfMonth();
            months=date.getMonthValue();
            year=date.getYear();
            products[i].setDate(Integer.toString(day) + "-" + Integer.toString(months) + "-" + Integer.toString(year));
            date = date.minusDays(5);
        }

        Task_1.allInfo(products, size);
        Task_1.averageCost(products, size);
        Task_1.minPrice(products, size);
        System.out.println();
    }
}