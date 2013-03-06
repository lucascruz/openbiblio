package br.com.openbiblio.soft;

	import java.util.Date;


	public class Emprestimo {


		private EmprestimoID emprestimoID;
		
		private Date dtEmprestimo;

		private Date dtDevolucao;
		
		
		public Emprestimo() { }
		
		public EmprestimoID getEmprestimoID() {
			return emprestimoID;
		}
		
		public void setEmprestimoID(EmprestimoID emprestimoID) {
			this.emprestimoID = emprestimoID;
		}
		
		public Date getDtEmprestimo() {
			return dtEmprestimo;
		}
		
		public void setDtEmprestimo(Date dtEmprestimo) {
			this.dtEmprestimo = dtEmprestimo;
		}

		public Date getDtDevolucao() {
			return dtDevolucao;
		}
		
		public void setDtDevolucao(Date dtDevolucao) {
			this.dtDevolucao = dtDevolucao;
		}
		
	}



