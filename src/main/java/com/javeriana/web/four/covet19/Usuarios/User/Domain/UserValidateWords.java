package com.javeriana.web.four.covet19.Usuarios.User.Domain;

public class UserValidateWords {

    private ValidateWordService service;

    public UserValidateWords(ValidateWordService service) {
        this.service = service;
    }

    public void execute (String word)
    {
        if (service.validate(word))
        {
            throw new BadWordsError("The nickname contains bad words");
        }
    }
}
