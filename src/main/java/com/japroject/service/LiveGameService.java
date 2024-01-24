package com.japroject.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LiveGameService {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api-nba-v1.p.rapidapi.com/games?live=all");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("X-RapidAPI-Key", "2523971080msh2289df27ab1e542p16db7ajsnff483b974945");
                    conn.setRequestProperty("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com");

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    String jsonResponse = response.toString();
                    System.out.println(jsonResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 15, TimeUnit.MINUTES);
    }
}
