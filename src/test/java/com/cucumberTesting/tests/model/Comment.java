package com.cucumberTesting.tests.model;

import com.google.gson.GsonBuilder;

public final class Comment {
    private final String body;
    private final int postId;

    public Comment(int postId,String body) {
        this.body = body;
        this.postId = postId;
    }

    public String toStringJson() {
        return new GsonBuilder().create().toJson(this);
    }
}
