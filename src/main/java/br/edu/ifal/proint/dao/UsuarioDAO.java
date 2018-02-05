package br.edu.ifal.proint.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.ifal.proint.exception.NegocioException;
import br.edu.ifal.proint.model.Usuario;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Usuario salvar (Usuario usuario) {
		return manager.merge(usuario);
	}
	
	public void excluir(Usuario usuario) {
		try {
			usuario = porCodigo(usuario.getCodigo());
			manager.remove(usuario);
			manager.flush();
		} catch (Exception e) {
			throw new NegocioException("Não foi possivel excluir o usuário!");
		}
	}

	public Usuario porCodigo(Long codigo) {
		return manager.find(Usuario.class, codigo);
	}
	
	public List<Usuario> listUsuarios() {
		return manager.createNativeQuery("SELECT * FROM usuario", Usuario.class).getResultList();
		//return manager.createNativeQuery("SELECT codigo, cpf, nome, email, telefone, funcao, cargo, ultimo_acesso FROM usuario", Usuario.class).getResultList();
	}
}
