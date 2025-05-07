package com.iot.jpa.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class TSController {

    

    @GetMapping("/api/sensors")
    @ResponseBody
    public ResponseEntity<String> fetchSensorData() {
        try {
            String urlStr = "https://api.thingspeak.com/channels/2898862/feeds.json?api_key=CRCX3SP9YV1MDXVX&results=30";
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(jsonBuilder.toString());
            JSONArray feeds = json.getJSONArray("feeds");

            JSONArray timestamps = new JSONArray();
            JSONArray heartRate = new JSONArray();      // Field 1
            JSONArray ecg = new JSONArray();            // Field 2
            JSONArray lm35 = new JSONArray();           // Field 3
            JSONArray dhtTemp = new JSONArray();        // Field 4
            JSONArray dhtHumidity = new JSONArray();    // Field 5

            for (int i = 0; i < feeds.length(); i++) {
                JSONObject feed = feeds.getJSONObject(i);
                timestamps.put(feed.getString("created_at"));
                heartRate.put(feed.optDouble("field1", 0));
                ecg.put(feed.optDouble("field2", 0));
                lm35.put(feed.optDouble("field3", 0));
                dhtTemp.put(feed.optDouble("field4", 0));
                dhtHumidity.put(feed.optDouble("field5", 0));
            }

            JSONObject result = new JSONObject();
            result.put("timestamps", timestamps);
            result.put("heartRate", heartRate);
            result.put("ecg", ecg);
            result.put("lm35", lm35);
            result.put("dhtTemp", dhtTemp);
            result.put("dhtHumidity", dhtHumidity);

            return ResponseEntity.ok(result.toString());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
