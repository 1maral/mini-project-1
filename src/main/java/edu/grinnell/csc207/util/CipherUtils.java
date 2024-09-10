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
    int int_val = letter - LOW_MIN;
    return (int_val);
  } // letter2int

  /**
   * Converts an integer value to its corresponding lowercase letter where 0 maps to 'a'.
   *
   * @param i The integer value to be converted.
   * @return The lowercase letter corresponding to the given integer.
   */
  private static char int2letter(int i) {
    // Compute the char value by adding the ASCII value of 'a', so 0 maps to 'a'
    char char_val = (char) (i + LOW_MIN);
    return (char_val);
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
    int ch_int;
    String en_str = "";

    for (int i = 0; i < str.length(); i++){
      ch_int = (letter2int(str.charAt(i)) + key) % 26;
      en_str += int2letter(ch_int); 
    }
    return en_str; // return the encrypted string
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
      int ch_int;
      String de_str = "";

      for (int i = 0; i < str.length(); i++){
        ch_int = (letter2int(str.charAt(i)) - key) % 26;

        // negative integers do not “wrap around”, so I am fixing the wrap manually.
        if (ch_int < 0){
          ch_int = ch_int + 26;
        }

        de_str += int2letter(ch_int); 
      }
      return de_str; // return the decrypted string
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
    String en_str = "";
    int ch_int;
    String key_str = "";

    //replicate the keyword to match the length of the plaintext.
    for (int i = 0; i < (str.length() / key.length()); i++){
      key_str += key;
    }
    for (int i = 0; i < (str.length() % key.length()); i++){
      key_str += key.charAt(i);
    }

    //use the character value of the i-th letter of the keyword as 
    // the shift value of the i-th letter of the str
    for (int i = 0; i < str.length(); i++){
      ch_int = (letter2int(str.charAt(i)) + letter2int(key_str.charAt(i))) % 26;
      en_str += int2letter(ch_int); 
    }
    
    return en_str; // return the encrypted string
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
    String de_str = "", key_str = "";
    int ch_int;

    //replicate the keyword to match the length of the plaintext.
    for (int i = 0; i < (str.length() / key.length()); i++){
      key_str += key;
    }
    for (int i = 0; i < (str.length() % key.length()); i++){
      key_str += key.charAt(i);
    }

    //use the character value of the i-th letter of the keyword as 
    // the reverse shift value of the i-th letter of the str
    for (int i = 0; i < str.length(); i++){
      ch_int = (letter2int(str.charAt(i)) - letter2int(key_str.charAt(i))) % 26;

      // negative integers do not “wrap around”, so I am fixing the wrap manually.
      if (ch_int < 0){
        ch_int = ch_int + 26;
      }

      de_str += int2letter(ch_int); 
    }
    return de_str; // return the decrypted string
  } // vigenereDecrypt
} // class CipherUtils
