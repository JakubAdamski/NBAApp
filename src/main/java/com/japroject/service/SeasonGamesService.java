package com.japroject.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SeasonGamesService {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api-nba-v1.p.rapidapi.com/games?season=2021");
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

            // Tu możesz przetworzyć odpowiedź JSON i wyświetlić mecze na początku sezonu.
            String jsonResponse = response.toString();
            System.out.println(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

