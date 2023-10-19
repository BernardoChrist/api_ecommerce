package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.ItemPedido;
import com.residencia.ecommerce.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepo;

    public List<ItemPedido> listarItemPedidos() {
		return itemPedidoRepo.findAll();
	}

	public ItemPedido buscarItemPedidoPorId(Long id) {

		return itemPedidoRepo.findById(id).orElse(null);
	}


	public ItemPedido salvarItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepo.save(itemPedido);
	}

	public ItemPedido atualizarItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepo.save(itemPedido);
	}

	public Boolean deletarItemPedido(ItemPedido itemPedido) {
		if (itemPedido == null) {
			return false;
		}
		ItemPedido itemPedidoExistente = buscarItemPedidoPorId(itemPedido.getIdItemPedido());

		if (itemPedidoExistente == null) {
			return false;
		}

		itemPedidoRepo.delete(itemPedido);

		ItemPedido itemPedidoContinuaExistindo = buscarItemPedidoPorId(itemPedido.getIdItemPedido());

		if (itemPedidoContinuaExistindo == null) {
			return true;
		}

		return false;

	}
}
