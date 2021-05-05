package com.javeriana.web.four.covet19.Usuarios.User.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.CarritoUsuario;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.MascotaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;

import java.util.*;
import java.util.stream.Collectors;

public class User {

    private IdPersona userId;
    private NombrePersona userFirstName;
    private PasswordPersona userPassword;
    private CorreoPersona userMail;
    private TelefonoPersona userPhone;
    private CedulaPersona userCedule;
    private DireccionPersona userAdresss;
    private FechaNacimientoPersona userBirth;
    private Optional<List<CarritoUsuario>> userCarrito;
    private Optional<List<MascotaDetails>> userMascotas;

    public User(IdPersona userId,
                NombrePersona userFirstName,
                PasswordPersona userPassword,
                CorreoPersona userMail,
                TelefonoPersona userPhone,
                CedulaPersona userCedule,
                DireccionPersona userAdresss,
                FechaNacimientoPersona userBirth,
                List<CarritoUsuario> userCarrito,
                List<MascotaDetails> userMascotas) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.userCedule = userCedule;
        this.userAdresss = userAdresss;
        this.userBirth = userBirth;
        this.userCarrito = Optional.ofNullable(userCarrito);
        this.userMascotas = Optional.ofNullable(userMascotas);
    }

    public static User create(
            IdPersona idPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            CorreoPersona correoPersona,
            TelefonoPersona telefonoPersona,
            CedulaPersona cedulaPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona
    ) {
        CarritoUsuario carrito = new CarritoUsuario(1,"123456");
        MascotaDetails mascota = new MascotaDetails();
        List<CarritoUsuario> userCarrito = new ArrayList<CarritoUsuario>();
        userCarrito.add(carrito);
        List<MascotaDetails> userMascotas= new ArrayList<MascotaDetails>();
        userMascotas.add(mascota);

        return new User(idPersona, nombrePersona, passwordPersona, correoPersona, telefonoPersona,
                cedulaPersona, direccionPersona, fechaNacimientoPersona, userCarrito, userMascotas);
    }

    public Optional<List<HashMap<String, Object>>> getUserMascotas() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.userMascotas.isPresent()) {
            response = Optional.of(this.userMascotas.get().stream().map(mascota -> mascota.data()).collect(Collectors.toList()));
        }
        return response;
    }
    public Optional<List<MascotaDetails>> getUserMascotasDetails() {
        return this.userMascotas;
    }
    public Optional<List<HashMap<String, Object>>> getUserCarrito() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.userCarrito.isPresent()) {
            response = Optional.of(this.userCarrito.get().stream().map(elemento -> elemento.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addMascotasDetails( MascotaDetails mascotaDetails) {
        List<MascotaDetails> mascotaDetailsList =
                this.userMascotas.isEmpty() ? new ArrayList<>() : this.userMascotas.get();
        mascotaDetailsList.add(mascotaDetails);
        this.userMascotas = Optional.ofNullable(mascotaDetailsList);
    }
    public void updateUser(NombrePersona userFirstName)
    {
        this.userFirstName = userFirstName;
    }

    public boolean equalsById(String otherId)
    {
        return this.userId.equals(new IdPersona(otherId));
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", userId.value());
            put("nombre", userFirstName.value());
            put("password", userPassword.value());
            put("correo", userMail.value());
            put("telefono", userPhone.value().toString());
            put("cedula", userCedule.value().toString());
            put("direccion", userAdresss.value());
            put("fecha", userBirth.value().toString());
            put("carrito", getUserCarrito());
            put("mascotas", getUserMascotas());

        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userCedule, user.userCedule) &&
                Objects.equals(userMail, user.userMail) &&
                Objects.equals(userAdresss, user.userAdresss) &&
                Objects.equals(userBirth, user.userBirth) &&
                Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userPhone, user.userPhone);

    }
    private User(){};
}
