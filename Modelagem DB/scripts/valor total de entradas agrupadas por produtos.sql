select p.nome as produto, sum(m.valorUnitario)
  from movimento m, Produto p
 where m.fk_Produto_idPoduto = p.idProduto
   and m.tipo = 'E'
group by p.nome
	   