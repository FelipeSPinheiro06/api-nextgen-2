package br.com.fiap.apinextgen.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public Token createToken(String email) {
        Algorithm algorithm = Algorithm.HMAC256("challenge");
        String token = JWT.create()
                .withSubject(email)
                .withIssuer("nextgen")
                .sign(algorithm);

        return new Token(token, "JWT");
    }

}
