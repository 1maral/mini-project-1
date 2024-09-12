/**
 *  CSC-207-02 (Fall)
 *  Mini-Project 1: Classical encryption
 *  Maral Bat-Erdene
 *  2024-09-10
 */

package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * A class to list out Caesar cipher encoding and decoding with all possible char keys.
 */
public class AllCaesar {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * The main method processes command-line arguments to perform Caesar cipher encoding or decoding
   * for a given string using all possible single-character keys.
   *
   * Expects two arguments: an action ("encode" or "decode") and
   * a string consisting of lowercase letters.
   * @param args Command-line arguments: [action, string]
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Check if exactly two arguments are provided
    if (args.length == 2) {
      String str = args[1];

      // Validate that the string contains only lowercase letters
      for (char c: str.toCharArray()) {
        if (!(c >= 'a' && c <= 'z')) {
          System.err.println("Error: String contains characters other than lowercase letters.\n");
          return;
        } // if
      } // for

      // Perform the requested action
      if (args[0].equals("encode")) {
        // Encode the string using all single-character keys from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
        } // for
      } else if (args[0].equals("decode")) {
        // Decode the string using all single-character keys from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
        } // for
      } else {
        // Handle invalid action options
        System.err.println("Error: Invalid option: \"" + args[0]
            + "\". Valid options are \"encode\" or \"decode\".");
        return;
      } // else

    } else {
      // Handle incorrect number of arguments
      System.err.println("Error: Incorrect number of parameters.\n");
      return;
    } // else

    pen.close();
  } // main
} // class AllCaesar
