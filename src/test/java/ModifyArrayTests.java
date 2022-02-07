import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ModifyArrayTests {

    ArrayService arrayService;
    @BeforeEach
    public void createArrayService(){
        arrayService = new ArrayService();
    }

    public static Stream<Arguments> data(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1,2,4,4,2,3,4,1,7},new int[]{1,7}));
        out.add(Arguments.arguments(new int[]{1,2,3,4},new int[]{}));
        out.add(Arguments.arguments(new int[]{0,2,4,-4,2},new int[]{-4,2}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test1(int[] array, int[] modifiedArray){
        Assertions.assertTrue(Arrays.equals(modifiedArray, arrayService.modifyArray(array)));
    }

    @Test
    public void test2(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            arrayService.modifyArray(new int[]{0,1,2,3,5,6});
        });
    }
}
