/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.cvs;

import escola.Secretaria;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import util.cvs.testes.Student;
import utilizadores.Utilizador;

/**
 *
 * @author dcsilva
 */
public class CsvManagement {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    //CSV file header
    private static final String FILE_HEADER = "id,firstName,lastName,gender,age";
    private Secretaria secretaria;

    public CsvManagement(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public static void writeCsvFile(String fileName) {

        //Create new students objects
        Student student1 = new Student(1, "Ahmed", "Mohamed", "M", 25);
        Student student2 = new Student(2, "Sara", "Said", "F", 23);
        Student student3 = new Student(3, "Ali", "Hassan", "M", 24);
        Student student4 = new Student(4, "Sama", "Karim", "F", 20);
        Student student5 = new Student(5, "Khaled", "Mohamed", "M", 22);
        Student student6 = new Student(6, "Ghada", "Sarhan", "F", 21);

        //Create a new list of student objects
        List<Student> students = new ArrayList();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            //Write a new student object list to the CSV file
            for (Student student : students) {
                fileWriter.append(String.valueOf(student.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student.getFirstName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student.getLastName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(student.getAge()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    /**
     * Método para salvar o users
     */
    public void salvarUtilizadores() {
        String FILE_HEADER = "id, nome, idade, telemovel, email, morada, username, password, tipo";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("Utilizadores.csv");
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            //Write a new student object list to the CSV file
            for (Utilizador u : secretaria.getUtilizadores()) {
                fileWriter.append(String.valueOf(u.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(u.getNome());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(u.getIdade()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(u.getTelemovel());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(u.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(u.getMorada());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(u.getUsername());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(u.getPassword());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(u.getTipo().toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Utilizadores salvos com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar os utilizadores!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
    
//    public void readCsvFile() {
//    //Delimiter used in CSV file
//    String COMMA_DELIMITER = ",";
//    //Student attributes index
//    //String FILE_HEADER = "id, nome, idade, telemovel, email, morada, username, password, tipo";
//    int STUDENT_ID_IDX = 0;
//    int STUDENT_FNAME_IDX = 1;
//    int STUDENT_IDADE_IDX = 2;
//    int STUDENT_TELEMOVEL = 3;
//    int STUDENT_EMAIL = 4;
//        
//        BufferedReader fileReader = null;
//        try {
//            //Create a new list of student to be filled by CSV file data
//            List<Student> students = new ArrayList();
//            String line = "";
//            //Create the file reader
//            fileReader = new BufferedReader(new FileReader(fileName));
//            //Read the CSV file header to skip it
//            fileReader.readLine();
//            //Read the file line by line starting from the second line
//            while ((line = fileReader.readLine()) != null) {
//                //Get all tokens available in line
//                String[] tokens = line.split(COMMA_DELIMITER);
//                if (tokens.length > 0) {
//                    //Create a new student object and fill his  data
////                    Student student = new Student(Long.parseLong(tokens[STUDENT_ID_IDX]), tokens[STUDENT_FNAME_IDX], tokens[STUDENT_LNAME_IDX], tokens[STUDENT_GENDER], Integer.parseInt(tokens[STUDENT_AGE]));
////                    students.add(student);
//                }
//            }
//            //Print the new student list
//            for (Student student : students) {
//                System.out.println(student.toString());
//            }
//        
//        } catch (Exception e) {
//            System.out.println("Error in CsvFileReader !!!");
//            e.printStackTrace();
//        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException e) {
//                System.out.println("Error while closing fileReader !!!");
//                e.printStackTrace();
//            }
//        }
//    }
    

//    public void salvarDisciplinas() {
//        String FILE_HEADER = "id, nome, idade, telemovel, email, morada, username, password, tipo";
//        FileWriter fileWriter = null;
//
//        try {
//            fileWriter = new FileWriter("Utilizadores.csv");
//            //Write the CSV file header
//            fileWriter.append(FILE_HEADER.toString());
//            //Add a new line separator after the header
//            fileWriter.append(NEW_LINE_SEPARATOR);
//            //Write a new student object list to the CSV file
//            for (Utilizador u : secretaria.getUtilizadores()) {
//                fileWriter.append(String.valueOf(u.getId()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(u.getNome());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(String.valueOf(u.getIdade()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(u.getTelemovel());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(u.getEmail());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(u.getMorada());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(u.getUsername());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(u.getPassword());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(u.getTipo().toString());
//                fileWriter.append(NEW_LINE_SEPARATOR);
//            }
//            System.out.println("Utilizadores salvos com sucesso!");
//        } catch (Exception e) {
//            System.out.println("Erro ao salvar os utilizadores!!");
//            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("Error while flushing/closing fileWriter !!!");
//                e.printStackTrace();
//            }
//        }
//    }

}
