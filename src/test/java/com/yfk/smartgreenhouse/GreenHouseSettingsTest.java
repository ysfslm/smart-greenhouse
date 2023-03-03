package com.yfk.smartgreenhouse;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class GreenHouseSettingsTest {

    SmartHomeSettingsData settings = new SmartHomeSettingsData(true);

    @Test
    public void validateTemperature() {
        assertEquals(settings.validateTemperature(0.0),false);
        assertEquals(settings.validateTemperature(-0.0001),false);
        assertEquals(settings.validateTemperature(9.9999),false);
        assertEquals(settings.validateTemperature(10.0),true);
        assertEquals(settings.validateTemperature(22.4),true);
        assertEquals(settings.validateTemperature(29.9),true);
        assertEquals(settings.validateTemperature(30.0),true);
        assertEquals(settings.validateTemperature(30.0001),false);
    }

    @Test
    public void validateHumidity() {
        assertEquals(settings.validateHumidity(-0.0001),false);
        assertEquals(settings.validateHumidity(0.0),false);
        assertEquals(settings.validateHumidity(59.9999),false);
        assertEquals(settings.validateHumidity(60.0),true);
        assertEquals(settings.validateHumidity(79.9999),true);
        assertEquals(settings.validateHumidity(80.0),true);
        assertEquals(settings.validateHumidity(80.0001),false);
        assertEquals(settings.validateHumidity(100.00),false);
    }

    @Test
    public void validateLight() {
        assertEquals(settings.validateLight(-0.0001f),false);
        assertEquals(settings.validateLight(0.0f),false);
        assertEquals(settings.validateLight(5.9999f),false);
        assertEquals(settings.validateLight(6.0f),true);
        assertEquals(settings.validateLight(6.0001f),true);
        assertEquals(settings.validateLight(12.0f),true);
        assertEquals(settings.validateLight(24.0000f),true);
    }

}
