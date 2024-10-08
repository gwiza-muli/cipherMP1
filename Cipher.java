// Sheilla Muligande
// Course: CSC207-01
// Instructor: Sam Rebelsky
// Date:9/14/2024
// File: Cipher.java

package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * An implementation of the Caesar and Vigenere Ciphers.
 *
 * @author Sheilla Muligande
 */
public class Cipher {

  /** The default/required number of arguments, 4. */
  private static final int EXPECTED_NUM_PARAMS = 4;

  /**
   * implements a Caesar or vigenere cipher.
   *
   * @param args the different parts of the cipher, which are the word to be en/deciphered, the
   *        action(encipher or decipher), the key which we will use to en/decipher, and the type of
   *        cipher (caesar or vigenere).
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String action = "";
    String key = "";
    String cipher = "";
    String word = "";
    if (args.length != EXPECTED_NUM_PARAMS) {
      System.err.println("Error: Invalid number of parameters. Please enter 4 parameters.");
      return;
    } else {
      for (int i = 0; i < args.length; i++) {
        if (args[i].length() != 0 && args[i].charAt(0) == '-') {
          if ((args[i].equals("-encode")) || args[i].equals("-decode")) {
            if (action.isEmpty()) {
              action = CipherUtils.dashRemover(args[i]);
            } else {
              System.err.println("Error: You can't give more than one action.");
              return;
            } // if
          } else if ((args[i].equals("-vigenere")) || args[i].equals("-caesar")) {
            if (cipher.isEmpty()) {
              cipher = CipherUtils.dashRemover(args[i]);
            } else {
              System.err.println("Error: You can't give more than one cypher type.");
              return;
            } // else
          } // if
        } else {
          if (!(CipherUtils.alphaNumericChecker(args[i]))) {
            System.err.println("Error: string must be a lowercase letter.");
            return;
          } else if (word.isEmpty()) {
            word = args[i];
          } else if (key.isEmpty()) {
            if (cipher.equals("caesar") || cipher.equals("vigenere")) {
              if (!args[i].isEmpty()) {
                key = args[i];
              } else {
                System.err.println("Error: Empty keys are not permitted");
                return;
              } // if
            } else {
              key = args[i];
            } // else
          } // else if
        } // if
      } // for

      if (cipher.equals("caesar") && ((key.length() == 1))) {

        if (action.equals("encode")) {
          System.out.printf("%s", CipherUtils.caesarEncrypt(word, key.charAt(0)));
        } else if (action.equals("decode")) {
          System.out.printf("%s", CipherUtils.caesarDecrypt(word, key.charAt(0)));
        } else {
          System.err
              .println("No valid action specified.  Legal values are '-encode' and '-decode'");
        } // else
      } else if (cipher.equals("caesar") && (!(key.length() == 1))) {
        System.err.println("Error: Your key must be 1 character long for Caesar Ciphers.");
        return;
      } // if
      if (cipher.equals("vigenere")) {
        if (action.equals("encode")) {
          System.out.printf("%s", CipherUtils.vigenereEncrypt(word, key));
        } else if (action.equals("decode")) {
          System.out.printf("%s", CipherUtils.vigenereDecrypt(word, key));
        } else {
          System.err
              .println("No valid action specified.  Legal values are '-encode' and '-decode'");
          return;
        } // if
      } // if

    } // else


    pen.close();
  } // main
} // Cipher


