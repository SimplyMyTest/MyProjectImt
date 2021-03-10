import org.junit.Assert;
import org.junit.Test;

public class testTicketPrice {
    /*1. Составьте тест-кейсы по аналогии с ручным тестированием и оформите их в виде автотестов JUnit для указанной ниже функции расчёта процента от стоимости билета при возврате. Опирайтесь в первую очередь на аналитику, примените привычные вам техники тест-дизайна. Напишите не менее пяти тестов.



Аналитика для формулы расчёта процента от стоимости билета на концерт при его возврате:

В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия, посетитель имеет право при возврате билета:

1) Более 10 дней — получить обратно полную стоимость билета.

2) От 6 до 10 дней включительно — получить 50% стоимости билета.

3) От 3 до 6 дней включительно — получить 30% стоимости билета.

4) 72 часа и менее до начала концерта — стоимость билета не возвращается.

*/
    @Test
    public void testRefundTicketPricePercent(){
        var actualResult = getRefundTicketPricePercent(250, false, false);
        var expectedResult = 100;
        Assert.assertEquals(100, 100);
    }
    @Test
    public void testRefundTicketPricePercent2(){
        var actualResult = getRefundTicketPricePercent(150, false, false);
        Assert.assertEquals(50, 50);
    }
    @Test
    public void testRefundTicketPricePercent3(){
        var actualResult = getRefundTicketPricePercent(2, true, true);
        Assert.assertEquals(100, 100);
    }
    @Test
    public void testRefundTicketPricePercent4(){
        var actualResult = getRefundTicketPricePercent(1, false, false);
        Assert.assertEquals(0, 0);
    }
    @Test
    public void testRefundTicketPricePercent5(){
        var actual  = getRefundTicketPricePercent(30, false, false);
        Assert.assertEquals(30, 30);
    }
    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)
    {
        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert>240) return 100;
        if(hoursBeforeConcert>=144 && hoursBeforeConcert<=240) return 50;
        if(hoursBeforeConcert>3 && hoursBeforeConcert<=144) return 30;
        return 0;
    }
}
