package com.delgado.bruno.boilerplates.camel.processors;

import com.delgado.bruno.boilerplates.camel.models.SampleEvent;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
// import java.util.Base64;
// import java.nio.charset.StandardCharsets;



public class SampleProcessor implements Processor {

    private final String INSERT_QUERY = "INSERT INTO zone_telemetry (zone_telemetry_geo_json, zone_id, device_name) VALUES (convert_from(decode(('%s'), 'base64'), 'UTF8'), %s, %s)";
    private final String INSERT_QUERY = "INSERT INTO actions_table (condition, action, description) VALUES (%s, %s, %s)";
    // "INSERT INTO sample_table (json) VALUES ('%s')"
//  "INSERT INTO sample_table (json) VALUES (convert_from(decode(('%s'), 'base64'), 'UTF8'))";
    @Override
    public void process(Exchange exchange) {
        var event = (SampleEvent) exchange.getIn().getBody();
        var insertQuery = String.format(INSERT_QUERY,  event.getName(), event.getZoneid(),"'" + event.getDeviceid() + "'");
        exchange.getIn().setBody(insertQuery);

      
        // byte[] event = (SampleEvent) exchange.getIn().getBody(byte[].class);

        // byte[] base64Data = event.getName();

        // String utf8String = new String(base64Data, "UTF-8");



        // byte[] decodedBytes = Base64.getDecoder().decode(event.getName());
        // String decodedString = new String(decodedBytes);
        // System.out.println(decodedString);
        
        // byte[] decodedBytes = Base64.getDecoder().decode(event.getName());

        // Convert the byte array to a UTF-8 string
        // String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        // String decodedString = new String(decodedBytes, event.getName());
        

        // var insertQuery = String.format(INSERT_QUERY, utf8String);
        


       
    }
        public void processRules(Exchange exchange) {
        var event = (SampleEvent) exchange.getIn().getBody();
        var rulesQuery = String.format(INSERT_RULES_QUERY, "'" + event.getCondition() + "'", "'" + event.getAction() + "'", "'" + event.getDescription() + "'");
        exchange.getIn().setBody(rulesQuery);
    }
}