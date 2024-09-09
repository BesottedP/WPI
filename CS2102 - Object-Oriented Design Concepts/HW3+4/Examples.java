import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Examples {

    public LinkedList<Double> sensorData = new LinkedList<>();
    public LinkedList<Double> sensorDataAlt = new LinkedList<>();
    public LinkedList<Double> sensorDataPullSensor = new LinkedList<>();
    public GregorianCalendar gcTest = new GregorianCalendar(2023, 11, 06, 01, 01, 01);

    public Examples() {
        sensorData.addAll(List.of(20231106010101.0, 45.5, 34.0, 46.6, 40.0, 20231130020202.0, 22.2, 20.0, 35.5, 30.0,
                -999.0, 31.0, 32.2, -999.0));
        sensorDataAlt.addAll(List.of(20231106010101.0, 45.5, 34.0, 46.6, 40.0, 20231106020202.0, 22.2, 20.0, 35.5, 30.0,
                -999.0, 31.0, 32.2, -999.0));
        sensorDataPullSensor.add(20231106010101.0);
        for (int i = 0; i < 1000; i++) {
            sensorDataPullSensor.add((i % 7.0));
        }
    }

    // SuperTempHumidReading
    @Test
    public void test2constructor() {
        assertEquals(new SuperTempHumidReading(54.3, 12.2), new SuperTempHumidReading(54.3, 12.2));
    }

    @Test
    public void test1constructor() {
        SuperTempHumidReading otherReading = new SuperTempHumidReading(54.3, 12.2);
        assertEquals(new SuperTempHumidReading(otherReading), new SuperTempHumidReading(54.3, 12.2));
    }

    @Test
    public void test0constructor() {
        assertEquals(new SuperTempHumidReading(), new SuperTempHumidReading());
    }

    @Test
    public void testEquals() {
        SuperTempHumidReading reading = new SuperTempHumidReading(54.3, 12.2);
        assertEquals(false, reading.equals(0.2));
    }

    @Test
    public void testToStringBoth() {
        SuperTempHumidReading reading = new SuperTempHumidReading(54.3, 12.2);
        assertEquals("{54.3F;12.2%}", reading.toString());
    }

    @Test
    public void testToStringTemp() {
        SuperTempHumidReading reading = new SuperTempHumidReading(54.3, -999);
        assertEquals("{54.3F;Err}", reading.toString());
    }

    @Test
    public void testToStringHumid() {
        SuperTempHumidReading reading = new SuperTempHumidReading(-999, 12.2);
        assertEquals("{Err;12.2%}", reading.toString());
    }

    @Test
    public void testToStringErrored() {
        SuperTempHumidReading reading = new SuperTempHumidReading(-999, -999);
        assertEquals("{Err;Err}", reading.toString());
    }

    @Test
    public void testToStringEmpty() {
        SuperTempHumidReading reading = new SuperTempHumidReading();
        assertEquals("{Err;Err}", reading.toString());
    }

    // Personal Tests

    @Test
    public void testToStringEmptys() {
        Sensible s = new GreenHouseNursery(gcTest);
        s.pollSensorData(sensorData);
    }
    // 45.5, 46.6, 22.2, 35.5, 32.2
    // 34.0 40.0, 20.0, 30.0, 31.0

    // Green House Nursery

    @Test
    public void testNurseryMiddleReading() {
        Sensible s = new GreenHouseNursery(gcTest);
        s.pollSensorData(sensorData);
        assertEquals(new SuperTempHumidReading(35.5, 31.0), s.middleReading());
    }

    @Test
    public void testNurseryMiddleReadingNoData() {
        Sensible s = new GreenHouseNursery(gcTest);
        assertEquals(new SuperTempHumidReading(-999, -999), s.middleReading());
    }

    @Test
    public void testNurseryOnDateMidReading() {
        Sensible s = new GreenHouseNursery(gcTest);
        s.pollSensorData(sensorData);
        assertEquals(new SuperTempHumidReading(32.2, 30.0), s.middleReading(20231130.0));
    }

    @Test
    public void testNurseryOnDateMidReadingNoData() {
        Sensible s = new GreenHouseNursery();
        assertEquals(new SuperTempHumidReading(-999, -999), s.middleReading(20231130.0));
    }

    // Green House Produce
    @Test
    public void testProduceMiddleReading() {
        Sensible s = new GreenHouseProduce(gcTest);
        s.pollSensorData(sensorData);
        assertEquals(new SuperTempHumidReading(35.5, 31.0), s.middleReading());
    }

    @Test
    public void testProduceMiddleReadingNoData() {
        Sensible s = new GreenHouseProduce();
        assertEquals(new SuperTempHumidReading(-999, -999), s.middleReading());
    }

    @Test
    public void testProduceOnDateMidReading() {
        Sensible s = new GreenHouseProduce(gcTest);
        s.pollSensorData(sensorData);
        assertEquals(new SuperTempHumidReading(32.2, 30.0), s.middleReading(20231130.0));
    }

    @Test
    public void testProduceOnDateMidReadingNoData() {
        Sensible s = new GreenHouseProduce(gcTest);
        assertEquals(new SuperTempHumidReading(-999, -999), s.middleReading(20231130.0));
    }

    @Test
    public void testPullSensorDataTime() {
        Sensible s1 = new GreenHouseNursery();
        Sensible s2 = new GreenHouseProduce();
        long time1 = System.currentTimeMillis();
        s1.pollSensorData(sensorDataPullSensor);
        long time2 = System.currentTimeMillis();
        s2.pollSensorData(sensorDataPullSensor);
        long time3 = System.currentTimeMillis();
        System.out.println(String.format("computation1() : computation2() :: %s : %s", time2 - time1, time3 - time2));
        assertTrue(time2 - time1 < time3 - time2); // assert that computation 1 is faster
    }

    @Test
    public void testPullSensorDataTimeMidReading() {
        Sensible s1 = new GreenHouseNursery();
        Sensible s2 = new GreenHouseProduce();
        s1.pollSensorData(sensorDataPullSensor);
        s2.pollSensorData(sensorDataPullSensor);
        long time1 = System.currentTimeMillis();
        s2.middleReading();
        long time2 = System.currentTimeMillis();
        s1.middleReading();
        long time3 = System.currentTimeMillis();
        System.out.println(String.format("computation1() : computation2() :: %s : %s", time2 - time1, time3 - time2));
        assertTrue(time2 - time1 < time3 - time2); // assert that computation 1 is faster
    }

    @Test
    public void testPercentErrorNoErrors() {
        GregorianCalendar calendar = new GregorianCalendar(2005, 5, 1, 3, 36, 0);
        GreenHouseNursery nursery = new GreenHouseNursery(calendar);
        GreenHouseProduce produce = new GreenHouseProduce(calendar);
        ArrayList<Double> data = new ArrayList<>(Arrays.asList(
                20051114010203.0, 32.0, 28.0, 17.6, 29.2,
                20051115010203.0, 11.9, 48.2,
                20051116010203.0, 51.0, 44.1, 80.9, 21.2));
        nursery.pollSensorData(data);
        produce.pollSensorData(data);

        assertEquals(0.0, nursery.percentError(), 0.001);
        assertEquals(0.0, produce.percentError(), 0.001);
    }

    @Test
    public void testPercentErrorSomeErrors() {
        GregorianCalendar calendar = new GregorianCalendar(2005, 5, 1, 3, 36, 3);
        GreenHouseNursery nursery = new GreenHouseNursery(calendar);
        GreenHouseProduce produce = new GreenHouseProduce(calendar);
        ArrayList<Double> data = new ArrayList<>(Arrays.asList(
                20050811010203.0, 45.0, -999.0, -999.0, 27.0,
                20051114010203.0, 10.9, -999.0,
                20051115010203.0, -999.0, 43.0, 79.0, 20.0));

        nursery.pollSensorData(data);
        produce.pollSensorData(data);

        assertEquals(40, nursery.percentError(), 0.001);
        assertEquals(40, produce.percentError(), 0.001);
    }

    @Test
    public void testPercentErrorAllErrors() {
        GregorianCalendar calendar = new GregorianCalendar(2005, 5, 1, 3, 36, 3);
        GreenHouseNursery nursery = new GreenHouseNursery(calendar);
        GreenHouseProduce produce = new GreenHouseProduce(calendar);
        ArrayList<Double> data = new ArrayList<>(Arrays.asList(
                20050811010203.0, -999.0, -999.0, -999.0, -999.0,
                20051214010203.0, -999.0, -999.0,
                20051215010203.0, -999.0, -999.0, -999.0, -999.0));

        nursery.pollSensorData(data);
        produce.pollSensorData(data);

        assertEquals(100, nursery.percentError(), 0.001);
        assertEquals(100, produce.percentError(), 0.001);
    }

    @Test
    public void testCalendarOnOrAfterTest() {
        GregorianCalendar calendar = new GregorianCalendar(2005, 10, 14, 1, 2, 4);
        GreenHouseNursery nursery = new GreenHouseNursery(calendar);
        GreenHouseProduce produce = new GreenHouseProduce(calendar);
        ArrayList<Double> data = new ArrayList<>(Arrays.asList(
                20051113010203.0, 32.0, 28.0, 17.6, 29.2,
                20051114010204.0, 11.9, 48.2,
                20051115010205.0, 51.0, 44.1, 80.9, 21.2));

        nursery.pollSensorData(data);
        produce.pollSensorData(data);

        assertEquals(new SuperTempHumidReading(51.0, 44.1), nursery.middleReading());
        assertEquals(new SuperTempHumidReading(51.0, 44.1), produce.middleReading());
    }

}
