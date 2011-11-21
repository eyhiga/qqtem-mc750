package com.qqtem.LoginManager.client;

import java.util.ArrayList;

public class ListaDenuncias {
	private ArrayList<Integer> ids;
	private ArrayList<Integer> tipos;
	private ArrayList<String> descricoes;
	private ArrayList<String> datas;
	private ArrayList<String> usuarios;
	private ArrayList<Integer> estados; // 0 nao tratado, 1 tratado
	private int numDenuncias;

	public ListaDenuncias() {
		ids = new ArrayList<Integer>();
		descricoes = new ArrayList<String>();
		datas = new ArrayList<String>();
		usuarios = new ArrayList<String>();
		estados = new ArrayList<Integer>();
		tipos = new ArrayList<Integer>();
		numDenuncias = 0;
		
		this.adiciona(2, "Local marcado inexistente", "13/10/2011", "João", false);
		this.adiciona(0, "Comentário inapropriado", "13/10/2011", "Maria", false);
		this.adiciona(0, "Comentário abusivo", "12/10/2011", "Pedro", false);
		this.adiciona(2, "Foto inapropriada", "12/10/2011", "Dexter", true);
	}

	public void adiciona(int tipo, String descr, String data, String usuario, boolean tratado) {
		Integer id = new Integer(numDenuncias);
		ids.add(id);
		descricoes.add(descr);
		datas.add(data);
		usuarios.add(usuario);
		
		Integer t = new Integer(tipo);
		tipos.add(t);
		
		Integer state;
		if (tratado == true) {
			state = new Integer(1);
		}
		else {
			state = new Integer(0); 
		}
		
		estados.add(state);
		numDenuncias++;
	}
	
	public int getNumDenuncias() {
		return numDenuncias;
	}
	
	public int getTipo(int id) {
		if (id >= numDenuncias)
			return -1;
		
		return tipos.get(id);
	}
	
	public String getDescricao(int id) {
		if (id >= numDenuncias)
			return null;
		
		return descricoes.get(id);
		
	}
	
	public String getData(int id) {
		if (id >= numDenuncias)
			return null;
		
		return datas.get(id);
		
	}
	
	public String getUsuario(int id) {
		if (id >= numDenuncias)
			return null;
		
		return usuarios.get(id);
		
	}
	
	public String getEstado(int id) {
		if (id >= numDenuncias)
			return null;
		
		if (estados.get(id) == 0) {
			return "Não Tratado";
		}
		else {
			return "Tratado";
		}
	}
	
	public String getColunaTabela(int id, int row) {
		if (id >= numDenuncias)
			return null;
		if (row >= 4)
			return null;

		switch (row) {
			case 0:
				return getDescricao(id);
			case 1:
				return getData(id);
			case 2:
				return getUsuario(id);
			case 3:
				return getEstado(id);
			default:
				return "erro :P";
		}
	}
	
	public void mudaEstado(int id) {
		if (id >= numDenuncias)
			return;
		
		if (getEstado(id).equalsIgnoreCase("Tratado")) {
			estados.set(id, 0);
			return;
		}
		else {
			estados.set(id, 1);
			return;
		}
	}
	
}
