/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfile;
import java.nio.file.*;; 
/**
 *
 * @author Student
 */
public class Readfile {

  public static String readFileAsString(String fileName)throws Exception 
  { 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 
  
  public static void main(String[] args) throws Exception 
  { 
    String data = readFileAsString("D:\\tr.txt"); 
    System.out.println(data); 
  } 
} 
