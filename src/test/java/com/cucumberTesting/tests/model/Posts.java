package com.cucumberTesting.tests.model;

import com.google.gson.GsonBuilder;

public final class Posts {

    private final int userId;
    private final String title;
    private final String body;

    public Posts(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public String toStringJson() {
        return new GsonBuilder().create().toJson(this);
    }
}
