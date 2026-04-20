package br.com.fiap3ess.checkpoint2.service;
import br.com.fiap3ess.checkpoint2.model.Pedido;
import br.com.fiap3ess.checkpoint2.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> lerTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido procurarPedidoById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
    }

    public Pedido updatePedido(Long id, Pedido pedido) {
        return pedidoRepository.findById(id).map(existing -> {
            existing.setClienteNome(pedido.getClienteNome());
            existing.setValorTotal(pedido.getValorTotal());
            return pedidoRepository.save(existing);
        }).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
    }

    public void deletePedidoById(Long id) {
        try {
            pedidoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Pedido não encontrado");
        }
    }
}