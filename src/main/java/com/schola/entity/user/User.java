package com.schola.entity.user;

import com.schola.entity.location.Location;
import com.schola.shared.utils.BCryptManagerUtil;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
@AllArgsConstructor
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long idUser;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @NotNull
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinTable(
            indexes = {@Index(name = "INDEX_USER_ROLE", columnList = "id_user")},
            name = "roles",
            joinColumns = @JoinColumn(name = "id_user")
    )
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<Role> roles;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "UserLocation",
            joinColumns = @JoinColumn(name = "id_user",insertable = true, updatable = true),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<Location> favoritesLocations = new ArrayList<>();

    public User() {
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.roles = Collections.singletonList(Role.USER);
    }

    public User(String username, String password, String firstname, String lastname, Collection<Role> roles) {
        this.username = username;
        this.password = BCryptManagerUtil.passwordencoder().encode(password);
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(getRoles().stream()
                .map(Enum::name).collect(Collectors.toList()));
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    public void setPassword(String password) {
        if (!password.isEmpty()) {
            this.password = BCryptManagerUtil.passwordencoder().encode(password);
        }
    }

    public void addLocation(Location location) {
        this.favoritesLocations.add(location);
        location.getUsers().add(this);
    }

    public void removeLocation(Location location) {
        this.favoritesLocations.remove(location);
        location.getUsers().remove(this);
    }
}
