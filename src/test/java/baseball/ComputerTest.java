package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    @Test
    void 세자리_정수_확인(){
        //given
        Computer computer = new Computer();
        List<Integer> given = computer.generateRandomNumber();

        assertEquals(given.size(), 3);
    }

    @Test
    void 중복_안된_정수_확인(){
        //given
        Computer computer = new Computer();
        List<Integer> given = computer.generateRandomNumber();

        HashSet<Integer> set = new HashSet<>(){{
           add(given.get(0));
           add(given.get(1));
           add(given.get(2));
        }};

        assertEquals(set.size(), 3);
    }

}