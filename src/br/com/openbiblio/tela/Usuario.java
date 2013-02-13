
package br.com.openbiblio.tela;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author LUCAS
 */
public class Usuario {
    
    private String nome;
    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    private String endereco;
    public static final String PROP_ENDERECO = "endereco";

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        propertyChangeSupport.firePropertyChange(PROP_ENDERECO, oldEndereco, endereco);
    }
    private String matricula;
    public static final String PROP_MATRICULA = "matricula";

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        String oldMatricula = this.matricula;
        this.matricula = matricula;
        propertyChangeSupport.firePropertyChange(PROP_MATRICULA, oldMatricula, matricula);
    }
    private String telefone;
    public static final String PROP_TELEFONE = "telefone";

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONE, oldTelefone, telefone);
    }
    private String tipoUsuario;
    public static final String PROP_TIPOUSUARIO = "tipoUsuario";

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        String oldTipoUsuario = this.tipoUsuario;
        this.tipoUsuario = tipoUsuario;
        propertyChangeSupport.firePropertyChange(PROP_TIPOUSUARIO, oldTipoUsuario, tipoUsuario);
    }

}
