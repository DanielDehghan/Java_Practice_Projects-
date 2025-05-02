package Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager{
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner (System.in);

    public void run(){
        int choice;
        do{
           System.out.println("");
           System.out.println("1. Add Student");
           System.out.println("2. Show All Students");
           System.out.println("3. Search by ID");
           System.out.println("4. Delete by ID");
           System.out.println("5. Exit");
           System.out.println("Enter Choice: ");
           choice = scanner.nextInt();
           scanner.nextLine();
           
           switch(choice){
            case 1: addStudent(); break;
            case 2: showAll(); break;
            case 3: searchById(); break;
            case 4: deleteById(); break;
            case 5: System.out.println("Goodbye!"); break;
            default: System.out.println("Invalid choice!");
           }
           
        }while(choice != 5);
    }

    private void addStudent(){
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Grade: ");
        double grade = scanner.nextDouble();

        students.add(new Student(id, name, grade));
        System.out.println("Student added successfully");
    }

    private void showAll(){
     if(students.isEmpty()){
        System.out.println("No Students to show.");
     }else{
        System.out.println("--- All Students ---");
        for (Student s: students){
            System.out.println(s);
        }
     }
    }
    private void searchById(){
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        for (Student s: students){
            if(s.getId() == id){
                System.out.println("Found: "+ s);
                return;
            }
        }
        System.out.println("Student not found.");
    }
    
    private void deleteById(){
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        Student toRemove = null;
        for(Student s: students){
            if(s.getId() == id){
                toRemove = s;
                break;
            }
        }
        if(toRemove != null){
            students.remove(toRemove);
            System.out.println("Student deleted.");
        }else{
            System.out.println("Student not found.@interface");
        }
    }

    public static void main(String[] args){
       new StudentManager().run();
    }
}