package com.inn.pizza.pojo;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@NamedQuery(name = "User.findByEmailId", query = "SELECT u FROM User u WHERE u.email = :email")

@Data
@Entity
@Table(name = "tb_usuario")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "contato")
	private String contato;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "status_user")
	private String status;
	
	
}
