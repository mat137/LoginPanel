package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    Validator validator = new Validator();

    String testMailFail = "nowakmail.pl";
    String testMailSuccess = "nowak@mail.pl";

    String testNameFail = "ba";
    String testNameSuccess = "bartek";

    String testPhoneNumberFail = "555 888 777";
    String testPhoneNumberSuccess = "555111888";

    // E-mail
    @Test
    public void testValidateMailOnFail(){

        // should fail
        boolean resultF = validator.validateMail(testMailFail);
        assertEquals(false, resultF);

    }
    @Test
    public void testValidateMailOnSuccess(){

        // should success
        boolean resultS = validator.validateMail(testMailSuccess);
        assertEquals(true, resultS);
    }

    // Name
    @Test
    public void testValidateNameOnFail(){

        // should fail
        boolean resultF = validator.validateName(testNameFail);
        assertEquals(false, resultF);

    }
    @Test
    public void testValidateNameOnSuccess(){

        // should success
        boolean resultS = validator.validateName(testNameSuccess);
        assertEquals(true, resultS);
    }

    // phone number
    @Test
    public void testValidatePhoneNumberOnFail(){

        // should fail
        boolean resultF = validator.validatePhoneNumber(testPhoneNumberFail);
        assertEquals(false, resultF);

    }
    @Test
    public void testValidatePhoneNumberOnSuccess(){

        // should success
        boolean resultS = validator.validatePhoneNumber(testPhoneNumberSuccess);
        assertEquals(true, resultS);
    }

}