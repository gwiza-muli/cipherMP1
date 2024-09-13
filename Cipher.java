//header

package edu.grinnell.csc207.main;

import java.io.PrintWriter;
//import java.util.*;
import java.lang.String;
import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String action = "";
    String key = "";
    String cipher = "";
    String word = "";
    int maxLength = 4;
    if (args.length != maxLength){
      System.err.println("Error: Invalid number of parameters. Please enter 4 parameters.");
    }//if
    else{
    for (int i = 0; i < args.length; i++) {
      pen.printf("args[%d] = \"%s\"\n", i, args[i]); // what is the purpose of this line?
      if (args[i].charAt(0) == '-' ){
        if ((args[i].equals("-encode")) || args[i].equals("-decode")){
          if (action.isEmpty()){
          action = CipherUtils.dashRemover(args[i]);
          }//if
          else {
            System.err.println("Error: You can't give more than one action.");
          }
        }//if
          
        else if ((args[i].equals("-vigenere")) || args[i].equals("-caesar")){
          if (cipher.isEmpty()){
            cipher = CipherUtils.dashRemover(args[i]);
          }//if
          else {
            System.err.println("Error: You can't give more than one cypher type.");
          }
        }//if
      }//if it starts with a dash.
      
      else if (word.isEmpty()){
        word = args[i];
      }// else if

      else if (key.isEmpty()){
        key = args[i];
      }//else if

      // else {
      //   System.err.println("Error: You have entered too many arguments.");
      // }// else
    }
      
      if (cipher.equals("caesar")){
        if (key.length() == 1){
          if (action.equals("encode")){
            System.out.println(CipherUtils.caesarEncrypt(word,key.charAt(0)));
          }// if
          else if (action.equals("decode")){
            System.out.println(CipherUtils.caesarDecrypt(word,key.charAt(0)));
          }// else if
        }
        else{
          System.err.println("Error: Your key must be 1 character long for Caesar Ciphers.");
        }
      }

      if (cipher.equals("vigenere")){
          if (action.equals("encode")){
            System.out.println(CipherUtils.vigenereEncrypt(word, key));
          }// if
          else if (action.equals("decode")){
            System.out.println (CipherUtils.vigenereDecrypt(word,key));
          }// else if
    
      }
      }//else

      
    pen.close();
    // System.err.println("Error: Invalid parameters");
  }
}

