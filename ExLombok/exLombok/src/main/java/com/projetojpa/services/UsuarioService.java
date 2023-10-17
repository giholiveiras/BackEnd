package com.projetojpa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetojpa.entities.Usuario;
import com.projetojpa.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	  @Autowired
	    public UsuarioService(UsuarioRepository usuarioRepository) {
	        this.usuarioRepository = usuarioRepository;
	    }

	    public List<Usuario> buscaTodosUsuarios() {
	        return usuarioRepository.findAll();
	    }

	    public Usuario buscaUsuarioId(Long id) {
	        Optional<Usuario> Usuario = usuarioRepository.findById(id);
	        return Usuario.orElse(null);
	    }

	    public Usuario salvarUsuario(Usuario Usuario) {
	        return usuarioRepository.save(Usuario);
	    }

	    public Usuario alterarUsuario(Long id, Usuario alterarUsuario) {
	        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
	        if (existeUsuario.isPresent()) {
	            alterarUsuario.setId(id);
	            return usuarioRepository.save(alterarUsuario);
	        }
	        return null;
	    }
	    public boolean apagarUsuario(Long id) {
	        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
	        if (existeUsuario.isPresent()) {
	        	usuarioRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}
