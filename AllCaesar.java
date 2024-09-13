package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if(!(args.length == 2)) {
      System.err.printf("Error: Incorrect number of parameters.\n");
    } else if(args.length == 2) {
      String str0 = args[0];
      String str1 = args[1];
      if(CipherUtils.caseChecker(str1)) {

        if(str0.equals("encode")) { 
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str1, ch));
          } //for
        } else if(str0.equals("decode")) { 
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str1, ch));
          } //for
        } else {
          System.err.printf("Error: Invalid option: \"%s\". Valid options are \"encode\" or \"decode\".\n", str0);
        } //else
      } //if
      else {
        System.err.printf("Error: String contains characters other than lowercase letters.\n");
      } //else

        pen.close();
    } // else if
  } //main
} //AllCaesar

