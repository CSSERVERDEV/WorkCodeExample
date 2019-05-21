package my.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;
import java.util.*;

/**
 * 已知有如下数据
 * 2019-04-15 06:08:03		Australia/Sydney
 * 2019-04-15 04:58:37		Australia/Sydney
 * 2019-04-15 04:35:18		Australia/Melbourne
 * 2019-04-15 03:30:31		Australia/Melbourne
 * 2019-04-15 03:29:51		Australia/Brisbane
 * 2019-04-15 03:28:19		America/Toronto
 * 2019-04-15 03:11:46		Australia/Brisbane
 * 2019-04-15 02:26:05		Australia/Brisbane
 * 2019-04-15 02:14:06		America/New_York
 * 2019-04-15 01:02:37		America/New_York
 * 2019-04-14 23:45:05		Australia/Sydney
 * 2019-04-14 23:40:19		America/New_York
 * 2019-04-14 23:18:10		America/Vancouver
 * 2019-04-14 22:48:10		America/Vancouver
 * 2019-04-14 22:43:08		Australia/Sydney
 * 2019-04-14 22:21:36		Australia/Sydney
 * 2019-04-14 20:47:43		America/Toronto
 * 2019-04-14 20:35:03		America/Edmonton
 * 2019-04-14 19:33:00		America/Edmonton
 * 2019-04-14 19:32:40		America/Los_Angeles
 * 2019-04-14 19:31:24		America/Los_Angeles
 * 2019-04-14 19:24:53		America/Los_Angeles
 * 2019-04-14 18:50:03		America/Chicago
 * 2019-04-14 18:46:21		America/New_York
 * 2019-04-14 18:46:09		America/Chicago
 * 2019-04-14 17:31:47		America/New_York
 * 2019-04-14 16:39:12		America/Montreal
 * 2019-04-14 16:30:36		America/New_York
 * 2019-04-14 16:19:43		America/New_York
 * 2019-04-14 15:22:32		Australia/Sydney
 * 2019-04-14 15:07:09		Australia/Sydney
 * 2019-04-14 14:51:27		Australia/Melbourne
 * 2019-04-14 14:50:03		America/New_York
 * 2019-04-14 13:12:19		Australia/Perth
 * 2019-04-14 12:53:25		America/Manaus
 * 2019-04-14 12:12:10		Australia/Sydney
 * 2019-04-14 11:36:14		America/New_York
 * 2019-04-14 11:18:34		Australia/Adelaide
 * 2019-04-14 09:17:55		Australia/Sydney
 * 2019-04-14 08:55:52		Australia/Perth
 * 2019-04-14 08:41:44		Australia/Perth
 * 2019-04-14 08:32:28		Australia/Perth
 * 2019-04-14 08:23:17		Australia/Sydney
 * 2019-04-14 08:20:26		Australia/Perth
 * 2019-04-14 07:32:58		Australia/Brisbane
 * 2019-04-14 07:00:46		Australia/Sydney
 * 2019-04-14 06:37:36		Australia/Brisbane
 * 2019-04-14 06:34:34		Australia/Brisbane
 * 2019-04-14 06:23:29		America/Chicago
 * 2019-04-14 06:19:58		Australia/Sydney
 * 2019-04-14 05:50:50		Australia/Sydney
 * 2019-04-14 05:32:11		Australia/Perth
 * 2019-04-14 05:26:38		Australia/Sydney
 * 2019-04-14 05:25:05		Australia/Brisbane
 * 2019-04-14 05:17:48		Australia/Sydney
 * 2019-04-14 04:46:04		Australia/Sydney
 * 2019-04-14 04:38:57		Australia/Perth
 * 2019-04-14 03:52:00		Australia/Sydney
 * 2019-04-14 03:46:13		Australia/Brisbane
 * 2019-04-14 03:39:54		Australia/Brisbane
 * 2019-04-14 03:21:35		Australia/Sydney
 * 2019-04-14 03:05:53		America/New_York
 * 2019-04-14 02:50:49		Australia/Sydney
 * 2019-04-14 02:48:07		America/Denver
 * 2019-04-14 02:40:18		America/Denver
 * 2019-04-14 02:32:25		Australia/Adelaide
 * 2019-04-14 02:23:33		America/Toronto
 * 2019-04-14 02:21:58		Australia/Melbourne
 * 2019-04-14 02:09:31		Australia/Brisbane
 * 2019-04-14 02:03:22		America/Los_Angeles
 * 2019-04-14 00:55:53		Australia/Sydney
 * 2019-04-14 00:46:12		America/New_York
 * 2019-04-14 00:33:46		America/New_York
 * 2019-04-13 23:23:32		America/Toronto
 * 2019-04-13 22:41:55		Australia/Sydney
 * 2019-04-13 22:35:44		America/Los_Angeles
 * 2019-04-13 22:29:45		America/New_York
 * 2019-04-13 22:04:17		America/Los_Angeles
 * 2019-04-13 21:55:18		America/Los_Angeles
 * 2019-04-13 21:49:10		America/Los_Angeles
 * 2019-04-13 21:17:34		America/Los_Angeles
 * 2019-04-13 21:05:05		America/Chicago
 * 2019-04-13 20:49:04		America/New_York
 * 2019-04-13 20:02:21		America/Toronto
 * 2019-04-13 20:00:07		America/Los_Angeles
 * 2019-04-13 19:53:28		America/Chicago
 * 2019-04-13 19:38:03		America/Chicago
 * 2019-04-13 19:34:53		America/New_York
 * 2019-04-13 17:59:09		America/Chicago
 * 2019-04-13 17:08:50		America/Chicago
 * 2019-04-13 14:49:12		America/St_Johns
 * 2019-04-13 13:23:51		America/Chicago
 * 2019-04-13 11:38:00		Australia/Sydney
 * 2019-04-13 08:32:25		Australia/Sydney
 * 2019-04-13 08:02:53		Australia/Perth
 * 2019-04-13 07:13:15		Australia/Adelaide
 * 2019-04-13 06:09:43		Australia/Brisbane
 * 2019-04-13 05:35:33		Australia/Sydney
 * 2019-04-13 05:34:41		Australia/Brisbane
 * 2019-04-13 05:15:25		Australia/Melbourne
 *
 * @author zengsong
 * @version 1.0
 * @description
 * @date 2019/5/6 10:28
 **/
