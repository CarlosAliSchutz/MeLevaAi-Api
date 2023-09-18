import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useAvaliarPassageiro = () => {
  const { handleRequest } = useRequest();

  function putAvaliarPassageiro(score, corridaId) {
    handleRequest(
      axiosInstance.put('/motoristas/avaliarPassageiro', {
        score,
        corridaId,
      })
    );
  }
  return { putAvaliarPassageiro };
};
