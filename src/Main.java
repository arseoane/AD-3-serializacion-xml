import java.io.*;

class producto implements Serializable {
    String nome;
    int num1;
    double num2;

    public producto() {
    }

    public producto(String nome, int num1, double num2) {
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            producto p1 = new producto("Ordenador", 10, 599.99);

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("serial")
            );

            oos.writeObject(p1);
            oos.close();

            producto p2;

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("serial")
            );

            p2 = (producto) ois.readObject();
            ois.close();

            System.out.println("Nome: " + p2.nome);
            System.out.println("Num1: " + p2.num1);
            System.out.println("Num2: " + p2.num2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}