/**
 *  CSC-207-02 (Fall)
 *  Mini-Project 1: Classical encryption
 *  Maral Bat-Erdene
 *  2024-09-10
 */

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

  /** The number of letters in the English alphabet,
   *  used to handle wrapping around the end of the alphabet. */
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
   * Encrypts a string using the Caesar cipher with the given key letter.
   *
   * @param str The string to be encrypted. Must consist of only lowercase letters.
   * @param letter The letter used as the key for encryption.
   * @return The encrypted string. Returns an empty string for invalid inputs.
   */
  public static String caesarEncrypt(String str, char letter) {
    //encrypt a string consisting of only lowercase letters, using
    // the given letter as the “key”.

    int key = letter2int(letter);
    int chInt;
    String enStr = "";

    // Check if the input string is empty (edge case handling)
    if (str.equals(enStr)) {
      return enStr;
    } // if

    // Iterate over each character in the input string
    for (int i = 0; i < str.length(); i++) {
      chInt = (letter2int(str.charAt(i)) + key) % ALPHABET_SIZE;
      enStr += int2letter(chInt);
    } // for
    return enStr; // return the encrypted string
  } // caesarEncrypt

  /**
   * Decrypts a string encrypted with the Caesar cipher using the given key letter.
   *
   * @param str The string to be decrypted. Must consist of only lowercase letters.
   * @param letter The letter used as the key for decryption.
   * @return The decrypted string. Returns an empty string for invalid inputs.
   */
  public static String caesarDecrypt(String str, char letter) {
    //decrypt a string consisting of only lowercase letters, using
    // the given letter as the “key”.

    int key = letter2int(letter);
    int chInt;
    String deStr = "";

    // Check if the input string is empty (edge case handling)
    if (str.equals(deStr)) {
      return deStr;
    } // if

    // Iterate over each character in the input string
    for (int i = 0; i < str.length(); i++) {
      chInt = (letter2int(str.charAt(i)) - key) % ALPHABET_SIZE;

      // Handle negative values resulting from the modulo operation
      if (chInt < 0) {
        chInt = chInt + ALPHABET_SIZE;
      } // if

      deStr += int2letter(chInt);
    } // for
    return deStr;
  } // caesarDecrypt

  /**
   * Encrypts a string using the Vigenère cipher with the given key.
   *
   * @param str The string to be encrypted. Must consist of only lowercase letters.
   * @param key The key used for encryption. Must consist of only lowercase letters.
   * @return The encrypted string. Returns an empty string for invalid inputs.
   */
  public static String vigenereEncrypt(String str, String key) {
    // to encrypt a string consisting of only lowercase letters,
    // using the given key (which also consists of only lowercase letters).
    String enStr = "";
    int chInt;
    String keyStr = "";

    // Replicate the keyword to match the length of the plaintext
    // First, repeat the entire keyword to cover most of the plaintext length
    for (int i = 0; i < (str.length() / key.length()); i++) {
      keyStr += key;
    } // for

    // Append the remaining part of the keyword needed to match the plaintext length
    for (int i = 0; i < (str.length() % key.length()); i++) {
      keyStr += key.charAt(i);
    } // for

    // Encrypt each character of the plaintext using the
    // corresponding character of the keyword
    for (int i = 0; i < str.length(); i++) {
      chInt = (letter2int(str.charAt(i)) + letter2int(keyStr.charAt(i))) % ALPHABET_SIZE;
      enStr += int2letter(chInt);
    } // for
    return enStr; // return the encrypted string
  } // vigenereEncrypt

  /**
   * Decrypts a string encrypted with the Vigenère cipher using the given key.
   *
   * @param str The string to be decrypted. Must consist of only lowercase letters.
   * @param key The key used for decryption. Must consist of only lowercase letters.
   * @return The decrypted string. Returns an empty string for invalid inputs.
   */
  public static String vigenereDecrypt(String str, String key) {
    // to decrypt a string consisting of only lowercase letters,
    // using the given key (which also consists of only lowercase letters).
    String deStr = "";
    String keyStr = "";
    int chInt;

    // Replicate the keyword to match the length of the plaintext
    // Repeat the entire keyword enough times to cover most of the plaintext length
    for (int i = 0; i < (str.length() / key.length()); i++) {
      keyStr += key;
    } // for

    // Append the remaining part of the keyword needed to match the plaintext length
    for (int i = 0; i < (str.length() % key.length()); i++) {
      keyStr += key.charAt(i);
    } // for

    // Decrypt each character of the ciphertext using
    // the corresponding character of the keyword
    for (int i = 0; i < str.length(); i++) {
      chInt = (letter2int(str.charAt(i)) - letter2int(keyStr.charAt(i))) % ALPHABET_SIZE;

      // Handle negative values resulting from the modulo operation
      if (chInt < 0) {
        chInt = chInt + ALPHABET_SIZE;
      } // if

      deStr += int2letter(chInt);
    } // for
    return deStr; // return the decrypted string
  } // vigenereDecrypt
} // class CipherUtils
