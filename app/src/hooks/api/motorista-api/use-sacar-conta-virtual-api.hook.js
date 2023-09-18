import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useSacarContaMotorista = () => {
  const { handleRequest } = useRequest();

  function putSacarContaMotorista(motoristaId, saldo) {
    handleRequest(
      axiosInstance.put(`/motoristas/${motoristaId}/conta-virtual`, {
        saldo,
      })
    );
  }
  return { putSacarContaMotorista };
};
