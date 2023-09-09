select u.login, SUM(m.valorUnitario)
  from movimento m, Usuario u
 where m.fk_Usuario_IdUsuario = u.IdUsuario
   and tipo = 'E'
group by u.login