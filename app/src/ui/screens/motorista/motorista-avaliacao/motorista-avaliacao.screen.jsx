import { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import { useAvaliarPassageiro, useCorrida } from '../../../../hooks/api';
import { Header } from '../../../components';
import { AvaliacaoNota } from '../../../components/avaliacao/avaliacao';
import './index.css';

export const MotoristaAvaliarScreen = () => {
  const location = useLocation();
  const motorista = location?.state;
  const { getCorridas, corridas } = useCorrida();
  const { putAvaliarPassageiro } = useAvaliarPassageiro();
  const [corridasMotorista, setCorridasMotorista] = useState();
  const [corridaSelecionada, setCorridaSelecionada] = useState();

  const [nota, setNota] = useState();
  const NOTA_ESTRELAS = [1, 2, 3, 4, 5];
  const activeStar = {
    fill: 'black',
  };

  function notasIndex(key) {
    setNota(key);

    if (corridaSelecionada) {
      putAvaliarPassageiro(key, corridaSelecionada);
    }
  }

  useEffect(() => {
    getCorridas();
  }, []);

  useEffect(() => {
    const motoristaNome = motorista?.nome;
    const corridasDoMotorista = corridas?.filter((corrida) =>
      motoristaNome?.includes(corrida?.motorista)
    );
    setCorridasMotorista(corridasDoMotorista);
  }, [corridas]);

  function corridaSelecionado(corrida) {
    setCorridaSelecionada(corrida.id);

    if (nota) {
      putAvaliarPassageiro(nota, corrida.id);
    }
  }

  return (
    <section>
      <Header extraHeaderClass={'avaliacao__header'} />
      <div className="avaliacao__painel">
        <h1>Viagens de {motorista.nome}</h1>

        <div className="container">
          <div className="stars">
            {NOTA_ESTRELAS?.map((grade, index) => (
              <AvaliacaoNota
                index={grade}
                key={grade}
                changeGradeIndex={notasIndex}
                style={nota > index ? activeStar : {}}
              />
            ))}
          </div>
        </div>
        <div className="avaliar__corridas">
          {corridasMotorista?.map((corrida) => (
            <div
              className="avaliacao__box"
              key={corrida?.id}
              name={corrida?.id}
              onClick={() => corridaSelecionado(corrida)}
            >
              <div>
                <h2>Passageiro {corrida?.passageiro}</h2>
                <h2>Selecione e de uma nota</h2>
                <p>Status da Corrida {corrida?.status}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};
