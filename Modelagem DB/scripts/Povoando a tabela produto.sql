insert into Produto(idProduto, nome, quantidade, precoVenda) values (next value for dbo.seq_produto, 'Banana', 100, 5.00);
insert into Produto(idProduto, nome, quantidade, precoVenda) values (next value for dbo.seq_produto, 'Laranja', 500, 2.00);
insert into Produto(idProduto, nome, quantidade, precoVenda) values (next value for dbo.seq_produto, 'Manga', 800, 4.00);
select * from Produto