/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanencoding;

/**
 *
 * @author tensajougan8
 */
public class hashcode
{
    int freq;
    char c;
    hashcode llink;
    hashcode rlink;

    public String ass = "";
    hashcode()
    {
    }
    hashcode(char a, int d)
    {
        c = a;
        freq = d;
       
    }
}
