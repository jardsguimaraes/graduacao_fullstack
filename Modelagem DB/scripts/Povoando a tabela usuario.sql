insert into dbo.usuario (idUsuario, login, senha) values (next value for dbo.seq_usuario, 'op1', 'op1');
insert into dbo.usuario (idUsuario, login, senha) values (next value for dbo.seq_usuario, 'op2', 'op2');
select * from dbo.usuario;