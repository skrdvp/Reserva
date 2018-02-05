package br.edu.ifal.proint.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifal.proint.model.Usuario;
import br.edu.ifal.proint.service.UsuarioService;

@Named
@ViewScoped
public class CadastroUsuarioMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario =  new Usuario();
	
	private Long codigoUsuario;
	
	@Inject
	private UsuarioService usuarioService;
	
	public void inicializar() {
		if(codigoUsuario != null) {
			usuario = usuarioService.porCodigo(codigoUsuario);
		}
	}
	
	public String salvar() {
		usuarioService.salvar(usuario);
		return "lista-usuario.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		usuarioService.excluir(usuario);
		return "lista-usuario.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	
}
