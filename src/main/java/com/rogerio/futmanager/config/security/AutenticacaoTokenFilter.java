package com.rogerio.futmanager.config.security;

import com.rogerio.futmanager.modelo.Usuario;
import com.rogerio.futmanager.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioRepository usuarioRepository;

    public AutenticacaoTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository){
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Não existe mais conceito de autenticação por sessão, toda requisição virá com um token para ser validado ou não
        String token = recuperarToken(request);
        boolean tokenValido = tokenService.isTokenValido(token);
        if (tokenValido){
            autenticarUsuario(token);
        }
        filterChain.doFilter(request, response);
    }

    private void autenticarUsuario(String token) {
        // Dentro do token foi carregado o ID do usuário para qual ele foi gerado.
        Long idUsuario = tokenService.getIdUsuario(token);
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if (usuario.isPresent()) {
            // Precisa passar pra classe qual é o usuário que está autenticado. Nesse usuário que esta também o tipo de perfil de acesso.
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    usuario.get(), null, usuario.get().getAuthorities());
            // Através da classe SecurityContextHolder o Spring vai tomar conhecimento que esse usuário (token) está autenticado
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }
}
