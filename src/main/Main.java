package main;

import service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuthService auth = new AuthService();
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();

        while (true) {

            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Patient Login");
            System.out.println("3. Doctor Login");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                sc.nextLine();

                System.out.print("Admin Username: ");
                String username = sc.nextLine();

                System.out.print("Admin Password: ");
                String password = sc.nextLine();

                if(auth.adminLogin(username, password)) {
                    System.out.println("Admin Login Successful");
                    adminMenu(sc, patientService, doctorService);
                } else {
                    System.out.println("Invalid Admin Credentials");
                }

                break;

                case 2:
                    System.out.print("Patient ID: ");
                    int pid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Password: ");
                    String ppass = sc.nextLine();

                    if (auth.patientLogin(pid, ppass)) {
                        System.out.println("Login Successful");
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;

                case 3:
                    System.out.print("Doctor ID: ");
                    int did = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Password: ");
                    String dpass = sc.nextLine();

                    if (auth.doctorLogin(did, dpass)) {
                        System.out.println("Login Successful");
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;

                case 4:
                    System.exit(0);

            }
        }
    }

    public static void adminMenu(Scanner sc, PatientService patientService, DoctorService doctorService) {

        while (true) {

            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    patientService.addPatient();
                    break;

                case 2:
                    doctorService.addDoctor();
                    break;

                case 3:
                    return;
            }
        }
    }
}