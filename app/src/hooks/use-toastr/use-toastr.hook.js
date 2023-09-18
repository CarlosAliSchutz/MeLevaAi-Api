import { useGlobalToastr } from '../../contexts/toastr/toastr.context';

export function useToastr() {
  const [, setToastr] = useGlobalToastr();

  function showToastr(message) {
    setToastr(message);
  }

  return showToastr;
}
