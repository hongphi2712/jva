import java.util.*;
import java.io.*;

interface Animal{
    void eat();
    String showInfo();
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
    public String showInfo()
    {
        return "Name: " + name + ", Age: " + age;
    }

    }
public class Main{
    public static void main(String[] args) {
        cau1();
        cau2();
        cau3();
        cau4();
        cau5();
    }
    public static void cau1()
    {
        Peagus p1 = new Peagus("Peagus 1", 5);
        Peagus p2 = new Peagus("Peagus 2", 3);

        p1.eat();
        p1.fly();
        p1.run();
        System.out.println(p1.showInfo());
        p2.eat();
        p2.run();
        p2.fly();
        System.out.println(p2.showInfo());
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
    public static void cau5()
    {
        ArrayList<Peagus> list =   new ArrayList<>();
        list.add(new Peagus("Peagus 1",3));
        list.add(new Peagus("Peagus 2",5));

        Map<Integer,Peagus> map = new HashMap();
        int key = 1;
        for(Peagus p : list)
        {
            map.put(key++,p);
        }

        for(Map.Entry<Integer,Peagus> entry : map.entrySet())
        {
            System.out.println("Key: "+ entry.getKey() + ",Value: " + entry.getValue().showInfo());
        }
    }
}


// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;

interface IStaff{
    void work();
}
interface IStudent{
    void study();
}
abstract class People{
    public String name;
    private int age;
    protected String ID;
    String birthDate;

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public abstract void showInfo();
    public People(String name,int age,String ID,String birthDate)
    {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.birthDate = birthDate;
    }
}
class NEUStudent extends People implements IStaff, IStudent {
    protected String studentID;
    public NEUStudent(String name,int age,String ID,String studentID,String birthDate)
    {
        super(name,age,ID,birthDate);
        this.studentID = studentID;
    }

    @Override
    public void showInfo()
    {
        System.out.println("-------------");
        System.out.println("Name: "+name);
        System.out.println("Age: "+getAge());
        System.out.println("ID: "+ID);
        System.out.println("StudentID: "+ studentID);
        System.out.println("BirthDate: "+birthDate);

    }

    @Override
    public void work()
    {
        System.out.println(name + "is working");
    }
    @Override
    public void study()
    {
        System.out.println(name + "is studying");
    }
}

public class Main
{
    public static void cau1()
    {
        NEUStudent s1 = new NEUStudent("Phi",20,"ID1","SV01","27-12-2005");
        NEUStudent s2 = new NEUStudent("Ly",20,"ID2","SV02","26-11-2005");
        NEUStudent s3 = new NEUStudent("Linh",20,"ID3","SV03","22-10-2005");

        s1.showInfo();
        s1.work();
        s1.study();

        s2.showInfo();
        s2.work();
        s2.study();

        s3.showInfo();
        s3.work();
        s3.study();
    }
    public static void cau2()
    {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Nhập số phần tử :");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++)
            {
                System.out.println("Nhập phần tử thứ "+ (i+1) +":");
                arr[i] = scanner.nextInt();
            }
            System.out.println("Bạn muốn xem phần tử số mấy :");
            int index = scanner.nextInt();
            System.out.println("Phần tử tại vị trí: "+index +": "+arr[index]);
        }catch (Exception e)
        {
            System.out.println("Lỗi: "+e.getMessage());
        }
    }

    public static void cau3() {
        try(DataOutputStream writer = new DataOutputStream(new FileOutputStream("data.txt")))
        {
            writer.writeInt(5);
            writer.writeInt(8);
        }catch(IOException e)
        {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }

        try(DataInputStream reader = new DataInputStream(new FileInputStream("data.txt")))
        {
            int a = reader.readInt();
            int b = reader.readInt();
            System.out.println("Tổng :"+ (a+b));
        }catch(IOException e)
        {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }

    }
    public static void cau4()
    {
        Thread thread1 = new Thread(() -> {
                Random random = new Random();
                while (true)
                {
                    int a = random.nextInt();
                    System.out.println("Thread 1:"+ a)   ;

                    try{
                        Thread.sleep(5000);
                    }catch(InterruptedException e)
                    {
                        System.out.println("Thread 1 lỗi");
                    }
                }

        });
        Thread thread2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            int sum = 0;

            while (true)
            {
                System.out.println("vui lòng nhập vào 1 số nguyên , nếu muốn dừng nhấn 0 :");
                int a = scanner.nextInt();
                if(a ==0)break;
                sum = sum + a;
            }
            System.out.println("Tổng các số đã nhập: " + sum);
        });

        thread1.start();
        thread2.start();

    }
    public static void cau5() {
        ArrayList<NEUStudent> list = new ArrayList<>();

        NEUStudent s1 = new NEUStudent("Nguyen Van A", 20, "ID001", "2005-05-01", "SV001");
        NEUStudent s2 = new NEUStudent("Le Thi B", 21, "ID002", "2004-03-15", "SV002");
        NEUStudent s3 = new NEUStudent("Tran Van C", 19, "ID003", "2006-08-20", "SV003");

        NEUStudent s4 = new NEUStudent("Nguyen Van A", 20, "ID001", "2005-05-01", "SV004");
        NEUStudent s5 = new NEUStudent("Le Thi B", 21, "ID002", "2004-03-15", "SV005");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        Map<Integer,NEUStudent> map = new HashMap<>();
            int key = 1;
            for(NEUStudent s : list)
            {
                map.put(key++,s);
            }
            for(Map.Entry<Integer,NEUStudent> entry : map.entrySet())
            {
                System.out.printf("Key: " + entry.getKey() +"\nValue :");
                entry.getValue().showInfo();

            }


    }
    public static void main(String[] args)
    {
//        cau1();
//        cau2();
//        cau3();
//        cau4();
        cau5();
    }
}

