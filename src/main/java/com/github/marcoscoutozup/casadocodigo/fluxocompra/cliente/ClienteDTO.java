package com.github.marcoscoutozup.casadocodigo.fluxocompra.cliente;

import com.github.marcoscoutozup.casadocodigo.estado.Estado;
import com.github.marcoscoutozup.casadocodigo.pais.Pais;
import com.github.marcoscoutozup.casadocodigo.validator.cpfoucnpj.CpfOuCpj;
import com.github.marcoscoutozup.casadocodigo.validator.exists.Exists;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class ClienteDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfOuCpj
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @Exists(classe = Pais.class)
    private UUID pais;

    private UUID estado;

    @NotBlank
    private String telefone;

            //1
    public Cliente toModel(EntityManager entityManager){
        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone);

        //2
        Pais pais = entityManager.find(Pais.class, this.pais);
        cliente.setPais(pais);

        //3
        if(this.estado != null){
            //4
            Estado estado = entityManager.find(Estado.class, this.estado);
            cliente.setEstado(estado);
        }

        return cliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UUID getPais() {
        return pais;
    }

    public void setPais(UUID pais) {
        this.pais = pais;
    }

    public UUID getEstado() {
        return estado;
    }

    public void setEstado(UUID estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
