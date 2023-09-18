import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useFinalizarCorrida = () => {
  const { handleRequest, data } = useRequest();

  function putFinalizarCorrida(idCorrida) {
    handleRequest(axiosInstance.put(`/corridas/${idCorrida}/finalizar`));
  }
  return { putFinalizarCorrida, corrida: data };
};
