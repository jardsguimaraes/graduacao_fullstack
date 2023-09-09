select *
  from usuario u
 where u.IdUsuario not in(select m.fk_Usuario_IdUsuario
							from movimento m
						   where m.tipo = 'E')