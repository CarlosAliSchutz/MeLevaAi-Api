import { useEffect } from 'react';
import { useGlobalToastr } from '../../../contexts/toastr/toastr.context';
import './index.css';

const TOAST_DELAY = 5000;
export const Toastr = () => {
  const [message, setMessage] = useGlobalToastr();

  useEffect(() => {
    if (message) {
      setTimeout(() => {
        setMessage('');
      }, TOAST_DELAY);
    }
  }, [message, setMessage]);

  if (!message) return;

  return (
    <div className="toastr">
      <p className="toastr__message">{message}</p>
    </div>
  );
};
