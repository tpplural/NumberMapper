package org.tpatola.thetask.dataaccess;
import static org.junit.jupiter.api.Assertions.*;
import org.tpatola.thetask.common.TaskConstants;
import java.util.List;
import java.util.Map;


@org.springframework.boot.test.context.SpringBootTest
class SimpleDataProviderImplTest {

       @org.springframework.beans.factory.annotation.Autowired
    private DataProvider instance;

        @org.junit.jupiter.api.Test
    void testCorrectInput(){
        //given
        String category= org.tpatola.thetask.common.TaskConstants.SUPPORTED_COLLECTIONS.get(0);
        //when
            Map<Integer,String>  result= instance.provideMappingForKey(category);
        //then
        assertTrue(result.size() == TaskConstants.MAXIMUM_MAPPING_RANGE);

    }

    @org.junit.jupiter.api.Test
    void testIncorrectCategory(){
        //given
        String category= "Nonexistant";
        //when
        //then
        assertThrows(java.security.InvalidParameterException.class, () ->{
            instance.provideMappingForKey(category);
        });

    }
    @org.junit.jupiter.api.Test
    void testNullInput(){
        //given
        String category= "";
        //when
        //then
        assertThrows(java.security.InvalidParameterException.class, () ->{
            instance.provideMappingForKey(category);
        });
    }

    @org.junit.jupiter.api.Test
    void testEmptyInput(){
        //given
        String category= null;
        //when
        //then
        assertThrows(java.security.InvalidParameterException.class, () ->{
            instance.provideMappingForKey(category);
        });
    }
  
}
