package com.javeriana.web.four.covet19.Shared.Domain.User;

import com.javeriana.web.four.covet19.Shared.Domain.CustomUUID;

public class UserId extends CustomUUID {
    private UserId() {
        super("");
    }

    public UserId(String value) {
        super(value);
    }
}
