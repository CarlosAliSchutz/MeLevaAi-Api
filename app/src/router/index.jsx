import { createBrowserRouter } from 'react-router-dom';
import {
  CorridaScreen,
  FinalizarCorridaScreen,
  HomeScreen,
  IniciarCorridaScreen,
  MotoristaAvaliarScreen,
  MotoristaSacarScreen,
  MotoristaScreen,
  PassageiroCadastroScreen,
  PassageiroDepositar,
  PassageiroScreen,
  SolicitarCorridaScreen,
} from '../ui/screens';

export const router = createBrowserRouter([
  {
    path: '/',
    element: <HomeScreen />,
  },
  {
    path: '/motorista',
    element: <MotoristaScreen />,
  },
  {
    path: '/motorista/sacar',
    element: <MotoristaSacarScreen />,
  },
  {
    path: '/motorista/avaliar-passageiro',
    element: <MotoristaAvaliarScreen />,
  },
  {
    path: '/passageiro',
    element: <PassageiroScreen />,
  },
  {
    path: '/passageiro/cadastro',
    element: <PassageiroCadastroScreen />,
  },
  {
    path: '/passageiro/depositar',
    element: <PassageiroDepositar />,
  },
  {
    path: '/solicitar-corrida',
    element: <SolicitarCorridaScreen />,
  },
  {
    path: '/iniciar-corrida',
    element: <IniciarCorridaScreen />,
  },
  {
    path: '/finalizar-corrida',
    element: <FinalizarCorridaScreen />,
  },
  {
    path: '/corrida',
    element: <CorridaScreen />,
  },
]);
