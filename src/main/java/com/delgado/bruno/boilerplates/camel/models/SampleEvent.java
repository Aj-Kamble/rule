package com.delgado.bruno.boilerplates.camel.models;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;


public class SampleEvent {

    private String payload;
    private Integer zoneid;
    private String deviceid;

    public String getName() {
        
        return payload;
    }

    public void setName(String payload) {
        this.payload = payload;
    }

    public Integer getZoneid() {
        return zoneid;
    }

    public void setZoneid(Integer zoneid) {
        this.zoneid = zoneid;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }
}
