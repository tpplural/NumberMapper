package org.tpatola.thetask.validation;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.tpatola.thetask.common.TaskConstants;

@SpringBootTest
class InputValidatorImplTest {


    @Autowired
    private InputValidator instance;

    @Test
    void testCorrectInput(){
        //given
        String category= TaskConstants.SUPPORTED_COLLECTIONS.get(0);
        List<Integer> vals= List.of(Integer.valueOf(2));
        //when
        List<String> warnings= instance.validateInput(category,vals);
        //then
        assertTrue(warnings.size() == 0);

    }

    @Test
    void testCorrectInputMultiple(){
        //given
        String category= TaskConstants.SUPPORTED_COLLECTIONS.get(0);
        List<Integer> vals= List.of(Integer.valueOf(2),Integer.valueOf(15),Integer.valueOf(12));
        //when
        List<String> warnings= instance.validateInput(category,vals);
        //then
        assertTrue(warnings.size() == 0);

    }

    @Test
    void testIncorrectCategory(){
        //given
        String category= "Nonexistant";
        List<Integer> vals= List.of(Integer.valueOf(2));
        //when
        List<String> warnings= instance.validateInput(category,vals);
        //then
        assertEquals(1,warnings.size());
        assertTrue(warnings.get(0).contains("Category parameter value [Nonexistant] is not known."));



    }
    @Test
    void testIncorrectVals(){
        //given
        String category= "Furniture";
        List<Integer> vals= List.of(Integer.valueOf(112));
        //when
        List<String> warnings= instance.validateInput(category,vals);
        //then
        assertEquals(1,warnings.size(),1);
        assertEquals("parameter value of 112 is invalid.",warnings.get(0));

    }
    @Test
    void testEmptyVals(){
        //given
        String category= "Furniture";
        List<Integer> vals= new java.util.ArrayList();
        //when
        List<String> warnings= instance.validateInput(category,vals);
        //then
        assertEquals(1,warnings.size());
        assertEquals("value parameter  is required.",warnings.get(0));

    }
    @Test
    void testEmptyCategory(){
        //given
        String category= null;
        List<Integer> vals= List.of(Integer.valueOf(2));
        //when
        List<String> warnings= instance.validateInput(category,vals);
        //then
        assertTrue(warnings.size() == 1);
        assertEquals("Category parameter value is required.",warnings.get(0));


    }
    @Test
    void testSomeWrongVals(){
        //given
        String category= "Furniture";
        List<Integer> vals= List.of(Integer.valueOf(2),Integer.valueOf(215),Integer.valueOf(145));
        //when
        List<String> warnings= instance.validateInput(category,vals);
        //then
        assertTrue(warnings.size() == 2);

    }
  
}
