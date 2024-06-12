package org.example;

import org.example.menu.ConsoleMenu;
import org.example.models.Company;


public class Main {
    public static void main(String[] args) {
        // Create a Company instance
        Company myCompany = new Company();

        // Create a ConsoleMenu instance
        ConsoleMenu menu = new ConsoleMenu(myCompany);

        // Present menu options
        menu.presentOptions();
    }
}