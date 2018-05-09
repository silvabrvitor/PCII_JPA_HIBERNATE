package br.com.eteczonaleste.persistence;

import java.util.List;
public interface IDAO<T>{
void persistir(T o) throws Exception;
void excluir(Integer id) throws Exception;
void alterar(T o) throws Exception;
T encontrarPeloId(Integer id) throws Exception;
List<T> Listar() throws Exception;
}
