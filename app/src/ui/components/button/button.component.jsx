import { Link } from 'react-router-dom';
import './index.css';

export const Button = ({
  children,
  onClick,
  disabled,
  value,
  color,
  link,
  state,
}) => {
  return (
    <Link to={link} state={state}>
      <button
        onClick={onClick}
        disabled={disabled}
        value={value}
        className={`button ${color ? color : ''}`}
      >
        {children}
      </button>
    </Link>
  );
};
