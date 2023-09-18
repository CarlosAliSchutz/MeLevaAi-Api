import './index.css';

export const Input = ({
  onChange,
  id,
  type,
  name,
  value,
  label,
  placeholder,
}) => {
  return (
    <div className="input__wrapper">
      {label ? (
        <label htmlFor={name} className="input__label">
          {label}
        </label>
      ) : null}
      <input
        id={id}
        type={type}
        className="input__input"
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        name={name}
        required
      />
    </div>
  );
};
