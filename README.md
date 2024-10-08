CSC 207 - 02 (Fall)
Mini-Project 1: Classical encryption

Name: Maral Bat-Erdene
Date: 09/07/2024

Project Description:
This project takes inputs from the command-line for encrypting and decrypting messages using encryption methods Caesar and Vigenre.

What It Does:
 Caesar Cipher: Shifts each letter in the message by a fixed number of positions, called a key, in the alphabet.
 Vigenere Cipher: Uses a keyword to shift letters by a fixed number of positions. Each letter in the message is shifted based on the corresponding letter in the keyword.
How Do You Use It:
 You run the program from the command line, providing parameters for what action to take (encode or decode), which cipher to use, the message, and a key.
    Example command: java edu.grinnell.csc207.main.Cipher -encode -caesar helloworld a
    This command would encode the message "helloworld" using the Caesar cipher with a shift of 'a'.

 Verification: The program checks that all inputs follow the rules: 1) Ensures the message and key contain only lowercase letters. 2) Verify that the Caesar cipher key is a single character.

 Output: Based on your input, the program will print the encoded or decoded message or error message when input didn't follow the rules.

Resources:
StackExchange: I used it to learn how to unzip the cipher.zip file. The command unzip "file.zip -d destination_folder" was particularly helpful.
Geeksforgeeks: I used it to learn how to work with command line arguments, how to compare two strings and how to change all letters to lowercase in java. Ex: The command args[0] is used to access the first string in the command line. And use input1.equals(input2) when equal, and (!input1.equals(input2)) when not equal. Lastly, input.toLowerCase() returns a string value, representing the new string converted to ALL lower case, but ignores numbers, etc.

Link to GitHub: https://github.com/1maral/mini-project-1.git

