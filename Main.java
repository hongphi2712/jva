import java.util.*;
import java.io.*;

interface Animal{
    void eat();
    void showInfo();
}
interface Bird extends Animal{
    void fly();
}
interface Horse extends Animal{
    void run();
}

class Peagus implements Bird,Horse{
    public String name;
    private int age;
    public Peagus(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }
    public void setAge(){
        this.age = age;
    }

    @Override
    public void eat()
    {
        System.out.println(name + "'s eating");
    }

    @Override
    public void fly()
    {
        System.out.println(name + "'s flying");
    }
    @Override
    public void run()
    {
        System.out.println(name + "'s running");
    }
    @Override
    public void showInfo()
    {
        System.out.println("Name: "+name);
        System.out.println("Age: "+ age);

    }

}
public class Main{
    public static void main(String[] args) {
//        cau1();
//        cau2();
        cau3();
        cau4();
    }
    public static void cau1()
    {
        Peagus p1 = new Peagus("Peagus 1", 5);
        Peagus p2 = new Peagus("Peagus 2", 3);

        p1.eat();
        p1.fly();
        p1.run();
        p2.eat();
        p2.run();
        p2.fly();
    }
    public static void cau2(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Vui lòng nhập họ và tên: ");
            String name = scanner.nextLine();
            System.out.print("Nhập tuổi :");
            int age = scanner.nextInt();
            System.out.println("Họ và tên: "   + name);
            System.out.println("Tuổi: "+ age);
        }
        catch(Exception e)
        {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    public static void cau3() {
        try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("students.txt")))
        {
            writer.write("Nguyễn Hồng Phi\nĐỗ Quang Huân");
        }catch (IOException e)
        {
            System.out.println("Lỗi:" + e.getMessage());
        }
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream("students.txt")))
        {
            int ch;
            while((ch = reader.read()) !=-1) {
                System.out.println((char) ch);
            }
        }catch (IOException e)
        {
            System.out.println("Lỗi:" + e.getMessage());
        }
    }
    public static void cau4(){
        Thread thread1 = new Thread(() -> {
                String name = "Phi";
                Random random = new Random();
                while(true) {
                    char randomChar = name.charAt(random.nextInt(name.length()));
                    System.out.println("Thread 1: " + randomChar);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e ) {
                        e.printStackTrace();
                    }
                }

        });
        Thread thread2 = new Thread(() -> {
            Random random = new Random();
            while(true) {
                int randomInt = random.nextInt(10) - 10;
                System.out.println("Thread 2:" + randomInt);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread1.start();
        thread2.start();
    }
    public static void cau5() {
        ArrayList<Pegasus> list = new ArrayList<>();
        list.add(new Pegasus("Pegasus1", 3));
        list.add(new Pegasus("Pegasus2", 5));

        Map<Integer, Pegasus> map = new HashMap<>();
        int key = 1;
        for (Pegasus p : list) {
            map.put(key++, p);
        }

        for (Map.Entry<Integer, Pegasus> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: ");
            entry.getValue().showInfo();
        }
    }
}

