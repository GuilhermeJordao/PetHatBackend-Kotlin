package com.pethat.backendk.service

import com.pethat.backendk.model.Cliente
import com.pethat.backendk.repository.ClienteRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class ClienteService(private val repository: ClienteRepository) {

    fun encontrarPorEmail(email: String): Cliente? = repository.findByEmail(email)

    private var passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()

    fun cadastroCliente(cliente: Cliente): Cliente {
        val clienteExistente = repository.findByEmail(cliente.email)
        if (clienteExistente != null) {
            throw IllegalStateException("O email já está cadastrado.")
        } else {
            var encoder = this.passwordEncoder.encode(cliente.senha)
            cliente.senha = encoder
            return repository.insert(cliente)
        }
    }

    fun atualizarCliente(email: String, clienteAtualizado: Cliente): Cliente {
        val clienteExistente = repository.findByEmail(email)

        if (clienteExistente == null) {
            throw IllegalStateException("Cliente não encontrado para o email fornecido: $email")
        }

        // Verifica se a senha foi alterada
        if (clienteExistente.senha != clienteAtualizado.senha) {
            // Criptografa a senha atualizada antes de atribuir ao clienteExistente
            val senhaCriptografada = criptografarSenha(clienteAtualizado.senha)
            clienteExistente.senha = senhaCriptografada
        }

        clienteExistente.nome = clienteAtualizado.nome
        clienteExistente.cpf = clienteAtualizado.cpf
        clienteExistente.email = clienteAtualizado.email

        return repository.save(clienteExistente)
    }

    private fun criptografarSenha(senha: String): String {
        val encoder = BCryptPasswordEncoder()
        return encoder.encode(senha)
    }


    fun deletarCliente(email: String): Cliente {
        val clienteExistente = repository.findByEmail(email)
        if (clienteExistente != null) {
            repository.delete(clienteExistente)
            return clienteExistente
        } else {
            throw IllegalStateException("O cliente solicitado não existe.")
        }
    }
}
