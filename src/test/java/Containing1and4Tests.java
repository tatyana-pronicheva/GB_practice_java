import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Containing1and4Tests {
    public static Stream<Arguments> data(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1,2,3,5},false));
        out.add(Arguments.arguments(new int[]{3,2,1,4},true));
        out.add(Arguments.arguments(new int[]{-1,2,4,-4,2},false));
        out.add(Arguments.arguments(new int[]{2,3,5,6},false));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test1(int[] array,boolean b){
        ArrayService arrayService = new ArrayService();
        Assertions.assertEquals(b, arrayService.isArrayContaining4and1(array));
    }

}
