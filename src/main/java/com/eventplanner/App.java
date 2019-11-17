package com.eventplanner;

import com.eventplanner.common.Month;
import com.eventplanner.implementation.SimpleMonth;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Month m = new SimpleMonth();
        m.print();
    }
}
