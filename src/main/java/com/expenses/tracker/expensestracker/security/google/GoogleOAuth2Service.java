package com.expenses.tracker.expensestracker.security.google;

import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.MemoryDataStoreFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class GoogleOAuth2Service {

    private static final String APPLICATION_NAME = "My App";
    private static final List<String> SCOPES = Arrays.asList(
            "https://www.googleapis.com/auth/userinfo.email",
            "https://www.googleapis.com/auth/userinfo.profile"
    );

    private final GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow;
    private final JsonFactory jsonFactory;
    private final HttpTransport httpTransport;

    @Autowired
    public GoogleOAuth2Service(GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow, JsonFactory jsonFactory, HttpTransport httpTransport) {
        this.googleAuthorizationCodeFlow = googleAuthorizationCodeFlow;
        this.jsonFactory = jsonFactory;
        this.httpTransport = httpTransport;
    }

    public GoogleTokenResponse exchangeAuthorizationCode(String authorizationCode) throws IOException, TokenResponseException {
        return googleAuthorizationCodeFlow.newTokenRequest(authorizationCode).execute();
    }

    public GoogleOAuth2User getUserInfo(String accessToken) throws IOException {
        GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
        Oauth2 oauth2 = new Oauth2.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
        Userinfo userinfo = oauth2.userinfo().get().execute();
        return new GoogleOAuth2User(userinfo.getId(), userinfo.getEmail(), userinfo.getGivenName(), userinfo.getFamilyName());
    }

    @Bean
    public GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow(GoogleClientSecrets googleClientSecrets) throws IOException {
        return new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory, googleClientSecrets, SCOPES)
                .setDataStoreFactory(new MemoryDataStoreFactory())
                .setAccessType("offline")
                .build();
    }

    @Bean
    public JsonFactory jsonFactory() {
        return GsonFactory.getDefaultInstance();
    }

    @Bean
    public HttpTransport httpTransport() {
        return new NetHttpTransport();
    }

}