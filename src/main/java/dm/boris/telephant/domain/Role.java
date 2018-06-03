package dm.boris.telephant.domain;

import org.springframework.security.core.GrantedAuthority;

//different roles
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}