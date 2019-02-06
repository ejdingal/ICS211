/**
 * FileDump.java
 * Copyright (c) Emeri Joe Dingal 2018
 */
package edu.ics211.h00;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Emeri Joe Dingal. Received help from TA & ATA. Worked with Eddie Wen, Derrick Luyen, Kade Shiroma, Kason
 * Shiroma, Angeli Amascual, Russel John Alegre. Uses some code from textbook. Uses some code from StackOverflow @ (1)
 * https://stackoverflow.com/a/4469748 && (2) https://stackoverflow.com/a/15124135. Single line comments within are
 * mostly for my own notes. The problem is to read from a file and print out the contents of a file in binary,
 * hexadecimal, and in UTF-8
 */
public class FileDump {

  /**
   * This program will read in a file given via the command line and print its contents in Binary, Hexadecimal, and
   * UTF-8.
   * 
   * @param args command line
   */
  public static void main(String[] args) {
    try {
      FileReader file = new FileReader(args[0]);
      printAsBinary(file);
      FileReader fileTwo = new FileReader(args[0]);
      printAsHex(fileTwo);
      FileReader fileThree = new FileReader(args[0]);
      printAsUTF(fileThree);
    }
    catch (FileNotFoundException f) {
      System.err.println(args[0] + " file not found.");
      System.exit(1);
    }

  }


  /**
   * This method prints a file's contents in binary. The method reads in a single byte and prints them out byte-by-byte
   * as binary until all of the file is read and printed. It will space out each byte and create a new line every
   * ten(10) bytes for readablitly.
   * 
   * @param file FileReader to read-in file given by command line
   */
  public static void printAsBinary(FileReader file) {
    try {
      int c; // create a value to store FileReader.read() so i don't accidentally call it more than i need to.
      int bCounter = 0; // create a counter for printing formatting
      System.out.println("File as Binary:");
      do {
        c = file.read(); // reads first character in file and stores it to variable c
        String s = (Integer.toBinaryString(c)); // convert byte into binary
        if (c != (-1)) { // if there is still bytes,
          String st = String.format("%08d", Integer.parseInt(s)); // this line from StackOverflow(1), formats bytes so
                                                                  // that they have padded zeros on the left
          System.out.print(st + " "); // print bytes with space in between
          bCounter += 1; // increment format counter
        }
        if (bCounter == 10) { // if 10 bytes printed
          System.out.print("\n"); // make new line
          bCounter = 0; // reset format counter
        }
      }
      while (c != (-1)); // checks our stored value for read() method.
      System.out.print("\n\n");
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try { // clean up block
      file.close();
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  /**
   * This method prints a file's contents in HexaDecimal. The method reads in a single byte and prints them out
   * byte-by-byte as hexadecimal until all of the file is read and printed. It will space out each byte and create a new
   * line every ten(10) bytes for readablitly. This method is very identical to the printAsBinary(FileReader) method.
   * 
   * @param file FileReader to read-in file given by command line
   */
  public static void printAsHex(FileReader file) {
    try {
      int c;
      int bCounter = 0;
      System.out.println("File as HexaDecimal:");
      do {
        c = file.read();
        String s = Integer.toHexString(c);
        if (c != (-1)) {
          String st = "00".substring(s.length()) + s; // this line from StackOverflow(2), formats bytes so that there is
                                                      // a padded zero on the left
          System.out.print(st + " ");
          bCounter += 1;
        }
        if (bCounter == 10) {
          System.out.print("\n");
          bCounter = 0;
        }
      }
      while (c != (-1));
      System.out.print("\n\n");

    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      file.close();
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  /**
   * This method prints a file's contents in UTF-8 Encoding. The method creates a byte array with a length of 1000,
   * doubling its size if it fills up. it then copies each byte from the file into the array. It then creates a new
   * string using UTF-8 encoding and is printed.
   * 
   * @param file FileReader to read-in file given by command line
   */
  public static void printAsUTF(FileReader file) {
    byte[] b = new byte[1000]; // new byte array for later use of String constructor that uses byte array
    try {
      int arrayIndex = 0;
      int c; // used as a check
      byte y; // the actual byte being processed
      do {
        if (arrayIndex == b.length) { // ensures there is enough space in the byte array for more bytes to be read
          b = Arrays.copyOf(b, (b.length * 2));
        }
        c = file.read();
        if (c == -1) {
          // do nothing. without the if & else blocks, would print weird character at the end, similar to a mario [?]
          // block.
        }
        else {
          y = (byte) c;
          b[arrayIndex] = y; // adds the byte into the array
        }

        arrayIndex += 1; // changes index of array
      }
      while (c != (-1));
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      System.out.println("File as UTF-8 encoding:");
      String s = new String(b, "UTF-8");
      System.out.println(s);
    }
    catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try { // clean up block
      b = null;
      file.close();
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
