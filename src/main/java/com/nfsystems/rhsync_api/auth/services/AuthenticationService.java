package com.nfsystems.rhsync_api.auth.services;

import com.nfsystems.rhsync_api.auth.dto.AuthenticationRequest;
import com.nfsystems.rhsync_api.auth.dto.AuthenticationResponse;
import com.nfsystems.rhsync_api.auth.dto.RegistrationRequest;
import com.nfsystems.rhsync_api.role.repositories.RoleRepository;
import com.nfsystems.rhsync_api.security.JwtService;
import com.nfsystems.rhsync_api.user.models.User;
import com.nfsystems.rhsync_api.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Transactional
    public void register(RegistrationRequest request) {
        var userRole = roleRepository.findById(request.roleId())
                .orElseThrow(() -> new IllegalArgumentException("Permissão de usuário não encontrada"));
        var user = User.builder()
                .firstName(request.firstname())
                .lastName(request.lastname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .accountLocked(false)
                .enabled(true)
                .roles(List.of(userRole))
                .build();

        userRepository.save(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var claims = new HashMap<String, Object>();
        var user = ((User)auth.getPrincipal());
        claims.put("fullName", user.getFirstName());
        var jwtToken = jwtService.generateToken(claims, user);
        return new AuthenticationResponse(jwtToken);
    }
}
