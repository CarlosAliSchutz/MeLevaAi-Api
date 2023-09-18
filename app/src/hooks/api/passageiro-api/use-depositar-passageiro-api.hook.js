import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useDepositarPassageiro = () => {
  const { handleRequest } = useRequest();

  function putDepositarPassageiro(idPassageiro, saldo) {
    handleRequest(
      axiosInstance.put(`/passageiros/${idPassageiro}/depositarCredito`, {
        saldo,
      })
    );
  }
  return { putDepositarPassageiro };
};
