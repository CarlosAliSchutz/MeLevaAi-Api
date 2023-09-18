import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const usePassageiro = () => {
  const { handleRequest, data } = useRequest();

  function getPassageiros() {
    handleRequest(axiosInstance.get('/passageiros'));
  }
  return { getPassageiros, passageiros: data.content };
};
