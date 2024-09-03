package com.sl.buslines.backend.models.response;

import com.google.gson.GsonBuilder;

import java.util.List;

public class ResponseData {
    String Version;
    String Type;
    List<Result> Result;

    public ResponseData() {
	}

    public void setVersion(String version) {
        this.Version = version;
    }

    public String getVersion() {
        return Version;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public List<Result> getResult() {
        return Result;
    }

    public void setResult(List<Result> result) {
        this.Result = result;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}