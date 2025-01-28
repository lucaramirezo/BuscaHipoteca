package grupo_nueve.buscahipotecas.Jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY="d6ee557ddfb146c5110cb3d72dffb3677a7351940f3082e4b68dcbd18e25d4906f81f035df9dc7d868b5128c65c6d96a8975f28288f3f2a8892f4dae7f2a8fd6f2917a5db17c39b98adb3fd10eaadc9a239c4b784a1e673fd256fb2b82ef3b8e1c37e2ad270c8d43f5646af50f2baef30222ce7044599e4bc37f28f633224594fed16d7822ed29859601fefbf398fceb2316258f4435e581a2137e83a63f51c45341f80fe269dfb1986180537cb99b6474455ffdac20dde3ed9c71dca0ddedeb1e0ce5c625b7f32349d9b92ca8df26c4b238c2f35959b330cf149b8c1821ec356a52711e38e3d6a581e2070c86c77453958114acc8cefb80cea4af81cc2f7693";

    public String getToken(UserDetails usuario)
    {
        return getToken(new HashMap<>(), usuario);
    }
        
    
    private String getToken(Map<String,Object> extraClaims, UserDetails usuario) {
        return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(usuario.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();
    }


    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String getEmailFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }


    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String email = getEmailFromToken(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token)
    {
        return Jwts
            .parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }
    
    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }

}
