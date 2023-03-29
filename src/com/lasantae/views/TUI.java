package com.lasantae.views;

import password.generator.data.Wordlist;
import password.generator.generators.PassphraseGenerator;
import password.generator.generators.PasswordGenerator;

import java.io.File;

public class TUI {
    public static void launch(String[] args) {
        /*
         * USAGE: java -jar passgen.jar (passphrase or password)
         * IF PASSPHRASE:
         * java -jar passgen.jar passphrase (number of words) (word delimiter)
         * (t for title case, l for lowercase or u for uppercase )
         *
         * Example: java -jar passgen.jar passphrase 4 - t
         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         * IF PASSWORD:
         * java -jar passgen.jar password (length) (true or false if include uppercase characters)
         * (true or false if include lowercase characters) (true or false if include symbols)
         * (true or false if include numbers)
         *
         * Example: java -jar passgen.jar password 20 true true false true
         */


        /*
         * Check which password type to generate.
         */

        String passwordType = args[0];
        if (!(passwordType.equals("passphrase")) && !(passwordType.equals("password"))) {
            printGeneralUsage();
            return;
        }

        if (passwordType.equals("passphrase")) {
            // TODO: Check if every arg required was passed to args.
            if (args.length != 4) {
                printPassphraseUsage();
                return;
            }

            String passphrase = generatePassphrase(args); // returns null if no password
            if (passphrase == null) {
                printPassphraseUsage();
                return;
            }

            System.out.println(passphrase);
            return;
        }


        if (passwordType.equals("password")) {
            // TODO: Check if every arg required was passed to args.
            if (args.length != 6) {
                printPasswordUsage();
                return;
            }

            String password = generatePassword(args); // returns null if no password
            if (password == null) {
                printPasswordUsage();
                return;
            }

            System.out.println(password);
            return;
        }

    }

    private static String generatePassphrase(String[] args) {
        /*
         * Wordlist must be in the folder alongisde the .jar /resources/wordlists/(wordlist).txt.
         */
        File wordlistFile = new File("./resources/wordlists/eff_long_wordlist.txt");

        Wordlist wordlist = Wordlist.instantiate(wordlistFile);
        /*
         * Get the number of words in the passphrase from args[1]
         */
        int numWords = 0;
        try {
            numWords = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            printGeneralUsage();
            return null;
        }

        final String USER_INPUT_TEXT_CASE = args[3];

        final PassphraseGenerator.Cases CASE_TO_USE =
                switch (USER_INPUT_TEXT_CASE) {
                    case "t" -> PassphraseGenerator.Cases.TITLE_CASE;
                    case "l" -> PassphraseGenerator.Cases.LOWERCASE;
                    case "u" -> PassphraseGenerator.Cases.UPPERCASE;
                    default -> throw new IllegalArgumentException("Unexpected value: " + USER_INPUT_TEXT_CASE);
                };


        return PassphraseGenerator.getPassphrase(wordlist, numWords, args[2], CASE_TO_USE);

    }

    private static String generatePassword(String[] args) {
        int length = 0;
        try {
            length = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            printPasswordUsage();
            return null;
        }

        boolean includeUppercase = Boolean.parseBoolean(args[2]);
        boolean includeLowercase = Boolean.parseBoolean(args[3]);
        boolean includeSymbols = Boolean.parseBoolean(args[4]);
        boolean includeNumbers = Boolean.parseBoolean(args[5]);

        return PasswordGenerator.getPassword(length, includeUppercase, includeLowercase, includeSymbols, includeNumbers);
    }

    private static void printGeneralUsage() {
        System.out.println("""
                USAGE: java -jar passgen.jar (passphrase or password)
                
                PASSPHRASE USAGE:
                java -jar passgen.jar passphrase (number of words) (word delimiter) (t for title case, l for lowercase or u for uppercase)
                Example: java -jar passgen.jar passphrase 4 - t
                
                PASSWORD USAGE:
                java -jar passgen.jar password (length) (true or false if include uppercase characters) (true or false if include lowercase characters) (true or false if include symbols) (true or false if include numbers)
                Example: java -jar passgen.jar password 20 true true false true
                """);
    }
    private static void printPassphraseUsage() {
        System.out.println("""
        PASSPHRASE USAGE:
        java -jar passgen.jar passphrase (number of words) (word delimiter) (t for title case, l for lowercase or u for uppercase)
        Example: java -jar passgen.jar passphrase 4 - t
        """);
    }
    private static void printPasswordUsage() {
        System.out.println("""
        PASSWORD USAGE:
        java -jar passgen.jar password (length) (true or false if include uppercase characters) (true or false if include lowercase characters) (true or false if include symbols) (true or false if include numbers)
        Example: java -jar passgen.jar password 20 true true false true
        """);
    }
}
