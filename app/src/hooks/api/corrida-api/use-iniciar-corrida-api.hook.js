import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useIniciarCorrida = () => {
  const { handleRequest, data } = useRequest();

  function putIniciarCorrida(idCorrida) {
    handleRequest(axiosInstance.put(`/corridas/${idCorrida}`));
  }
  return { putIniciarCorrida, corrida: data };
};
