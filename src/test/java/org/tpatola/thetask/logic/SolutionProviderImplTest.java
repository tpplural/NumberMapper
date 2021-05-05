package org.tpatola.thetask.logic;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tpatola.thetask.common.TaskConstants;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SolutionProviderImplTest {

    @Autowired
    private SolutionProvider instance;
    public static final Integer ELEVEN = Integer.valueOf(11);
    public static final Integer TWELVE = Integer.valueOf(12);

    @Test
    void testAmountOfDivisors(){
        //given
        String category= org.tpatola.thetask.common.TaskConstants.SUPPORTED_COLLECTIONS.get(0);
        List<Integer> values = List.of(ELEVEN, TWELVE);
        //when
        Map<Integer, List<String>>  result = instance.getDividersWithMappings(values,category);
        //then
        assertEquals(2,result.get(ELEVEN).size());
        assertEquals(6,result.get(TWELVE).size());

    }

    @Test
    void testContentOfCategorization(){
        //given
        String category= TaskConstants.SUPPORTED_COLLECTIONS.get(0);
        List<Integer> values = List.of(TWELVE);
        //when
        Map<Integer, List<String>>  result = instance.getDividersWithMappings(values,category);
        //then
        assertEquals(6,result.get(TWELVE).size());
        for (String subresult : result.get(TWELVE)){
            assertTrue(subresult.startsWith(category));
        }

    }

    @Test
    void testNullCategory(){
        //given
        String category= null;
        List<Integer> values = List.of(Integer.valueOf(12));
        //when
        //then
        assertThrows(java.security.InvalidParameterException.class, () ->{
            instance.getDividersWithMappings(values,category);
        });
    }
}
