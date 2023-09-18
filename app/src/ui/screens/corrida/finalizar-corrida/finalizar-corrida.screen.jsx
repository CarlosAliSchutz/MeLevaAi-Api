import { useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { useFinalizarCorrida } from '../../../../hooks/api';
import { ButtonSecondary, Header } from '../../../components';
import './index.css';

export const FinalizarCorridaScreen = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const infosCorrida = location?.state;
  const { putFinalizarCorrida, corrida } = useFinalizarCorrida();

  function handleClick() {
    putFinalizarCorrida(infosCorrida.id);
  }

  useEffect(() => {
    if (corrida.valorCorrida != undefined) {
      navigate('/corrida', { state: corrida });
    }
  }, [corrida]);

  return (
    <>
      <Header />

      <div className="finalizar-corrida-screen__container">
        <h1>Se deslocando para o destino solicitado...</h1>
        <ButtonSecondary onClick={handleClick}>Finalizar</ButtonSecondary>
      </div>
    </>
  );
};
