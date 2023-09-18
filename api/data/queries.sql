--Listagem do motorista
SELECT 	m.nome,
		m.data_nascimento,
		m.cpf,
		m.score,
		m.saldo,
		v.modelo,
		v.cor,
		l.categoria,
		l.data_vencimento AS LicencaVencimento
FROM motorista m
	LEFT JOIN veiculo v ON v.motorista_id = m.id
	LEFT JOIN licenca_motorista l ON l.motorista_id = m.id;