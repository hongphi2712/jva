//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        cau3();
        cau4();
    }

    public static void cau1() {
        Peagus p1 = new Peagus("Peagus 1", 5);
        Peagus p2 = new Peagus("Peagus 2", 3);
        p1.eat();
        p1.fly();
        p1.run();
        p2.eat();
        p2.run();
        p2.fly();
    }

    public static void cau2() {
        try {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Vui lòng nhập họ và tên: ");
                String name = scanner.nextLine();
                System.out.print("Nhập tuổi :");
                int age = scanner.nextInt();
                System.out.println("Họ và tên: " + name);
                System.out.println("Tuổi: " + age);
            } catch (Throwable var4) {
                try {
                    scanner.close();
                } catch (Throwable var3) {
                    var4.addSuppressed(var3);
                }

                throw var4;
            }

            scanner.close();
        } catch (Exception var5) {
            System.out.println("Lỗi: " + var5.getMessage());
        }

    }

    public static void cau3() {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("students.txt"));

            try {
                writer.write("Nguyễn Hồng Phi\nĐỗ Quang Huân");
            } catch (Throwable var5) {
                try {
                    writer.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            writer.close();
        } catch (IOException var6) {
            System.out.println("Lỗi:" + var6.getMessage());
        }

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("students.txt"));

            int ch;
            try {
                while((ch = reader.read()) != -1) {
                    System.out.println((char)ch);
                }
            } catch (Throwable var7) {
                try {
                    reader.close();
                } catch (Throwable var3) {
                    var7.addSuppressed(var3);
                }

                throw var7;
            }

            reader.close();
        } catch (IOException var8) {
            System.out.println("Lỗi:" + var8.getMessage());
        }

    }

    public static void cau4() {
        Thread thread1 = new Thread(() -> {
            String name = "Phi";
            Random random = new Random();

            while(true) {
                char randomChar = name.charAt(random.nextInt(name.length()));
                System.out.println("Thread 1: " + randomChar);

                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException var4) {
                    var4.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            Random random = new Random();

            while(true) {
                int randomInt = random.nextInt(10) - 10;
                System.out.println("Thread 2:" + randomInt);

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException var3) {
                    var3.printStackTrace();
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
