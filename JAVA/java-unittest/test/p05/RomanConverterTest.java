package p05;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class RomanConverterTest {

    RomanConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new RomanConverter();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void exceptionWhenRomanNotSet(){
        thrown.expect(ArithmeticException.class);

        int actualResult = converter.transform();
    }

    @Test
    public void converI(){
        converter.setRoman("I");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(1)));
    }

    @Test
    public void converX(){
        converter.setRoman("X");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(10)));
    }

    @Test
    public void converIII(){
        converter.setRoman("III");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(3)));
    }

    @Test
    public void converIV(){
        converter.setRoman("IV");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(3)));
    }

    @Test
    public void converIV(){
        converter.setRoman("IV");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(3)));
    }


}