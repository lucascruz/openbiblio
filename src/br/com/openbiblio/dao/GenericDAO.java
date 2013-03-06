package br.com.openbiblio.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import br.com.openbiblio.log.Persistencia;
import br.com.openbiblio.log.PersistenciaArquivo;


public abstract class GenericDAO <T> {

	public static final boolean debugInfo = false;
	
	static Persistencia factory = null;
	private Class<T> classe;

	static {
		//factory = PersistenciaArquivo("Biblioteca");
	}

	public GenericDAO(){

		Class<?> thisClass = getClass();
		if (debugInfo) {
			System.out.println(thisClass);
		}
		ParameterizedType t =
			(ParameterizedType) thisClass.getGenericSuperclass();
		Type t2 = t.getActualTypeArguments()[0];
		if (debugInfo) {
			System.out.println(t2);
		}
		this.classe = (Class<T>) t2;
	}

	public T localizar(int id) {

		T obj = null;

		try {

	

		} catch (Exception e) {


		} finally {


		}

		return obj;
	}

	public List<T> listar() {

		List<T> list = null;

		try {


		} catch (Exception e) {


		} finally {

		}

		return list;
	}


	public boolean inserir(T obj) {

		boolean result = false;
		
		try {



		} catch (Exception e) {


		} finally {


		}
		
		return result;
	}

	public boolean excluir(int id) {

		boolean result = false;

		try {

		} catch (Exception e) {


		} finally {

		}
		
		return result;
	}
}
