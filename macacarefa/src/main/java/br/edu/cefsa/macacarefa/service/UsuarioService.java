package br.edu.cefsa.macacarefa.service;

import br.edu.cefsa.macacarefa.model.Usuario;
import br.edu.cefsa.macacarefa.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    

    
    @Override
    public Usuario loadUserByUsername(String nome) throws UsernameNotFoundException {
        return usuarioRepository.findByNome(nome);
    }

    public Usuario save(Usuario usuario) {
        // Criptografa a senha antes de salvar
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public boolean existsByNomeOrEmail(String username, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Usuario findByUsername(String username){
        return usuarioRepository.findByNome(username);
    }
}

