import { Link } from 'react-router-dom'

export default function Nav() {
  return (
    <nav className="header__nav">
      <ul className="nav__container">
        <li className="nav__item"><Link className="nav__link" to="/">Inicio</Link></li>
        <li className="nav__item"><Link className="nav__link" to="/map">Mapa</Link></li>
        <li className="nav__item"><Link className="nav__link" to="/notice">Avisos</Link></li>
        <li className="nav__item"><Link className="nav__link" to="/contact">Contacto</Link></li>
      </ul>
    </nav>
  )
}
