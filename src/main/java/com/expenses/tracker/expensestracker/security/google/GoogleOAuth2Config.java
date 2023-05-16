package com.expenses.tracker.expensestracker.security.google;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class GoogleOAuth2Config {
//
//    @Bean
//    public GoogleClientSecrets googleClientSecrets() throws IOException {
//        String clientSecretsJson = System.getenv("GOOGLE_CLIENT_SECRETS_JSON");
//        byte[] decodedClientSecrets = Base64.getDecoder().decode(clientSecretsJson);
//        InputStreamReader clientSecretsReader = new InputStreamReader(
//                new ByteArrayInputStream(decodedClientSecrets), StandardCharsets.UTF_8);
//        return GoogleClientSecrets.load(new GsonFactory(), clientSecretsReader);
//    }
}