public class DateUtils {
//    private DateUtils dateUtils=null;
//    public DateUtils(){
//
//    }
//    public static synchronized DateUtils singlation(){
//        if(dateUtils!=null){
//            dateUtils=new DateUtils();
//            return dateUtils;
//        }
//        return dateUtils;
//    }

    /* 根据国家对相应的时间进行日期格式化
	 */
    public static Date dateFormate(String dateStr, int countryid) throws ParseException {
//        Countries countries = countriesMapper.selectByPrimaryKey(countryid);
//        SimpleDateFormat format = null;
//        if ("DE".equals(countries.getAlpha2())) {
//            format = new SimpleDateFormat("dd. MMMM yyyy", Locale.GERMAN);
//        } else if ("GB".equals(countries.getAlpha2())) {
//            format = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
//        } else if ("IT".equals(countries.getAlpha2())) {
//            format = new SimpleDateFormat("dd MMMM yyyy", Locale.ITALY);
//            dateStr = dateStr.toUpperCase();
//        } else if ("FR".equals(countries.getAlpha2())) {
//            format = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
//            dateStr = dateStr.toUpperCase();
//        } else if ("ES".equals(countries.getAlpha2())) {
//            //对于Locale没有提供常量的国家我们可以通过创建Locale对象的方式实现：
//            format = new SimpleDateFormat("d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
//        } else if ("JP".equals(countries.getAlpha2())) {
//            format = new SimpleDateFormat("yyyy'年'MM'月'dd'日'", Locale.JAPAN);
//        }else if ("US".equals(countries.getAlpha2())) {
//            format = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
//        }else if ("CA".equals(countries.getAlpha2())) {
//            format = new SimpleDateFormat("MMMM dd, yyyy", Locale.CANADA);
//        }
//        return format.parse(dateStr);


        return null;
    }
    public String getTimeZoneByLocale(final String languageTag){
        final Locale locale = Locale.forLanguageTag(languageTag);
        final Calendar cal = Calendar.getInstance(locale);
        final TimeZone timeZone = cal.getTimeZone();
        return timeZone.getID();

    }
    public static void main(String[] arg0){
//        TimeZone china = TimeZone.getTimeZone("GMT+10:00");
//        System.out.println(china.getDisplayName());
//        String[] ids = TimeZone.getAvailableIDs();

//        for (String id : ids) {
//            int slash = id.indexOf('/');
//            String stripped = id.substring(slash + 1).replace("_", " ");
//            System.out.println(stripped);
//        }

//        ZoneId america = ZoneId.of("Asia/Shanghai");
//        LocalDateTime localtDateAndTime = LocalDateTime.now();
//        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
//        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);



//        YearMonth currentYearMonth = YearMonth.now();
//        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
//        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
//        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
        //指定时区ID获取时区当前时间
        ZoneId america = ZoneId.of("Australia/Sydney");
        LocalDateTime shanghaiTime = LocalDateTime.now(america);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = shanghaiTime.format(formatter); // "2019-05-06 22:37:24"
        System.out.println(formattedDateTime);

//        System.out.println(getTimeZone("Asia/Shanghai"));




//        LocalDateTime now = LocalDateTime.now();
//        System.out.println("当前时间: " + now);
//        ZoneId fixedZoneId = ZoneId.of("+08:00");
//        ZoneId bdDhaka = ZoneId.of("Asia/Dhaka");
//        ZoneId usChicago = ZoneId.of("America/Chicago");
//
//        printDetails(fixedZoneId, now);
//        printDetails(bdDhaka, now);
//        printDetails(usChicago, now);
    }
    private static void printDetails(ZoneId zoneId, LocalDateTime now) {
        System.out.println("Zone ID: " + zoneId.getId());

        ZoneRules rules = zoneId.getRules();
        boolean isFixedOffset = rules.isFixedOffset();
        System.out.println("isFixedOffset(): " + isFixedOffset);

        ZoneOffset offset = rules.getOffset(now);
        System.out.println("Zone offset: " + offset);

        List<ZoneOffsetTransition> transitions = rules.getTransitions();
        System.out.println(transitions);
    }
    /**
     * 获取城市所在时区
     * @param targetId 目标时区id 比如：America/New_York
     * @return string 时区 比如：+08:00
     */
    public static String getTimeZone(String targetId){
        //校验入参是否合法
        if (null == targetId || "".equals(targetId)){
            return null;
        }

        try {
            TimeZone timeZone = TimeZone.getTimeZone(targetId);
            SimpleDateFormat outputFormat = new SimpleDateFormat("Z");
            outputFormat.setTimeZone(timeZone);
            Date date = new Date(System.currentTimeMillis());

            //加上冒号显示，把+0800转成+08:00
            StringBuffer stringBuffer = new StringBuffer(outputFormat.format(date));
            return stringBuffer.insert(3, ":").toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
