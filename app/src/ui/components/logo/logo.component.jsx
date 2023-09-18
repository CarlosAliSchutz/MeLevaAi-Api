import { Link } from 'react-router-dom';
import icon from '../../../assets/imgs/uber-icon.png';
import './index.css';

export const Logo = () => {
  return (
    <Link to="/">
      <div className="logo">
        <img src={icon} alt="Logo" />
        <h1>MELEVAAI</h1>
      </div>
    </Link>
  );
};
