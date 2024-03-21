package com.pethat.backendk.controller

import com.pethat.backendk.model.Cliente
import com.pethat.backendk.service.ClienteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("api/clientes")
class ClienteController(private val clienteService: ClienteService) {

    @PostMapping
    fun cadastroCliente (@RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        val criarCliente = clienteService.cadastroCliente(cliente)
        return ResponseEntity(criarCliente,HttpStatus.CREATED)
    }

    @GetMapping("/{email}")
    fun buscarPorEmail(@PathVariable email: String): ResponseEntity<Cliente> {
        val buscarCliente = clienteService.encontrarPorEmail(email) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(buscarCliente)
    }

    @PutMapping("/alterar/{email}")
    fun atualizarClientePorEmail(@PathVariable email: String, @RequestBody clienteAtualizado: Cliente, uriBuilder : UriComponentsBuilder) : ResponseEntity<Cliente> {
        val cliente = clienteService.atualizarCliente(email, clienteAtualizado)
        val baseUri = uriBuilder.replacePath(null).build().toString()
        val uri = "${baseUri}/${cliente.email}"
        return ResponseEntity.created(URI.create(uri)).body(cliente)
    }

    @DeleteMapping("/excluir/{email}")
    fun deletarClientePorEmail(@PathVariable email: String): ResponseEntity<Cliente> {
        return try {
            val clienteDeletado = clienteService.deletarCliente(email)
            ResponseEntity.ok(clienteDeletado)
        } catch (ex: IllegalStateException) {
            throw IllegalStateException("O cliente solicitado não existe.")
        }
    }

}