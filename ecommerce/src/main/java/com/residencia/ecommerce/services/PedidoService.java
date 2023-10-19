package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.repositories.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepo;

    public List<Pedido> listarPedidos() {
		return pedidoRepo.findAll();
	}

	public Pedido buscarPedidoPorId(Long id) {

		return pedidoRepo.findById(id).orElse(null);
	}


	public Pedido salvarPedido(Pedido pedido) {
		return pedidoRepo.save(pedido);
	}

	public Pedido atualizarPedido(Pedido pedido) {
		return pedidoRepo.save(pedido);
	}

	public Boolean deletarPedido(Pedido pedido) {
		if (pedido == null) {
			return false;
		}
		Pedido pedidoExistente = buscarPedidoPorId(pedido.getIdPedido());

		if (pedidoExistente == null) {
			return false;
		}

		pedidoRepo.delete(pedido);

		Pedido pedidoContinuaExistindo = buscarPedidoPorId(pedido.getIdPedido());

		if (pedidoContinuaExistindo == null) {
			return true;
		}

		return false;

	}
}
