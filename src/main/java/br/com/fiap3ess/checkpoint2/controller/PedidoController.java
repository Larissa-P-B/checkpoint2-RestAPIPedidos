package br.com.fiap3ess.checkpoint2.controller;

import br.com.fiap3ess.checkpoint2.model.Pedido;
import br.com.fiap3ess.checkpoint2.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedidos", description = "Endpoints para gerenciamento de pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Operation(
            summary = "Criar pedido",
            description = "Cria um novo pedido informando nome do cliente e valor total"
    )
    @PostMapping
    public ResponseEntity<Object> createOrder(@Valid @RequestBody Pedido pedido) {
        Pedido saved = pedidoService.criarPedido(pedido);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Listar pedidos",
            description = "Retorna todos os pedidos cadastrados"
    )
    @GetMapping
    public List<Pedido> readOrders() {
        return pedidoService.lerTodosPedidos();
    }

    @Operation(
            summary = "Buscar pedido por ID",
            description = "Retorna um pedido específico pelo ID"
    )
    @GetMapping("/{code}")
    public ResponseEntity<Object> getOrder(@PathVariable Long code) {
        try {
            Pedido pedido = pedidoService.procurarPedidoById(code);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Atualizar pedido",
            description = "Atualiza nome do cliente e valor de um pedido existente"
    )
    @PutMapping("/{code}")
    public ResponseEntity<Object> updateOrder(@PathVariable Long code,
                                              @Valid @RequestBody Pedido pedido) {
        try {
            Pedido updated = pedidoService.updatePedido(code, pedido);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Excluir pedido",
            description = "Remove um pedido pelo ID"
    )
    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long code) {
        try {
            pedidoService.deletePedidoById(code);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}