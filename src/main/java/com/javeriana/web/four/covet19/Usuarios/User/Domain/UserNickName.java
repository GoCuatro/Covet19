package com.javeriana.web.four.covet19.Usuarios.User.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;
public class UserNickName extends StringValueObject
{
    public UserNickName(String value) {
        this.validate(value);
        this.value = value;
    }

    private void validate(String value) {
        this.lenghtRule(value);
        //TODO: Other Rules
    }

    private void lenghtRule(String value) {
        if (value.length() < 8) {
            throw new LengthNotValid("Number of characters invalid");
        }
    }
}
