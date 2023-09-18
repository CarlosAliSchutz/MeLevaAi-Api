import './index.css';

export const ButtonSecondary = ({
  children,
  onClick,
  disabled,
  value,
  color,
}) => {
  return (
    <button
      onClick={onClick}
      disabled={disabled}
      value={value}
      className={`button-secondary ${color ? color : ''}`}
    >
      {children}
    </button>
  );
};
