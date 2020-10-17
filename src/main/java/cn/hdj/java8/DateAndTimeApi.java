package cn.hdj.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: DateAndTimeApi
 * @Package cn.hdj.java8
 * @Description: TODO
 * @date 2018/4/1 22:00
 */
public class DateAndTimeApi {


    @Test
    public void testGetDateTime() {
        /**
         * 主要对象
         * Instant - 时间线上的瞬时点
         * LocalDate - 日期
         * LocalTime - 时间
         * LocalDateTime - 日期时间
         * ZonedDateTime - 带时区的日期时间
         */


        //创建日期
        LocalDate date = LocalDate.of(2018, 04, 01); //2018-04-01
        //获取年月日周
        int year = date.getYear(); //2018
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        //获取月的天数, 还有年的天数   date.lengthOfYear()
        int len = date.lengthOfMonth();
        //判断是否为闰年
        boolean leap = date.isLeapYear();


        //操作日期；会返回新的日期时间


        /**
         *添加日期;
         * Temporal plus(long amountToAdd, TemporalUnit unit);
         * Temporal plus(TemporalAmount amount)
         * LocalDate plusDays(long daysToAdd)
         * LocalDate plusMonths(long monthsToAdd)
         * LocalDate plusYears(long yearsToAdd)
         */

        //添加一个月
        LocalDate plus = date.plus(1, ChronoUnit.MONTHS);
        System.out.println(plus); //2018-05-01

        //两日期相加 (2018-04-01) + (2018-05-01) = 4036-09-02
        LocalDate plus1 = date.plus(Period.of(2018, 05, 01));
        System.out.println(plus1);

        //添加天数
        date.plusDays(1);
        //添加月
        date.plusMonths(1);
        //添加周
        date.plusWeeks(1);
        //添加年
        date.plusYears(1);

        /**
         *减
         * Temporal minus(long amountToAdd, TemporalUnit unit);
         * Temporal minus(TemporalAmount amount)
         * LocalDate minusDays(long daysToAdd)
         * LocalDate minusMonths(long monthsToAdd)
         * LocalDate minusYears(long yearsToAdd)
         */
        //减去一个月
        date.minus(1, ChronoUnit.MONTHS);
        //(2018-04-01) - (2014-04-01) = 0003-11-30
        LocalDate minus = date.minus(Period.of(2014, 04, 01));
        System.out.println(minus);
        date.minusDays(1);
        date.minusMonths(1);
        date.minusYears(1);

        /**
         * until : 获取两个日期时间的相隔的周期
         *
         * 2017-05-03 与2018-04-01 相隔 0 year , 10 months, 29 days
         */
        LocalDate date1 = LocalDate.of(2018, 04, 01);
        LocalDate date2 = LocalDate.of(2017, 05, 03);
        Period period = date2.until(date1);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());

        /**
         *atTime : LocalDate 联合 LocalTime 组成 LocalDateTime
         */
        LocalDateTime localDateTime = date.atTime(LocalTime.now());
        System.out.println(localDateTime);


        /**
         * 日期时间格式化和解析
         */
        //格式化
        String format = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format);
        //解析
        LocalDateTime parse = LocalDateTime.parse("2018-01-01 23:50:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse);
    }
}
