package anderk222.hellojwt.util;

public interface PropertiesConverter {
    
    public final String JWT_RANDOM_KEY = "#{new anderk222.hellojwt.util.KeyGenerator().jwtRandomKey(256,'${jwt.secret}')}";
    public final String SECRET_KEY = "#{new anderk222.hellojwt.util.KeyGenerator().key(256,'${key.password}')}";

}