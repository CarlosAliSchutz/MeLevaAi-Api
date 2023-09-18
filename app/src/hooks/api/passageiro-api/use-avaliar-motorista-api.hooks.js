import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useAvaliarMotorista = () => {
  const { handleRequest } = useRequest();

  function putAvaliarMotorista(score, corridaId) {
    handleRequest(
      axiosInstance.put('/passageiros/avaliarMotorista', {
        score,
        corridaId,
      })
    );
  }
  return { putAvaliarMotorista };
};
