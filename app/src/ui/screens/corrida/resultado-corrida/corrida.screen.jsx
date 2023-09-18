import { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { useAvaliarMotorista } from '../../../../hooks/api';
import { Header } from '../../../components';
import { AvaliacaoNota } from '../../../components/avaliacao/avaliacao';
import './index.css';

export const CorridaScreen = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const custoCorrida = location?.state;
  const [nota, setNota] = useState();
  const { putAvaliarMotorista } = useAvaliarMotorista();

  const NOTA_ESTRELAS = [1, 2, 3, 4, 5];
  const activeStar = {
    fill: 'white',
  };

  function notasIndex(key) {
    setNota(key);
    putAvaliarMotorista(key, custoCorrida.corridaId);
    navigate('/');
  }

  const formatarReal = Intl.NumberFormat('pt-br', {
    style: 'currency',
    currency: 'BRL',
  }).format(custoCorrida.valorCorrida);

  return (
    <section>
      <Header extraHeaderClass={'corrida__resultado__header'} />
      <div className="corrida__resultado">
        <h1 className="corrida__resultado__titulo">Chegou ao seu destino</h1>
        <div className="corrida__resultado__box">
          <div className="container ">
            <div>
              <h1>Como você avalia o motorista?</h1>
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
          <div>
            <h1>Tempo total da corrida: {custoCorrida.tempoCorrida} Min</h1>
            <h1>Custo da viagem: {formatarReal}</h1>
          </div>
        </div>
      </div>
    </section>
  );
};
