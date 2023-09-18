import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useMotorista = () => {
  const { handleRequest, data } = useRequest();

  function getMotoristas() {
    handleRequest(axiosInstance.get('/motoristas'));
  }
  return { getMotoristas, motoristas: data };
};
