import { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { useSolicitarCorrida } from '../../../../hooks/api/passageiro-api/use-solicitar-corrida-api.hook';
import { ButtonSecondary, Header, Input } from '../../../components';
import './index.css';

export const SolicitarCorridaScreen = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const idPassageiro = location?.state;
  const [coordenadas, setCoordenadas] = useState({
    inicioX: '',
    inicioY: '',
    fimX: '',
    fimY: '',
  });
  const { postSolicitarCorrida, motorista } = useSolicitarCorrida();

  useEffect(() => {
    if (motorista.id !== undefined) {
      navigate('/iniciar-corrida', { state: motorista });
    }
  }, [motorista]);

  function handleChange({ target }) {
    const { name, value } = target;
    setCoordenadas((oldCoordenadas) => ({ ...oldCoordenadas, [name]: value }));
  }

  function handleSubmit(event) {
    event.preventDefault();

    try {
      postSolicitarCorrida(
        idPassageiro,
        coordenadas.inicioX,
        coordenadas.inicioY,
        coordenadas.fimX,
        coordenadas.fimY
      );
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <>
      <Header />
      <div className="solicitar-corrida-screen__container">
        <h1>Solicitar Corrida</h1>
        <form
          onSubmit={handleSubmit}
          className="solicitar-corrida-screen__form"
        >
          <label>Local de Partida</label>
          <div className="solicitar-corrida-screen__inputs">
            <Input
              id="inicioX"
              type="number"
              name="inicioX"
              placeholder="Coordenadas X"
              value={coordenadas.inicioX}
              onChange={handleChange}
            />
            <Input
              id="inicioY"
              type="number"
              name="inicioY"
              placeholder="Coordenadas Y"
              value={coordenadas.inicioY}
              onChange={handleChange}
            />
          </div>
          <label>Para Onde?</label>
          <div className="solicitar-corrida-screen__inputs">
            <Input
              id="fimX"
              type="number"
              name="fimX"
              placeholder="Coordenadas X"
              value={coordenadas.fimX}
              onChange={handleChange}
            />
            <Input
              id="fimY"
              type="number"
              name="fimY"
              placeholder="Coordenadas Y"
              value={coordenadas.fimY}
              onChange={handleChange}
            />
          </div>
          <ButtonSecondary color="preto">Solicitar Motorista</ButtonSecondary>
        </form>
      </div>
    </>
  );
};
