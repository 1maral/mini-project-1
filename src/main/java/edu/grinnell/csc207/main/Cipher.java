
package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 *  CSC-207-02 (Fall)
 *  Mini-Project 1: Classical encryption
 *  Maral Bat-Erdene
 *  2024-09-10
 */

public class Cipher {
  private static void myCipherCall(PrintWriter pen, String action, String cipher, String str, String key){
    if (cipher.equals("-caesar")) {
      if (action.equals("-encode")) {
        pen.printf("ciphertext: %s\n", CipherUtils.caesarEncrypt(str, key.charAt(0)));
      }
      else if (action.equals("-decode")) {
        pen.printf("plaintext: %s\n", CipherUtils.caesarDecrypt(str, key.charAt(0)));
      }
    }
    else if (cipher.equals("-vigenere")) {
      if (action.equals("-encode")){
        pen.printf("ciphertext: %s\n", CipherUtils.vigenereEncrypt(str, key));
      }
      else if (action.equals("-decode")) {
        pen.printf("plaintext: %s\n", CipherUtils.vigenereDecrypt(str, key));
      }
    }
    else {
      System.err.println("Error: Invalid parameters.");
      return;
    }
  }

  private static boolean myFourArguments(PrintWriter pen, String action, String cipher, String str, String key){
    if (!action.equals("") && !cipher.equals("") && !str.equals("") && !key.equals("")){
      // checking if any field is empty or invalid.
      for (char c: str.toCharArray()) {
        if (!(c >= 'a' && c<= 'z')) {
          System.err.println("Error: String contains characters other than lowercase letters.\n");
          return false;
        }
      }
      if (cipher.equals("-caesar") && key.length()!=1) {
        System.err.println("Error: Caesar key should be a single character.\n");
        return false;
      }
      pen.printf("action: %s, cipher: %s, string: %s, key: %s\n", action, cipher, str, key);
      return true;
    }
    else {
      System.err.println("Error: Invalid parameters, empty field.");
      return false;
    }
  }

  // +------+--------------------------------------------------------
  // | Main |
  // +------+
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String action = "", cipher = "", str = "", key ="";

    if (args.length == 4){
      for (int i = 0; i < args.length; i++) {
        //pen.printf("args[%d] = \"%s\"\n", i, args[i]);
        if ((args[i].equals("-encode")) || (args[i].equals("-decode"))) {
          action = args[i];
        }
        else if ((args[i].equals("-vigenere")) || (args[i].equals("-caesar"))) {
          cipher = args[i];
        }
        else if (str.equals("")){
          str = args[i];
        }
        else {
          key =args[i];
        }
      }

      if (myFourArguments(pen, action, cipher, str, key) == true) {
        myCipherCall(pen, action, cipher, str, key);
      }
    }

    else {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    }
    pen.close();
  } // main
} // class Cipher

//cipher$ mvn compile
//in target classes$ java edu.grinnell.csc207.main.AllCaesar encode "helloworld"