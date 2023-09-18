import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useIncluirPassageiro } from '../../../../hooks/api';
import { Header } from '../../../components';
import { Register } from '../../../components/register/register.component';

export const PassageiroCadastroScreen = () => {
  const navigate = useNavigate();
  const { postPassageiros, idPassageiro } = useIncluirPassageiro();
  const [nome, setNome] = useState();
  const [dataNascimento, setDataNascimento] = useState();
  const [cpf, setCpf] = useState();
  const [saldo, setSaldo] = useState();

  function buscarNome(event) {
    event.preventDefault();
    setNome(event.target.value);
  }

  function buscarDataNascimento(event) {
    event.preventDefault();
    setDataNascimento(event.target.value);
  }

  function buscarCPF(event) {
    event.preventDefault();
    setCpf(event.target.value);
  }

  function buscarSaldo(event) {
    event.preventDefault();
    setSaldo(event.target.value);
  }

  function handleCadastrarPassageiro() {
    postPassageiros(nome, dataNascimento, cpf, saldo);
    if (nome && dataNascimento && cpf && saldo) {
      navigate('/passageiro');
    }
  }

  return (
    <section>
      <Header />

      <Register
        nome={buscarNome}
        dataNascimento={buscarDataNascimento}
        cpf={buscarCPF}
        saldo={buscarSaldo}
        botao={handleCadastrarPassageiro}
      />
    </section>
  );
};
