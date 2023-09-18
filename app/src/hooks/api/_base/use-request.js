import { useState } from 'react';
import { useToastr } from '../../use-toastr/use-toastr.hook';

export const useRequest = () => {
  const [data, setData] = useState([]);
  const [error, setError] = useState();
  const showToastr = useToastr();

  async function handleRequest(promise) {
    try {
      const response = await promise;
      setData(response.data);
    } catch (error) {
      console.log(error.response.data.message);
      showToastr(error.response?.data?.message);
    }
  }

  return { handleRequest, data, error };
};
