package com.cuidar.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


//@Entity
//@Table(name = "contato")
@Data
@Embeddable
public class ContatoED {

//    @Id
//    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
//    @Column(name = "CONT_ID")
//    private Long id;

    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{5}-\\d{4}")
    @Column(name = "CONT_CELULAR", nullable = true, length = 15)
    private String celular;

    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4}-\\d{4}")
    @Column(name = "CONT_TELEFONE", nullable = true, length = 14)
    private String telefone;

    @Column(name = "CONT_FACEBOOK", nullable = true, length = 50)
    private String contFacebook;

    @Column(name = "CONT_INSTAGRAM", nullable = true, length = 50)
    private String contInstagram;

    @Email(message = "campo.email")
    @Column(name = "CONT_EMAIL", nullable = true, length = 50)
    private String email;




}
