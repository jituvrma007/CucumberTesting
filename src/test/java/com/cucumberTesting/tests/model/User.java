package com.cucumberTesting.tests.model;

import com.google.gson.GsonBuilder;

public final class User {

    private final String name;
    private final String username;
    private final String email;
    private final String phone;
    private final String website;

    public User(String name, String username, String email, String phone, String website) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public String toStringJson() {
        return new GsonBuilder().create().toJson(this);
    }
}
