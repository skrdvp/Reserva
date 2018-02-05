package br.edu.ifal.proint.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifal.proint.model.Usuario;
import br.edu.ifal.proint.service.UsuarioService;
import br.edu.ifal.proint.util.FacesUtil;

@Named
@ViewScoped
public class ListaUsuarioMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioService usuarioService;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	private List<Usuario> usuariosSelecionados = new ArrayList<>();
	
	@PostConstruct
	public void inicializar () {
		usuarios = usuarioService.listUsuarios();
	}
	
	public void excluirSelecionados() {
		for (Usuario usuario : usuariosSelecionados) {
			usuarioService.excluir(usuario);
			usuarios.remove(usuario);
		}		
		FacesUtil.addInfoMessage("Usuário(s) excluido(s) com sucesso!");		
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosSelecionados() {
		return usuariosSelecionados;
	}

	public void setUsuariosSelecionados(List<Usuario> usuariosSelecionados) {
		this.usuariosSelecionados = usuariosSelecionados;
	}
	
	

}
