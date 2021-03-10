import org.junit.Assert;
import org.junit.Test;

public class MarkResult {
    /*Ученик может заработать максимум 100 баллов, минимум 0.
Его оценка за экзамен может принимать значения 2, 3, 4 или 5.

Если ученик получил за экзамен:
— от 0 баллов (включительно) до 35 (включительно), его оценка равна 2;
— от 35 баллов (не включительно) до 56 (включительно), его оценка равна 3;
— от 56 баллов (не включительно) до 71 (включительно), его оценка равна 4;
— от 72 баллов (включительно) до 100 баллов (включительно), его оценка равна 5.
*/
        @Test
        public void testResultMark(){
            var actualResult = getMarkResult(40);
            var expectedResult = "3";
            Assert.assertEquals(expectedResult, actualResult);
            System.out.println(actualResult);
        }
    @Test
    public void testResultMark2(){
        var actualResult = getMarkResult(45);
        var expectedResult = "3";
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark3(){
        var actualResult = getMarkResult(20);
        var expectedResult = "2";
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark4(){
        var actualResult = getMarkResult(10);
        var expectedResult = "2";
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark5(){
        var actualResult = getMarkResult(5);
        var expectedResult = "2";
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark6(){
        var actualResult = getMarkResult(60);
        var expectedResult = "4";
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark7(){
        var actualResult = getMarkResult(70);
        var expectedResult = "4";
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark8(){
        var actualResult = getMarkResult(80);
        var expectedResult = "5";
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark9(){
        var actualResult = getMarkResult(90);
        var expectedResult = "5";
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark10(){
        var actualResult = getMarkResult(99);
        var expectedResult = "5";
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }
        private String getMarkResult(Integer mark) {
            if (mark >= 0 && mark <= 35) return "2";
            if (mark > 35 && mark <= 56) return "3";
            if (mark > 56 && mark < 71) return "4";
            if (mark > 72 && mark < 100) return "5";
            return "no mark result";
        }
    }

