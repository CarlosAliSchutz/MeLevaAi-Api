import { axiosInstance } from '../_base/axios-instance';
import { useRequest } from '../_base/use-request';

export const useCorrida = () => {
  const { handleRequest, data } = useRequest();

  function getCorridas() {
    handleRequest(axiosInstance.get('/corridas'));
  }
  return { getCorridas, corridas: data };
};
