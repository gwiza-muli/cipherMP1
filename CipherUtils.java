package edu.grinnell.csc207.util;

import java.lang.String;

public class CipherUtils {
  private static int letter2int(char letter) {  
    int base = (int) 'a';
    int number = (int) letter - base; 
    return number;
  } // letter2int


  private static char int2letter(int i) { 
    int base = (int) 'a';
    char character = (char) (i + base);
    return character; 
  }// int2letter

  public static String caesarEncrypt(String str, char letter) { //which uses the Caeser Cipher to encrypt a string consisting of only lowercase letters, using the given letter as the “key”.
    char[] encryptedWord = str.toCharArray();
    int len = str.length();
    for (int i = 0; i < len ; i++){
      encryptedWord[i] = int2letter(((letter2int(encryptedWord[i])) + (letter2int(letter))) % 26);
    }// for

     String encryptedString = new String(encryptedWord);
     return encryptedString; 
  }//caesarEncrypt

  public static String caesarDecrypt(String str, char letter) { //which uses the Caeser Cipher to encrypt a string consisting of only lowercase letters, using the given letter as the “key”.
    char[] encryptedWord = str.toCharArray();
    int len = str.length();
    for (int i = 0; i < len ; i++){
      encryptedWord[i] = int2letter(((letter2int(encryptedWord[i])) - (letter2int(letter)) + 26) % 26);
    }// for

     //String decryptedString = String.valueOf(encryptedWord);
     String decryptedString = new String(encryptedWord);
    return decryptedString; 
  }//caesarDecrypt


  public static String vigenereEncrypt(String str, String key) {
    int strLength = str.length();
    int keyLength = key.length();
    char[] oldKeyArray = key.toCharArray();
    char[] stringArray = str.toCharArray();
    char[] keyArray = new char[strLength];
    char cipheredArray[]= new char[str.length()];

    for (int i = 0, j = 0; i < strLength; i++, j++){
      if (j >= keyLength){
        j = 0;
      }// if
      keyArray[i] = oldKeyArray[j];
    }// for

    for (int x = 0; x < strLength; x++){
      cipheredArray[x] = int2letter((letter2int(keyArray[x]) + (letter2int(stringArray[x]))) % 26);
    }//for

    String cipheredString = new String(cipheredArray);
    return cipheredString;
  }//vigenereEncrypt


  public static String vigenereDecrypt(String str, String key) {
    int strLength = str.length();
    int keyLength = key.length();
    char[] oldKeyArray = key.toCharArray();
    char[] stringArray = str.toCharArray();
    char[] keyArray = new char[strLength];
    char decipheredArray[]= new char[str.length()];

    for (int i = 0, j = 0; i < strLength; i++, j++){
      if (j >= keyLength){
        j = 0;
      }// if
      keyArray[i] = oldKeyArray[j];
    }// for

    for (int x = 0; x < strLength; x++){
      decipheredArray[x] = int2letter(((letter2int(stringArray[x]) - letter2int(keyArray[x])) + 26) % 26);
    }//for

    String decipheredString = new String(decipheredArray);
    return decipheredString;
  }

  public static boolean caseChecker(String str) {
    int stringLength = str.length();
    char[] stringArray = str.toCharArray();
    for(int i = 0; i < stringLength; i++){
      if (! (stringArray[i] >= 'a' && stringArray[i] <= 'z')){
        return false;
      }
    }
    return true;
  }

  public static String dashRemover(String str){
    String newStr = str.substring(1);
    return newStr;
  }

 

  public static void main(String[] args){
    //vigenereDecrypt("jeanolqraf", "cap");
  }
}
