select p.nome as 'produto', ps.nome as 'comprador', m.quantidade, m.valorUnitario, (m.quantidade * m.valorUnitario) as 'valor total' 
  from movimento m, Produto p, Pessoa ps 
 where p.idProduto = m.fk_Produto_idPoduto and
	   ps.idPessoa = m.fk_Pessoa_idPessoa and
	   tipo = 'S'