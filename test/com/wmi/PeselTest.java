package com.wmi;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeselTest {

    @Test
    public void czyPeselJestOK() throws Exception{
        assertTrue( Pesel.sprawdz("91071023584") );
        assertTrue( Pesel.sprawdz("77073049663") );
        assertTrue( Pesel.sprawdz("89050471666") );
        assertFalse( Pesel.sprawdz("95050716261") );
        assertFalse( Pesel.sprawdz("77073049633") );

    }
}