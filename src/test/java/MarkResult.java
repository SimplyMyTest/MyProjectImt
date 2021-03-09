import org.junit.Test;

public class MarkResult {
        @Test
        public void testResultMark(){
            var actualResult = getMarkResult(40);
            System.out.println(actualResult);
        }
    @Test
    public void testResultMark2(){
        var actualResult = getMarkResult(45);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark3(){
        var actualResult = getMarkResult(20);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark4(){
        var actualResult = getMarkResult(10);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark5(){
        var actualResult = getMarkResult(5);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark6(){
        var actualResult = getMarkResult(60);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark7(){
        var actualResult = getMarkResult(70);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark8(){
        var actualResult = getMarkResult(80);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark9(){
        var actualResult = getMarkResult(90);
        System.out.println(actualResult);
    }
    @Test
    public void testResultMark10(){
        var actualResult = getMarkResult(100);
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

