import Ilustracao from '../../../assets/imgs/Ilustracao.jpeg';
import { Button } from '../../components/button/button.component';
import { Header } from '../../components/header/header.component';
import './index.css';

export const HomeScreen = () => {
  return (
    <section className="home__background">
      <Header
        children={
          <ul className="home__menu">
            <li className="home__link">
              <Button link={'/passageiro/cadastro'}>Novo passageiro?</Button>
            </li>
            <li>
              <Button link={'/passageiro'}>Já tem cadastro?</Button>
            </li>
          </ul>
        }
        extraHeaderClass={'home__header'}
      />
      <div className="home__conteudo">
        <h1 className="home__texto">
          Bem-vindo ao MELEVAAI Plataforma que te ajuda a chegar ao seu destino!
        </h1>
        <img src={Ilustracao} alt="" />
      </div>
      <div className="home__button__motorista">
        <Button link={'/motorista'}>Motorista</Button>
      </div>
    </section>
  );
};
