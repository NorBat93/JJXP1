package com.wmi;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListaMieszkancowTest {

    @Test
    public void instacjaTest() throws Exception{
        ListaMieszkancow lista1 = ListaMieszkancow.instacja("test");
        ListaMieszkancow lista2 = ListaMieszkancow.instacja("test2");
        assertTrue(lista1==lista2);
    }
}