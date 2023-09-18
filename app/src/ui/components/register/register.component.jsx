import { ButtonSecondary } from '../button-secondary/button-secondary.component';
import './index.css';

export const Register = ({ nome, dataNascimento, cpf, saldo, botao, page }) => {
  return (
    <section className="menu__cadastro">
      <h1 className="menu__titulo">Perfil</h1>
      <form className="menu__dados">
        <h1 className="menu__text">Nome</h1>
        <input required type="text" onChange={nome} />
        <h1 className="menu__text">Data Nascimento</h1>
        <input required type="date" onChange={dataNascimento} />
        <h1 className="menu__text">CPF</h1>
        <input required type="text" onChange={cpf} />
        <h1 className="menu__text">Saldo</h1>
        <input required type="text" onChange={saldo} />
      </form>
      <ButtonSecondary color={'preto'} onClick={botao}>
        Criar perfil
      </ButtonSecondary>
    </section>
  );
};
