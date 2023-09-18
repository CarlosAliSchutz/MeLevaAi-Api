import { useEffect, useState } from 'react';
import { useMotorista } from '../../../../hooks/api';
import { Button, Card, Header } from '../../../components';
import './index.css';

export const MotoristaScreen = () => {
  const { getMotoristas, motoristas } = useMotorista();
  const [motorista, setMotorista] = useState({});

  useEffect(() => {
    getMotoristas();
  }, []);

  function motoristaSelecionado(motorista) {
    setMotorista(motorista);
  }

  return (
    <div className="motorista-screen__container">
      <Header />
      <div className="motorista-screen__wrapper">
        <h1>Menu Motoristas</h1>
        <div className="motorista-screen__motoristas-wrapper">
          {motoristas &&
            motoristas.map((motorista) => (
              <Card
                key={motorista.id}
                nome={motorista.nome}
                score={motorista.score}
                saldo={motorista.saldo}
                spanTitle="Veículo"
                spanContent={motorista.modelo}
                onClick={() => motoristaSelecionado(motorista)}
              ></Card>
            ))}
        </div>

        <div className="motorista-screen__menu">
          <Button
            disabled={!motorista.id && true}
            state={motorista}
            link={'/motorista/avaliar-passageiro'}
          >
            Avaliar passageiro
          </Button>
          <Button
            disabled={!motorista.id && true}
            state={motorista}
            link={'/motorista/sacar'}
          >
            Sacar
          </Button>
        </div>
        <p className='motorista-selecionado'>Motorista Selecionado: {motorista.nome}</p>
      </div>
    </div>
  );
};
