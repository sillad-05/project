package com.example.attendance;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class SupabaseClient {

    private static final String SUPABASE_URL =
            "https://eqtpbqbacuoqmswavbez.supabase.co";

    private static final String API_KEY =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVxdHBicWJhY3VvcW1zd2F2YmV6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzAwNDM3NTYsImV4cCI6MjA4NTYxOTc1Nn0.311o2oFzNSzeej-s6ktBglTIP2CUWlLttMbtx0TdNng";

    public static void fetchAttendance(Callback callback) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(SUPABASE_URL + "/rest/v1/attendance?select=*")
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        client.newCall(request).enqueue(callback);
    }
}
