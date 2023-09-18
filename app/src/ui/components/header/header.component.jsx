import { Logo } from '../logo/logo.component';
import './index.css';

export const Header = ({ children, extraHeaderClass }) => {
  return (
    <header className={`header__container ${extraHeaderClass}`}>
      <div className="header__wrapper">
        <Logo />
        {children}
      </div>
    </header>
  );
};
