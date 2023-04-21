package com.san4N.PTPShoping.common.dataType;

import java.util.Objects;

public final class Status {

    private final String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return Objects.equals(status, status1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    public static Status valueOf(String status){
        return new Status(status);
    }
}
