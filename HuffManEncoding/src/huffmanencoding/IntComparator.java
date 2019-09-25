/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanencoding;

import java.util.Comparator;

/**
 *
 * @author MScIT19
 */
class IntComparator implements Comparator<hashcode>
{
    @Override
    public int compare(hashcode o1, hashcode o2) 
    {
        if(o1.freq < o2.freq) 
            return o1.freq;
        else 
            return o2.freq;
    }
}
