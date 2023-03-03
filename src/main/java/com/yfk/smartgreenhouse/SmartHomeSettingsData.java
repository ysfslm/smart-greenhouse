package com.yfk.smartgreenhouse;

import jakarta.persistence.*;

@Entity
@Table
public class SmartHomeSettingsData {

    @Id
    private String pDeviceId = "YFK_Smart";
    private Double pTemperature = 22.0;
    private Double pHumidity = 70.0;
    private Float pLight = 9.0f;

    private String deviceId;
    private Double temperature;
    private Double humidity;
    private Float light;


    public SmartHomeSettingsData() {
    }

    public SmartHomeSettingsData(boolean preSet) {
        if(preSet == true) {
            pDeviceId = deviceId;
            pTemperature = temperature;
            pHumidity = humidity;
            pLight = light;
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


    public boolean validateDeviceId(String deviceId) {
        if (deviceId.equals(pDeviceId)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validateTemperature(Double temperature) { // celcius cinsinden sıcaklık değeri
        if(temperature <= 30 && temperature >= 10) {
            return true;
        }
        return false;
    }

    public boolean validateHumidity(Double humidity) { // yüzde nem değeri
        if (humidity <= 80 && humidity >= 60) {
            return true;
        }
        return false;
    }

    public boolean validateLight(Float light) { // bitkinin aldığı ışığın saat cinsinden değeri
        if(light >= 6) {
            return true;
        }
        return false;
    }

}

