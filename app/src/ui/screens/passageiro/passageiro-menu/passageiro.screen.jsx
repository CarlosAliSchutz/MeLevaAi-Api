import { useEffect, useState } from 'react';
import { usePassageiro } from '../../../../hooks/api';
import { Button, Card, Header } from '../../../components';
import './index.css';

export const PassageiroScreen = () => {
  const { getPassageiros, passageiros } = usePassageiro();
  const [passageiro, setPassageiro] = useState({});

  useEffect(() => {
    getPassageiros();
  }, []);

  function passageiroSelecionado(passageiro) {
    setPassageiro(passageiro);
  }

  return (
    <div className="passageiro-screen__container">
      <Header>
        <Button link={'/passageiro/cadastro'}>Novo Passageiro?</Button>
      </Header>

      <div className="passageiro-screen__wrapper">
        <div className="passageiro-screen__passageiros-wrapper">
          {passageiros &&
            passageiros.map((passageiro) => (
              <Card
                key={passageiro.id}
                nome={passageiro.nome}
                score={passageiro.score}
                saldo={passageiro.saldo}
                spanTitle="Data Nascimento"
                spanContent={passageiro.dataNascimento}
                onClick={() => passageiroSelecionado(passageiro)}
              ></Card>
            ))}
        </div>

        <div className="passageiro-screen__menu">
          <Button
            link="/solicitar-corrida"
            state={passageiro.id}
            disabled={!passageiro.id && true}
          >
            Solicitar Viagem
          </Button>
          <Button
            link="/passageiro/depositar"
            state={passageiro}
            disabled={!passageiro && true}
          >
            Depositar
          </Button>
        </div>
        <p className='passageiro-selecionado'>Passageiro Selecionado: {passageiro.nome}</p>
      </div>
    </div>
  );
};
