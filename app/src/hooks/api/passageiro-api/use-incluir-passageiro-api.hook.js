import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useIncluirPassageiro = () => {
  const { handleRequest, data, error } = useRequest();

  function postPassageiros(nome, dataNascimento, cpf, saldo) {
    handleRequest(
      axiosInstance.post('/passageiros', {
        nome,
        dataNascimento,
        cpf,
        saldo,
      })
    );
  }
  return { postPassageiros, idPassageiro: data };
};
