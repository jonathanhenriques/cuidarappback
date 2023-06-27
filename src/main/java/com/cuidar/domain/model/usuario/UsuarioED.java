package com.cuidar.domain.model.usuario;

import com.cuidar.domain.model.grupo.GrupoED;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_USUARIO")
// UserDetails define os atributos e métodos que o Spring Security usa para autenticar e autorizar usuários
// return true pois não temos regras de negócio para bloquear usuários
public class UsuarioED implements UserDetails {


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "SENHA")
    private String senha;

    @ManyToMany
    @JoinTable(name = "tb_usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private List<GrupoED> grupos = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // retorna uma lista de autoridades que o usuário possui
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

//import java.time.LocalDateTime;
//        import java.util.ArrayList;
//        import java.util.List;
//
//        import javax.persistence.Column;
//        import javax.persistence.Entity;
//        import javax.persistence.GeneratedValue;
//        import javax.persistence.GenerationType;
//        import javax.persistence.Id;
//        import javax.persistence.JoinColumn;
//        import javax.persistence.JoinTable;
//        import javax.persistence.ManyToMany;
//
//        import org.hibernate.annotations.CreationTimestamp;
//
//        import lombok.Data;
//        import lombok.EqualsAndHashCode;
//
//@Data
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@Entity
//@Table(name = "TB_USUARIO")
//public class UsuarioED {
//
//    @EqualsAndHashCode.Include
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String nome;
//
//    @Column(nullable = false)
//    private String email;
//
//    @Column(nullable = false)
//    private String senha;
//
//    @CreationTimestamp
//    @Column(nullable = false, columnDefinition = "datetime")
//    private LocalDateTime dataCadastro;
//
//    @ManyToMany
//    @JoinTable(name = "tb_usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"),
//            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
//    private List<GrupoED> grupos = new ArrayList<>();
//
//}
