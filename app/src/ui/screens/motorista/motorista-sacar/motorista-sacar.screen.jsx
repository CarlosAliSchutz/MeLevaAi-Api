import { useState } from 'react';
import { useLocation } from 'react-router-dom';
import { useSacarContaMotorista } from '../../../../hooks/api';
import { ButtonSecondary, Header } from '../../../components';
import './index.css';

export const MotoristaSacarScreen = () => {
  const location = useLocation();
  const motorista = location?.state;
  const [sacar, serSacar] = useState(0);
  const { putSacarContaMotorista } = useSacarContaMotorista();

  function valorSacar(event) {
    event.preventDefault();
    serSacar(event.target.value);
  }

  function handleSacarMotorista() {
    putSacarContaMotorista(motorista.id, sacar);
  }

  const formatarReal = Intl.NumberFormat('pt-br', {
    style: 'currency',
    currency: 'BRL',
  }).format(sacar);

  return (
    <section>
      <Header extraHeaderClass={'sacar__header'} />
      <div className="sacar">
        <p className="sacar__cash">Melevaai Cash</p>
        <h1 className="sacar__valor">{formatarReal}</h1>
        <h1>{motorista && motorista.nome} quanto deseja sacar ?</h1>
        <input required type="number" onChange={valorSacar} />
        <ButtonSecondary color={'preto'} onClick={handleSacarMotorista}>
          Resgatar saldo
        </ButtonSecondary>
      </div>
    </section>
  );
};
