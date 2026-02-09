package com.corebanking.iam.auth;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    @PermitAll
    public Response login(LoginRequest request) {
        String token = authService.authenticate(request.username(), request.password());
        return Response.ok(new TokenResponse(token)).build();
    }
}

public record LoginRequest(String username, String password) {

}

public record TokenResponse(String accessToken) {

}