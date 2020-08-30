import java.util.Scanner;
class Dog {
    private String name;
    private int age;
    
    public Dog()
    {
        name = "";
        age = 0;
    }
    
    public void inputName()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter dog's name: ");
        name = scan.nextLine();
        System.out.print("Enter dog's age: ");
        age = scan.nextInt();
    }
    
    public float getAge()
    {
        return (float)age/7;
    }
    
    public String toString()
    {
        return "Name of the dog: " + name + "\nAge of the dog (person years): " + getAge();
    }
}

public class DogMain {
    public static void main(String[] args)
    {
        Dog dog1 = new Dog();
        dog1.inputName();
        System.out.println(dog1);
    }
}
