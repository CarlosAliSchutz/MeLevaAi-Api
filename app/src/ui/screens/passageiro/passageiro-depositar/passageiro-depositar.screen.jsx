import { useState } from 'react';
import { useLocation } from 'react-router';
import { useDepositarPassageiro } from '../../../../hooks/api';
import { ButtonSecondary, Header } from '../../../components';
import './index.css';

export const PassageiroDepositar = () => {
  const location = useLocation();
  const passageiro = location?.state;
  const [deposito, setDeposito] = useState(0);
  const { putDepositarPassageiro } = useDepositarPassageiro();

  function valorDeposito(event) {
    event.preventDefault();
    setDeposito(event.target.value);
  }

  function handleDepositarPassageiro() {
    putDepositarPassageiro(passageiro.id, deposito);
  }

  const formatarReal = Intl.NumberFormat('pt-br', {
    style: 'currency',
    currency: 'BRL',
  }).format(deposito);

  return (
    <section>
      <Header extraHeaderClass={'deposito__header'} />
      <div className="deposito">
        <p className="deposito__cash">Melevaai Cash</p>
        <h1 className="deposito__valor">{formatarReal}</h1>
        <h1>Quanto deseja depositar para {passageiro && passageiro.nome} ?</h1>
        <input required type="number" onChange={valorDeposito} />
        <ButtonSecondary color={'preto'} onClick={handleDepositarPassageiro}>
          + Adicionar saldo
        </ButtonSecondary>
      </div>
    </section>
  );
};
