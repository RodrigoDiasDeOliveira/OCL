package com.triminds.tlp.controller.AuthService;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public TokenResponse login(LoginRequest req) {
        User u = users.findByEmail(req.email())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        if (!encoder.matches(req.password(), u.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return new TokenResponse(jwt.generate(u.getEmail(), u.getCompany().getId(), u.getRole().name()));
    }
    // register(...) análogo
}
