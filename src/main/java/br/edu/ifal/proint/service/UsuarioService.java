package br.edu.ifal.proint.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifal.proint.dao.UsuarioDAO;
import br.edu.ifal.proint.model.Usuario;
import br.edu.ifal.proint.util.Transacional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Transacional
	public void salvar(Usuario usuario) {
		if(usuario.isInclusao()) {		
		}
		usuarioDAO.salvar(usuario);
	}
	
	@Transacional
	public void excluir(Usuario usuario) {
		usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> listUsuarios() {
		return usuarioDAO.listUsuarios();
	}
	
	public Usuario porCodigo(Long codigo) {
		return usuarioDAO.porCodigo(codigo);
	}	
}
