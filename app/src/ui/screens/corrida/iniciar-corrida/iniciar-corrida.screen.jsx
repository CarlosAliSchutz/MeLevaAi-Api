import { useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import user from '../../../../assets/imgs/user.png';
import { useIniciarCorrida } from '../../../../hooks/api/index';
import { ButtonSecondary, Header } from '../../../components';
import './index.css';

export const IniciarCorridaScreen = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const motorista = location?.state;
  const { putIniciarCorrida, corrida } = useIniciarCorrida();

  useEffect(() => {
    if (corrida.tempoChegadaEstimado !== undefined) {
      const corridaIniciada = { ...motorista, ...corrida };
      navigate('/finalizar-corrida', { state: corridaIniciada });
    }
  }, [corrida]);

  function handleClick() {
    try {
      putIniciarCorrida(motorista.id);
    } catch (error) {}
  }

  return (
    <div className="iniciar-corrida-screen">
      <Header extraHeaderClass={'iniciar-corrida__header'} />
      <div>
        <div className="iniciar-corrida-screen__container">
          <h1>Iniciar Corrida</h1>
          <div className="iniciar-corrida-screen__card">
            <img src={user} alt="Foto do motorista" />
            <h3>Motorista</h3>
            <span>{motorista.nome}</span>
            <span>{motorista.modelo}</span>
            <p>Tempo Estimado</p>
            <p>{motorista.tempoEstimado} minutos</p>
          </div>
          <ButtonSecondary onClick={handleClick}>Iniciar</ButtonSecondary>
        </div>
      </div>
    </div>
  );
};
