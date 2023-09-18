import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useSolicitarCorrida = () => {
  const { handleRequest, data } = useRequest();

  function postSolicitarCorrida(id, inicioX, inicioY, fimX, fimY) {
    handleRequest(
      axiosInstance.post(`/passageiros/${id}/solicitarCorrida`, {
        inicioX,
        inicioY,
        fimX,
        fimY,
      })
    );
  }
  return { postSolicitarCorrida, motorista: data };
};
