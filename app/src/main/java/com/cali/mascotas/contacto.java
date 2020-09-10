package com.cali.mascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class contacto extends AppCompatActivity {
    String correo;
    String contrasenia;

    EditText mensaje;
    Button btnEnviar;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        correo = "orellano428@gmail.com";
        contrasenia = "";


        mensaje = findViewById(R.id.etMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Properties prop = new Properties();
                prop.put("mail.smtp.host", "smto.googlemail.com");
                prop.put("mail.smtp.socketFactory.port", "456");
                prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                prop.put("mail.smtp.auth", "true");
                prop.put("mail.smtp.port", "456");

                try {
                    session = Session.getDefaultInstance(prop, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contrasenia);
                        }
                    });

                    if (session != null){
                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Correo Prueba");
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("corellanor@unasam.edu.pe"));
                        message.setContent(mensaje.getText().toString(), "txt/html: charset = utf-8");
                        Transport.send(message);


                    }
                }catch (Exception e){
                    e.printStackTrace();
                }



            }
        });
    }
}
