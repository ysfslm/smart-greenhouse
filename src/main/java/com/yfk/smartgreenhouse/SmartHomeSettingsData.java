package com.yfk.smartgreenhouse;

import jakarta.persistence.*;

@Entity
@Table
public class SmartHomeSettingsData {

    @Id
    private String pDeviceId = "YFK_Smart";
    private Double pTemperature = 0.0;
    private Double pHumidity = 0.0;
    private Float pLight = 0.0f;
    private Float pCarbondioxide = 0.0f;

    private String deviceId;
    private Double temperature;
    private Double humidity;
    private Float light;
    private Float carbondioxide;

    public SmartHomeSettingsData() {
    }

    public SmartHomeSettingsData(boolean preSet) {
        if(preSet == true) {
            pDeviceId = deviceId;
            pTemperature = temperature;
            pHumidity = humidity;
            pLight = light;
            pCarbondioxide = carbondioxide;
        }
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Float getLight() {
        return light;
    }

    public void setLight(Float light) {
        this.light = light;
    }

    public Float getCarbondioxide() {
        return carbondioxide;
    }

    public void setCarbondioxide(Float carbondioxide) {
        this.carbondioxide = carbondioxide;
    }

    public boolean validateDeviceId(String deviceId) {
        if (deviceId.equals(pDeviceId)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validateTemperature(Double temperature) {
        if (temperature.equals(pTemperature)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validateHumidity(Double humidity) {
        if (humidity.equals(pHumidity)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validateLight(Float light) {
        if (light.equals(pLight)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validateCarbondioxide(Float carbondioxide) {
        if (carbondioxide.equals(pCarbondioxide)) {
            return true;
        }
        else {
            return false;
        }
    }
}

