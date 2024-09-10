package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length == 2) { 
      String str = args[1];

      for (char c: str.toCharArray()){
        if (!(c >= 'a' && c<= 'z')){
          System.err.println("Error: String contains characters other than lowercase letters.\n");
          return;
        }
      }

      if (args[0].equals("encode")){
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
        }
      }
      else if (args[0].equals("decode")){
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
        }
      }
      else{
      System.err.println("Error: Invalid option: \"" + args[0] + "\". Valid options are \"encode\" or \"decode\".");
      return;
      }
    }
    else{
      System.err.println("Error: Incorrect number of parameters.\n");
      return;
    }

    pen.close();
  }
}
