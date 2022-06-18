package com.rogerio.futmanager.config.security;

import com.rogerio.futmanager.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${futmanager.jwt.expiration}")
    private String expiration;

    @Value("${futmanager.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {

        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();  // Recupera usuário logado.

        Date dataCriacao = new Date();
        Date dataExpiracao = new Date(dataCriacao.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API do Fut Mananger")                           // Aplicação que fez a geração do token
                .setSubject(usuarioLogado.getId().toString())               // Quem é o dono (usuário) desse token
                .setIssuedAt(dataCriacao)                                   // Data de criação do token
                .setExpiration(dataExpiracao)                               // Tempo para expirar o token
                .signWith(SignatureAlgorithm.HS256, secret)                 // Criptografa o token usando algoritmo + uma string secret
                .compact();

    }
}
