select p.nome, (SUM(m.valorUnitario * m.quantidade) / SUM(m.quantidade)) as 'media ponderada'
  from movimento m, Produto p
 where m.fk_Produto_idPoduto = p.idProduto
group by p.nome