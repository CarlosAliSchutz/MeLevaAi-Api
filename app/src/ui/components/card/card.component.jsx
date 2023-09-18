import userImg from '../../../assets/imgs/user.png';
import './index.css';

export const Card = ({
  nome,
  score,
  saldo,
  spanTitle,
  spanContent,
  onClick,
}) => {
  return (
    <div className="card__container" onClick={onClick}>
      <img src={userImg} alt="Ícone do usuário" />
      <div className="card__center">
        <h2>{nome}</h2>
        <div className="card__data-or-car">
          <span>{spanTitle}</span>
          <span>{spanContent}</span>
        </div>
      </div>
      <div className="card__score-saldo">
        <span>★ {score}</span>
        <div className="card__saldo">
          <span>Saldo</span>
          <span>R$ {saldo}</span>
        </div>
      </div>
    </div>
  );
};
