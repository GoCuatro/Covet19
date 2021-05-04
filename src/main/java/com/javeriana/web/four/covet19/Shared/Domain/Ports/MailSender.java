package com.javeriana.web.four.covet19.Shared.Domain.Ports;

import java.io.IOException;

public interface MailSender {
    public void send(String email, String content) throws IOException;
}
