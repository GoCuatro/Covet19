package com.javeriana.web.four.covet19.Shared.Infrastructure.Mail.SendGrid;


import com.javeriana.web.four.covet19.Shared.Domain.Ports.MailSender;
import com.sendgrid.*;

import java.io.IOException;

public class MailSenderSendGridImpl implements MailSender {
    @Override
    public void send(String email, String content) throws IOException {
        Email from = new Email("jairo.vanegas@javeriana.edu.co");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email(email);
        Content contentBuilded = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, to, contentBuilded);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}