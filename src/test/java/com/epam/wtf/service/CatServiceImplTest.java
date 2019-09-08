package com.epam.wtf.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.verification.MoreThanAllowedActualInvocations;
import org.mockito.exceptions.verification.TooFewActualInvocations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatServiceImplTest {

    @Mock
    private CatService catService;

    @InjectMocks
    CatServiceImpl cats = new CatServiceImpl(catService);

    @Test
    public void testAdd() {
        when(cats.add(1.0, 6.0)).thenReturn(7.0);

        assertEquals(7.0, cats.add(1, 6), 0);

        verify(catService).add(1.0, 6.0);
        doReturn(15.0).when(catService).add(1.0, 14.0);

        assertEquals(15.0 ,catService.add(1.0, 14.0), 0);

        verify(catService).add(1.0, 14.0);
    }

    @Test(expected = MoreThanAllowedActualInvocations.class)
    public void testCallmethod() {
        when(catService.subtract(15.0, 25.0)).thenReturn(10.0);
        when(catService.subtract(35.0, 25.0)).thenReturn(-10.0);

        assertEquals(10.0, catService.subtract(15.0, 25.0), 0);
        assertEquals(10.0, catService.subtract(15.0, 25.0), 0);

        assertEquals(-10.0, catService.subtract(35.0, 25.0), 0);

        verify(catService, atLeastOnce()).subtract(35.0, 25.0);
        verify(catService, times(2)).subtract(15.0, 25.0);

        verify(catService, never()).divide(10.0, 2.0);

//        verify(catService, atLeast(2)).subtract(35.0, 25.0);

        verify(catService, atMost(1)).subtract(15.0, 25.0);
    }

    @Test(expected = RuntimeException.class)
    public void generateException() {
        when(catService.divide(15.0, 3)).thenReturn(5.0);
        assertEquals(5.0, catService.divide(15.0, 3), 0);

        verify(catService).divide(15.0, 3);
        RuntimeException exception = new RuntimeException("division by zero");
        doThrow(exception).when(catService).divide(15.0, 0);

        assertEquals(0.0, catService.divide(15.0, 0), 0);
        verify(catService).divide(15.0, 0);
    }

    @Test
    public void testTheAnswer() {
        when(catService.add(11.0, 12.0)).thenAnswer(answer);
        assertEquals(23.0, catService.add(11.0, 12.0), 0);
    }

    private Answer<Double> answer = (invocation) -> {
        Object mock = invocation.getMock();

        System.out.println("mock object : " + mock.toString());

        Object[] args = invocation.getArguments();
        double val1 = (Double) args[0];
        double val2 = (Double) args[1];
        double val3 = val1 + val2;
        System.out.println(val1 + " + " + val2);
        return val3;
    };

    @Test
    public void checkSpy() {
        CatServiceImpl sCat = spy(new CatServiceImpl(catService));
        when(sCat.double15()).thenReturn(23.0);

        sCat.double15();

        verify(sCat).double15();

        assertEquals(23.0, sCat.double15(), 0);
        verify(sCat, atLeast(2)).double15();
    }

    @Test
    public void checkJavaClass() {
        Iterator<String> mit = mock(Iterator.class);
        when(mit.next()).thenReturn("Hello").thenReturn("Jack");

        String res = mit.next() + ", " + mit.next();

        assertEquals("Hello, Jack", res);

        Comparable<String> mco = mock(Comparable.class);
        when(mco.compareTo("Mockito")).thenReturn(1);

        assertEquals(1, mco.compareTo("Mockito"));
    }

}
