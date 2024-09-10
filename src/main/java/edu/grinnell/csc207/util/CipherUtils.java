package edu.grinnell.csc207.util;

/**
 * A utility class for performing encryption and decryption using the Caesar and Vigenère ciphers.
 */
public class CipherUtils {

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /** The ASCII value for the lowercase letter 'a'. */
  static final int LOW_MIN = 'a';
  static final int ALPHABET_SIZE = 26;

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Converts a lowercase letter to its corresponding integer value.
   *
   * @param letter The lowercase letter to be converted.
   * @return The integer value corresponding to the given letter.
   */
  private static int letter2int(char letter) {
    // Compute the integer value by subtracting the ASCII value of 'a', so 'a' maps to 0
    int intVal = letter - LOW_MIN;
    return (intVal);
  } // letter2int

  /**
   * Converts an integer value to its corresponding lowercase letter where 0 maps to 'a'.
   *
   * @param i The integer value to be converted.
   * @return The lowercase letter corresponding to the given integer.
   */
  private static char int2letter(int i) {
    // Compute the char value by adding the ASCII value of 'a', so 0 maps to 'a'
    char charVal = (char) (i + LOW_MIN);
    return (charVal);
  } // int2letter

  /**
   * 
   * @param str
   * @param letter
   * @return
   */
  public static String caesarEncrypt(String str, char letter) {
    //encrypt a string consisting of only lowercase letters, using 
    // the given letter as the “key”.

    int key = letter2int(letter);
    int chInt;
    String enStr = "";

    for (int i = 0; i < str.length(); i++) {
      chInt = (letter2int(str.charAt(i)) + key) % ALPHABET_SIZE;
      enStr += int2letter(chInt); 
    } // for
    return enStr; // return the encrypted string
  } // caesarEncrypt

  /**
   *
   * @param str
   * @param letter
   * @return
   */
  public static String caesarDecrypt(String str, char letter) {
      //decrypt a string consisting of only lowercase letters, using 
      // the given letter as the “key”.

      int key = letter2int(letter);
      int chInt;
      String deStr = "";

      for (int i = 0; i < str.length(); i++) {
        chInt = (letter2int(str.charAt(i)) - key) % ALPHABET_SIZE;

        // negative integers do not “wrap around”, so I am fixing the wrap manually.
        if (chInt < 0) {
          chInt = chInt + ALPHABET_SIZE;
        } // if

        deStr += int2letter(chInt); 
      } // for
      return deStr;
  } // caesarDecrypt

  /**
   *
   * @param str
   * @param key
   * @return
   */
  public static String vigenereEncrypt(String str, String key) {
    // to encrypt a string consisting of only lowercase letters,
    // using the given key (which also consists of only lowercase letters).
    String enStr = "";
    int chInt;
    String keyStr = "";

    //replicate the keyword to match the length of the plaintext.
    for (int i = 0; i < (str.length() / key.length()); i++) {
      keyStr += key;
    } // for
    for (int i = 0; i < (str.length() % key.length()); i++) {
      keyStr += key.charAt(i);
    } // for

    //use the character value of the i-th letter of the keyword as 
    // the shift value of the i-th letter of the str
    for (int i = 0; i < str.length(); i++) {
      chInt = (letter2int(str.charAt(i)) + letter2int(keyStr.charAt(i))) % ALPHABET_SIZE;
      enStr += int2letter(chInt); 
    } // for
    return enStr; // return the encrypted string
  } // vigenereEncrypt

  /**
   *
   * @param str
   * @param key
   * @return
   */
  public static String vigenereDecrypt(String str, String key) {
    // to decrypt a string consisting of only lowercase letters,
    // using the given key (which also consists of only lowercase letters).
    String deStr = "", keyStr = "";
    int chInt;

    //replicate the keyword to match the length of the plaintext.
    for (int i = 0; i < (str.length() / key.length()); i++) {
      keyStr += key;
    } // for

    for (int i = 0; i < (str.length() % key.length()); i++) {
      keyStr += key.charAt(i);
    } // for

    //use the character value of the i-th letter of the keyword as 
    // the reverse shift value of the i-th letter of the str
    for (int i = 0; i < str.length(); i++) {
      chInt = (letter2int(str.charAt(i)) - letter2int(keyStr.charAt(i))) % ALPHABET_SIZE;

      // negative integers do not “wrap around”, so I am fixing the wrap manually.
      if (chInt < 0) {
        chInt = chInt + ALPHABET_SIZE;
      } // if

      deStr += int2letter(chInt); 
    } // for
    return deStr; // return the decrypted string
  } // vigenereDecrypt
} // class CipherUtils
